package data_structure.linked_data_structure.simpleList_구현.lim_seyeon.listImpl;


import data_structure.linked_data_structure.simpleList_구현.lim_seyeon.SimpleList;

import java.util.NoSuchElementException;

public class DoubleLinkedList implements SimpleList {

    protected static class Node {
        int data;
        Node prev;
        Node next;

        protected Node(int data) {
            this.data = data;
        }

        protected Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        protected Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    protected int size;
    protected Node head;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int data) {
        if(head == null) {
            head = new Node(data);
            size++;
            return;
        }
        Node p = head;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new Node(data, p, p.next);
        size++;
    }

    @Override
    public int remove() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        int data;
        if(size == 1) {
            data = head.data;
            head = null;
        } else {
            Node p = head;
            while (p != null) {
                p = p.next;
            }
            data = p.data;
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
        size--;
        return data;
    }

    @Override
    public boolean remove(int data) {
        int targetIndex = getFirstIndex(data);
        if(targetIndex == -1) {
            return false;
        }

        Node target = head;
        int idx = 0;
        while(idx < targetIndex) {
            target = target.next;
            idx++;
        }
        target.prev.next = target.next;
        target.next.prev = target.prev;
        size--;
        return true;
    }

    @Override
    public boolean contains(int data) {
        return getFirstIndex(data) > -1;
    }

    // data == p.data인 최초의 노드 p의 인덱스를 반환
    // data == p.data인 노드가 없다면 -1을 반환
    private int getFirstIndex(int data) {
        Node p = head;
        int idx = 0;
        while(p != null) {
            if(p.data == data) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

}
