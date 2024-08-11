package data_structure.linked_data_structure.simpleList_구현.lim_seyeon.listImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    @DisplayName("Node끼리 제대로 연결되어 있고, 마지막 추가된 노드의 next는 리스트의 head이다")
    void add() {
        CircularLinkedList list = new CircularLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        assertEquals(5, list.size());

        DoubleLinkedList.Node p = list.head;
        int cursor = 1;
        while(cursor < 5) {
            assertEquals(cursor, p.data);
            p = p.next;
            cursor++;
        }
        assertEquals(p.next, list.head);
    }
}