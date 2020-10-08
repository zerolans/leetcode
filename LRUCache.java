import java.util.HashMap;
import java.util.Map;



/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */
// @lc code=start
/*
问题描述：
1. 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。

2. 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

3. 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？
*/

public class LRUCache {

    int capacity;
    HashMap<Integer, LinkEntry> map;
    LinkEntry head;
    LinkEntry tail;


    public static void main(String[] args){
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));        // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, LinkEntry>(capacity, 0.75f);

        head = new LinkEntry(0, 0);
        tail = new LinkEntry(0, 0);

        head.prev = tail;
        head.next = tail;

        tail.prev = head;
        tail.next = head;
    }

    public void put(int key, int value){

        LinkEntry entry = null;

        if(map.containsKey(key)) {
            entry = map.get(key);
            entry.value = value;
            moveToTail(entry);
        } else {
            entry = new LinkEntry(key, value);
            if(shouldRemoveEldest()) {
                removeEntry(head.next);
            }
            addToTail(entry);
        }
    }

    public int get(int key) {
        int result = -1;
        if (map.containsKey(key)){
            LinkEntry entry = map.get(key);
            result = entry.value;
            moveToTail(entry);
        }
        return result;
    }

    private void addToTail(LRUCache.LinkEntry entry) {
        LinkEntry oldTail = tail.prev;

        oldTail.next = entry;
        entry.prev = oldTail;

        tail.prev = entry;
        entry.next = tail;

        map.put(entry.key, entry);
    }

    private void removeEntry(LRUCache.LinkEntry entry) {
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;

        map.remove(entry.key);
    }

    private boolean shouldRemoveEldest() {
        return map.size() >= capacity;
    }

    private void moveToTail(LRUCache.LinkEntry entry) {
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;

        LinkEntry oldTail = tail.prev;
        oldTail.next = entry;
        entry.prev = oldTail;

        entry.next = tail;
        tail.prev = entry;

    }

    class LinkEntry {

        int key;
        int value;
        LinkEntry prev;
        LinkEntry next;

        public LinkEntry(int i, int j) {
            this.key = i;
            this.value = j;
        }
    }

}
// @lc code=end