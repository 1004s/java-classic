package data_structure.linked_data_structure.simpleList_구현.lim_seyeon;

public interface SimpleList {

    boolean isEmpty();

    // 리스트의 마지막에 추가
    void add(int data);

    // 리스트의 첫번째 요소를 제거하고 반환
    int remove();

    // 주어진 요소가 있을 경우 제거. 제거 성공 여부 반환
    boolean remove(int data);

    // 주어진 데이터가 있는지 확인
    boolean contains(int data);

    int size();

}