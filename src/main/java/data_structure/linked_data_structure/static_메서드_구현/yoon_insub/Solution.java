package data_structure.linked_data_structure.static_메서드_구현.yoon_insub;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Solution {

    static class Node {
        int data;
        Node next;

        public Node(){}

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    static String toString(Node list) {

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        if (list == null) {
            sb.append("]");
        } else {
            Node p = list;
            while(p != null) {
                sb.append(p);
                sb.append(", ");
                p = p.next;
            }

            sb.append("]");
            sb.delete(sb.length()-3,sb.length()-1);
        }

        return sb.toString();
    }

    /**
     *
     * @param list Node 시작점
     * @param i i번째 요소
     * @return i번째 요소의 data
     * @exception NullPointerException list 파라미터가 null
     * @exception NoSuchElementException i번째가 list의 길이를 넘는 경우
     */
    static int get(Node list, int i) {
        if (list == null) {
            throw new NullPointerException();
        }

        Node p = list;
        int cnt = 0;
        while(cnt != i) {
            if (Objects.isNull(p)) {
                throw new NoSuchElementException();
            }
            p = p.next;
            cnt++;
        }

        return p.data;
    }

    static Node append(Node list, int x) {

        Node node = new Node(x);

        if (Objects.isNull(list)) {
            list = node;
        } else {
            Node p = list;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }

        return list;
    }

    static Node append(Node list1, Node list2) {
/*
        수석님 코드
        Node p = list2;

        while(p != null) {
            list1 = append(list1, p.data);
            p = p.next;
        }

        return list1;

 */
        if (list1 == null) {
            list1 = list2;
        } else {
            Node p = list1;
            while(p.next != null) {
                p = p.next;
            }
            p.next = list2;
        }

        return list1;
    }

    static Node insert(Node list, int i, int x) {
        if (Objects.isNull(list)) {
            if (i == 0) {
                list = append(list, x);
            } else {
                throw new IndexOutOfBoundsException();
            }
        } else {
            int idx = 0;
            Node p = list;
            while (idx+1 != i) {
                if (Objects.isNull(p)) {
                    throw new IndexOutOfBoundsException();  // i가 초과하는 경우
                }
                p = p.next;
                idx++;
            }
            if(Objects.isNull(p.next)) {
                p.next = new Node(x, null); // 마지막에 추가하는 경우
            } else {
                p.next = new Node(x,p.next);     // 중간에 삽입하는 경우
            }
        }
        return list;
    }

    static int size(Node list) {

        if (Objects.isNull(list)) {
            return 0;
        }
        int cnt = 0;
        Node p = list;

        while (p != null) {
            p = p.next;
            cnt++;
        }

        return cnt;
    }

    static int sum(Node list) {

        if (Objects.isNull(list)) {
            throw new NoSuchElementException();
        }

        Node p = list;
        int sum = 0;
        while (p != null) {
            sum += p.data;
            p = p.next;
        }

        return sum;
    }

    static Node removeLast(Node list) {
        if (list.next == null) {
            return null;
        }

        Node p = list;
        Node pre = null;
        while(p.next != null) {
            pre = p;
            p = p.next;
        }
        pre.next = null;

        return list;
    }

    static Node copy(Node list) {
        Node copiedList = null;
        Node p = list;

        while(p != null) {
            copiedList = append(copiedList, p.data);
            p = p.next;
        }

        return copiedList;
    }

    static Node copyOfRange(Node list, int begin, int finished) {
        /*
        // 수석님 코드
        if (Objects.isNull(list) || (finished <= begin) || size(list) < finished) {
            throw new IllegalArgumentException();
        }

        Node newList = null;
        for (int i = begin; i < finished; i++) {
            newList = append(newList, get(list, i));
        }

        return newList;
        */
        Node copiedList = null;
        int idx = 0;
        Node p = list;

        while (p != null) {
            if (idx >= begin) {
                if (idx > finished - 1) {
                    break;
                }
                copiedList = append(copiedList, p.data);
            }
            p = p.next;
            idx++;
        }
        if (idx != finished) {
            throw new IndexOutOfBoundsException("end 값이 리스트의 길이를 초과");
        }

        return copiedList;
    }

    static void set(Node list, int index, int data) {
        if (Objects.isNull(list)) {
            throw new IllegalArgumentException();
        }

        int targetIdx = 0;

        Node p = list;
        while (p != null) {
            if (targetIdx == index) {
                p.data = data;
                return;
            }
            p = p.next;
            targetIdx++;
        }
        throw new NoSuchElementException();
    }

    static void swap(Node list, int i, int j) {
        if (Objects.isNull(list) || i > j) {
            throw new IllegalArgumentException();
        }

        // get이용

        Node p = list;
        Node a = null;
        Node b = null;
        int idx = 0;

        while (p != null) {
            if (idx == i) {
                a = p;
            }
            if (idx == j) {
                b = p;
            }
            p = p.next;
            idx++;
        }
        if (Objects.isNull(a) || Objects.isNull(b)) {
            throw new NoSuchElementException();
        }
        int num1 = a.data;
        int num2 = b.data;
        set(list, i, num2);
        set(list, j, num1);
    }

    static Node merged(Node list1, Node list2) {

        if(Objects.isNull(list1) && Objects.isNull(list2)) {
            throw new IllegalArgumentException();
        }

        Node result = null;

        Node data1 = list1;
        Node data2 = list2;

        while (data1 != null && data2 != null) {
            if (data1.data > data2.data) {
                result = append(result, data2.data);
                data2 = data2.next;
            } else {
                result = append(result, data1.data);
                data1 = data1.next;
            }
        }

        if (data1 == null) {
            while(data2 != null) {
                append(result, data2);
                data2 = data2.next;
            }
        } else if (data2 == null) {
            while(data1 != null) {
                append(result, data1);
                data1 = data1.next;
            }
        }

        return result;
    }

    static Node rotateLeft(Node list) {

        Node last = new Node(list.data);
        list = list.next;
        append(list, last);

        return list;
    }

}
