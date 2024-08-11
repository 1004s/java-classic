package data_structure.linked_data_structure.static_메서드_구현.lim_seyeon;


import java.util.NoSuchElementException;

public class Solution {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static String toString(Node node) {
        if (node == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        while (node != null) {
            builder.append(node.data).append(", ");
            node = node.next;
        }
        builder.delete(builder.length() - 2, builder.length()).append("]");
        return builder.toString();
    }

    static int get(Node node, int index) {
        int cursor = 0;
        while (node != null && cursor < index) {
            node = node.next;
            cursor++;
        }
        if (node == null) {
            throw new NoSuchElementException();
        }
        return node.data;
    }

    static Node append(Node start, int x) {
        if (start == null || start.data > x) {
            return new Node(x, start);
        }

        Node p = start;
        while (p.next != null && p.next.data < x) {
            p = p.next;
        }

        Node node = new Node(x, p.next);
        p.next = node;

        return start;
    }

    static Node append(Node node1, Node node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        Node start = node1;
        Node p = start;
        while (p.next != null) {
            p = p.next;
        }
        p.next = node2;

        return start;
    }

    static Node insert(Node node, int index, int x) {
        if (node == null) {
            if (index == 0) {
                return new Node(x);
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        Node start = node;

        int cursor = 0;
        while (node.next != null && cursor + 1 < index) {
            node = node.next;
            cursor++;
        }
        if (cursor + 1 != index) {
            throw new IndexOutOfBoundsException();
        }

        Node newNode = new Node(x, node.next);
        node.next = newNode;

        return start;
    }

    static int size(Node list) {
        int size = 0;
        while (list != null) {
            size++;
            list = list.next;
        }
        return size;
    }

    static int sum(Node list) {
        int sum = 0;
        while (list != null) {
            sum += list.data;
            list = list.next;
        }
        return sum;
    }

    static Node removeLast(Node list) {
        Node p = list;
        if (p.next == null) {
            return null;
        }
        while (p.next.next != null) {
            p = p.next;
        }
        p.next = null;
        return list;
    }

    static Node copy(Node list) {
        Node start = new Node(list.data);
        Node p = start;
        list = list.next;
        while (list != null) {
            p.next = new Node(list.data);
            p = p.next;
            list = list.next;
        }
        return start;
    }

    static Node copyOfRange(Node list, int p, int q) {
        int count = 0;
        while (list.next != null && count < p) {
            list = list.next;
            count++;
        }
        if (count != p) {
            throw new IndexOutOfBoundsException();
        }
        Node start = new Node(list.data);
        Node cur = start;
        while (++count < q) {
            if (list == null) {
                throw new IndexOutOfBoundsException();
            }
            list = list.next;
            cur.next = list;
        }

        return start;
    }

    static void set(Node list, int i, int x) {
        int cursor = 0;
        while (list != null && cursor < i) {
            list = list.next;
        }
        if (cursor != i) {
            throw new IndexOutOfBoundsException();
        }
        list.data = x;
    }

    static void swap(Node list, int i, int j) {
        int cursor = 0;
        Node node1, node2;
        while (list != null && cursor < i) {
            list = list.next;
            cursor++;
        }
        if (cursor != i) {
            throw new NoSuchElementException();
        }
        node1 = list;

        while (list != null && cursor < j) {
            list = list.next;
            cursor++;
        }
        if (cursor != j) {
            throw new NoSuchElementException();
        }
        node2 = list;

        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    static Node rotateLeft(Node list) {
        Node start = list.next;
        Node p = start;
        while (p.next != null) {
            p = p.next;
        }
        list.next = null;
        p.next = list;
        return start;
    }

    static Node merged(Node list1, Node list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        Node p1 = list1;
        Node p2 = list2;
        Node start;
        if (list1.data < list2.data) {
            start = new Node(p1.data);
            p1 = p1.next;
        } else {
            start = new Node(p2.data);
            p2 = p2.next;
        }

        Node p = start;
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
                p.next = new Node(p1.data);
                p1 = p1.next;
            } else {
                p.next = new Node(p2.data);
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 == null) {
            while (p2 != null) {
                p.next = p2.next;
                p2 = p2.next;
            }
        }

        // if(p2 == null) 생략
        while (p1 != null) {
            p.next = p1.next;
            p1 = p1.next;
        }


        return start;
    }
}