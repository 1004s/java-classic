package data_structure.linked_data_structure.simpleList_구현.lim_seyeon.listImpl;

import data_structure.linked_data_structure.simpleList_구현.lim_seyeon.SimpleIterable;
import data_structure.linked_data_structure.simpleList_구현.lim_seyeon.SimpleList;
import data_structure.linked_data_structure.simpleList_구현.lim_seyeon.SimpleListIterator;

public class SimpleArrayList implements SimpleList, SimpleIterable {

    private static final int DEFAULT_CAPACITY = 5;
    private int capacity;
    private int size;
    private int[] elements;

    public SimpleArrayList(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    public SimpleArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int data) {
        if(size+1 >= capacity) {
            int[] arr = new int[capacity * 2];
            System.arraycopy(elements, 0, arr, 0, elements.length);
            this.capacity = capacity * 2;
            this.elements = arr;
        }
        elements[size++] = data;
    }

    @Override
    public int remove() {
        int data = elements[0];
        System.arraycopy(elements, 1, elements, 0, elements.length - 1);
        size--;
        return data;
    }

    @Override
    public boolean remove(int data) {
        int index = getIndex(data);
        if(index != -1) {
            System.arraycopy(elements, index+1, elements, index, (size-index-1));
            return true;
        }
        return false;
    }

    private int getIndex(int data) {
        for(int i = 0; i < size; i++) {
            if(elements[i] == data) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(int data) {
        return getIndex(data) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleListIterator iterator() {
        return new SimpleListIterator() {

            int prevCursor = -1;
            int nextCursor = 0;

            @Override
            public boolean hasNext() {
                return nextCursor < size;
            }

            @Override
            public int next() {
                prevCursor++;
                return elements[nextCursor++];
            }

            @Override
            public boolean hasPrevious() {
                return prevCursor >= 0;
            }

            @Override
            public int previous() {
                nextCursor--;
                return elements[prevCursor--];
            }

            // 요구사항: 다음 요소 삭제
            @Override
            public void remove() {
                if(hasNext()) {
                    System.arraycopy(elements, nextCursor + 1, elements, nextCursor, (size - nextCursor - 1));
                    size--;
                }
            }
        };
    }
}