package data_structure.linked_data_structure.simpleList_구현.lim_seyeon.listImpl;

public class CircularLinkedList extends DoubleLinkedList {

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

        p.next.next = head;
        head.prev = p.next;
    }

}
