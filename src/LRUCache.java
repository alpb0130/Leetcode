import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by alpb0130 on 9/18/16.
 * <p>
 * 146. LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used
 * (LRU) cache. It should support the following operations: get and set.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the
 * key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already
 * present. When the cache reached its capacity, it should invalidate
 * the least recently used item before inserting a new item.
 */
public class LRUCache {
    // LinkedHashMap
    LinkedHashMap<Integer, Integer> cache = null;
    int capacity = 0;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.7f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

    // HashMap and doubly linked list
    /*private class Node {
        int value;
        int key;
        Node next;
        Node prev;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    Map<Integer, Node> cache = null;
    int capacity = 0;
    Node head = null, tail = null;

    public LRUCache(int capacity) {
        cache = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            return node.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        Node old = cache.remove(key);
        if (old != null) {
            old.next.prev = old.prev;
            old.prev.next = old.next;
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        if (cache.size() > capacity) {
            cache.remove(tail.prev.key);
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
        }
    }*/
}
