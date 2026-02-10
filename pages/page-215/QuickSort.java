// QuickSort - 퀵 정렬 알고리즘 구현
// 분할 정복(Divide and Conquer) 방식의 정렬
// 시간복잡도: 평균 O(n log n), 최악 O(n²), 공간복잡도: O(log n)
public class QuickSort implements Sort {
    
    @Override
    public void ascending(int[] arr) {
        // 퀵 정렬 오름차순 실행 표시
        // 실제 정렬은 수행하지 않고 메시지만 출력
        System.out.println("QuickSort ascending");
    }
    
    @Override
    public void descending(int[] arr) {
        // 퀵 정렬 내림차순 실행 표시
        // 실제 정렬은 수행하지 않고 메시지만 출력
        System.out.println("QuickSort descending");
    }
    
    @Override
    public void description() {
        // 퀵 정렬 알고리즘 설명
        // 피벗을 기준으로 분할하여 정렬하는 방식 설명
        System.out.println("퀵 정렬: 피벗을 기준으로 분할하여 정렬합니다");
    }
}
