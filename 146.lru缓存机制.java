import java.util.HashMap;
/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache{
    int capacity;
    HashMap<Integer, LinkEntry> map;
    LinkEntry head;
    LinkEntry tail;

    public LRUCache(final int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        tail = new LinkEntry(0, 0);
        head = new LinkEntry(0, 0);

        tail.next = head;
        tail.prev = head;
        head.next = tail;
        head.prev = tail;
    }
        
    public int get(final int key) {
        // 指定键对应的数据，如果不存在则返回 -1
        int result = -1;

        if (map.containsKey(key)) {
            LinkEntry entry = removeEntry(key);
            result = entry.value;
            moveToTail(entry);
        }
        return result;
    }


    public void put(final int key, final int value) {
        LinkEntry entry = null;
        //关键字存在，变更数据值，关键字不存在，则插入该数据。        
        //插入数据，如果缓存已满则删除醉酒未使用的数据
        if(map.containsKey(key)) {
            entry = removeEntry(key);
            entry.value = value;
            moveToTail(entry);
        } else {
            if (removeEldest()) {
                removeEntry(head.next.key);
            }
            entry = new LinkEntry(value, key);
            moveToTail(entry);
        }
    }

    private LRUCache.LinkEntry removeEntry(int key) {
        LinkEntry entry = map.remove(key);
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;
        return entry;
    }

    private boolean removeEldest() {
        return map.size()>=capacity;
    }

    private void moveToTail(LRUCache.LinkEntry linkEntry) {
        tail.prev.next = linkEntry;
        linkEntry.prev = tail.prev;

        linkEntry.next = tail;
        tail.prev = linkEntry;

        map.put(linkEntry.key, linkEntry);
    }

    class LinkEntry {
        int value;
        int key;
        LinkEntry next;
        LinkEntry prev;

        LinkEntry(int value, int key) {
            this.value = value;
            this.key = key;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

