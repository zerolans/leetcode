import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.processing.SupportedAnnotationTypes;



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


class LRUCache extends LinkedHashMap<Integer, Integer> {

    int capacity ;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry entry) {
        return this.size() > capacity;
    } 
}

// public class LRUCache {
//     int capacity;
//     HashMap<Integer, LinkNode> map = null;
//     LinkNode head;
//     LinkNode tail;

//     public LRUCache(int capacity) {
//         this.capacity = capacity;
//         map = new HashMap(capacity, 0.75f);

//         head = new LinkNode(0, 0);
//         tail = new LinkNode(0, 0);

//         head.next = tail;
//         head.prev = tail;

//         tail.next = head;
//         tail.prev = head;
//     }

//     public void put(int key, int value){
//         LinkNode node = null;
//         if (map.containsKey(key)) {
//             node = map.get(key);
//             node.value = value;
//             moveToTail(node);
//         } else {
//             if (map.size() >= capacity) {
//                 removeEldestNode();
//             }
//             node = new LinkNode(key, value);
//             map.put(key, node);
//             addToTail(node);
//         }
//     }

//     public int get(int key) {
//         int result = -1;

//         if(map.containsKey(key)) {
//             LinkNode node = map.get(key);
//             result = node.value;
//             moveToTail(node);
//         }
//         return result;
//     }

//     private void addToTail(LRUCache.LinkNode node) {
//         LinkNode oldTail = tail.prev;
//         oldTail.next = node;
//         node.prev = oldTail;

//         node.next = tail;
//         tail.prev = node;
//     }

//     private void removeEldestNode() {
//         LinkNode eldest = head.next;

//         eldest.prev.next = eldest.next;
//         eldest.next.prev = eldest.prev;

//         map.remove(eldest.key);
//     }

//     private void moveToTail(LRUCache.LinkNode node) {
//         node.prev.next = node.next;
//         node.next.prev = node.prev;

//         tail.prev.next = node;
//         node.prev = tail.prev;

//         node.next = tail;
//         tail.prev = node;
//     }

//     class LinkNode {
//         int key;
//         int value;
//         LinkNode prev;
//         LinkNode next;

//         LinkNode(int key, int value) {
//             this.key = key;
//             this.value =  value;
//         }
//     }

// }
// @lc code=end

