package com.example.challenges.PracticalDesign;

public class LinkedList {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        private int size;
        private ListNode head;

        public void LinkedList(){
            this.size = 0;
            this.head = new ListNode(0);
        }

        public int get(int index){
            if (index<0 || index >=size){
                return -1;
            }
            ListNode cur = head;
            for (int i=0;i<=size;i++){
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val){
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void addAtTail(int val){
            ListNode newNode = new ListNode(val);
            ListNode cur = head;
            while (cur.next!=null){
                cur = cur.next;
            }
            cur.next = newNode;
            size++;
        }

        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            //找到要插入节点的前驱
            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = pre.next;
            pre.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
            ListNode pre = head;
            for (int i = 0; i < index ; i++) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            size--;
        }
    }
}
