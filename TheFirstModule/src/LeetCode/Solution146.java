package LeetCode;

import java.util.HashMap;
import java.util.Map;
/*
运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

 

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

 

示例:

LRUCache cache = new LRUCache( 2  缓存容量  );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
 */
public class Solution146 {
    class LinkedListNode {
        int key;
        int value;
        LinkedListNode next;
        LinkedListNode pre;
        public LinkedListNode(int a, int b) {
            this.key = a;
            this.value = b;
        }
    }

    class LRUCache {
        private Map<Integer, LinkedListNode> hashMap;
        private LinkedListNode head;
        private LinkedListNode tail;
        private int capacity;

        public LRUCache(int capacity) {
            head = new LinkedListNode(0,0);
            tail = new LinkedListNode(0,0);
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
            hashMap = new HashMap<>();
        }

        public int get(int key) {
            LinkedListNode node = hashMap.getOrDefault(key, null);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (hashMap.containsKey(key)) {
                LinkedListNode node = hashMap.get(key);
                moveToHead(node);
                node.value = value;
                return;
            }

            LinkedListNode node = new LinkedListNode(key, value);

            if (hashMap.size() < capacity) {
                AddToHead(node);
            } else {
                AddToHead(node);
                deleteFromeTail();
            }
            hashMap.put(key, node);
        }

        private void moveToHead(LinkedListNode node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            AddToHead(node);
        }

        private void AddToHead(LinkedListNode node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
        }

        private void deleteFromeTail() {
            hashMap.remove(tail.pre.key);
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
        }
    }
}
