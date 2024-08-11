package data_structure.linked_data_structure.simpleList_구현.lim_seyeon;

public interface SimpleListIterator {

    boolean hasNext();

    int next();

    boolean hasPrevious();

    int previous();

    // 다음 요소 삭제
    void remove();

}
