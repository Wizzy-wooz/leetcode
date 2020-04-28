package leetcode_challenges.april.day24;

import java.util.HashMap;
import java.util.Map;

public class LC146LRUCache {
    private class Node {
        int key, value;
        Node left, right;
    }

    int max, cur = 0;
    Map<Integer, Node> map = new HashMap<>();
    Node head = null, tail = null;

    public LC146LRUCache(int capacity) {
        max = capacity;
    }

    private void insert(Node node) {
        node.left = null;
        node.right = head;
        if (head != null) head.left = node;
        else tail = node;
        head = node;
    }

    private void pop() {
        if (tail == null) return;
        Node node = tail.left;
        node.right = null;
        tail.left = null;
        tail = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);

        if (node == head) return node.value;
        if (node == tail) {
            pop();
            insert(node);
        }
        else {
            node.left.right = node.right;
            node.right.left = node.left;
            insert(node);
        }

        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if (!map.containsKey(key)) {
            node = new Node();
            insert(node);
            if (cur + 1 > max) {
                map.remove(tail.key);
                pop();
            }
            else cur++;
        }
        else {
            node = map.get(key);
            get(key);
        }
        node.value = value;
        node.key = key;
        map.put(key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
