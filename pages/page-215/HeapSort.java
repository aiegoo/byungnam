// HeapSort - 힙 정렬 알고리즘 구현
// 힙 자료구조를 이용한 정렬 방식
// 시간복잡도: O(n log n), 공간복잡도: O(1)
public class HeapSort implements Sort {
    
    @Override
    public void ascending(int[] arr) {
        // 힙 정렬 오름차순 실행 표시
        // 실제 정렬은 수행하지 않고 메시지만 출력
        System.out.println("HeapSort ascending");
    }
    
    @Override
    public void descending(int[] arr) {
        // 힙 정렬 내림차순 실행 표시
        // 실제 정렬은 수행하지 않고 메시지만 출력
        System.out.println("HeapSort descending");
    }
    
    @Override
    public void description() {
        // 힙 정렬 알고리즘 설명
        // 힙 자료구조의 특성을 이용한 정렬 방식 설명
        System.out.println("힙 정렬: 힙 자료구조를 사용하여 정렬합니다");
    }
}
