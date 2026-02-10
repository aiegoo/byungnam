// BubbleSort - 버블 정렬 알고리즘 구현
// 인접한 두 원소를 비교하여 정렬하는 방식
// 시간복잡도: O(n²), 공간복잡도: O(1)
public class BubbleSort implements Sort {
    
    @Override
    public void ascending(int[] arr) {
        // 버블 정렬 오름차순 실행 표시
        // 실제 정렬은 수행하지 않고 메시지만 출력
        System.out.println("BubbleSort ascending");
    }
    
    @Override
    public void descending(int[] arr) {
        // 버블 정렬 내림차순 실행 표시
        // 실제 정렬은 수행하지 않고 메시지만 출력
        System.out.println("BubbleSort descending");
    }
    
    @Override
    public void description() {
        // 버블 정렬 알고리즘 설명
        // 인접한 원소를 비교하며 정렬하는 방식의 특징 설명
        System.out.println("버블 정렬: 인접한 두 원소를 비교하여 정렬합니다");
    }
}
