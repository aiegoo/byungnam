import java.io.IOException;

public class SortTest {
    public static void main(String[] args) throws IOException {
        // 사용자에게 정렬 알고리즘 선택 안내
        System.out.println("정렬 알고리즘을 선택하세요.");
        System.out.println("B : BubbleSort");
        System.out.println("H : HeapSort");
        System.out.println("Q : QuickSort");
        
        // 사용자 입력 받기 (한 글자)
        int ch = System.in.read();
        
        // 선택된 알고리즘에 따라 Sort 인스턴스 생성
        Sort sort = null;
        
        if (ch == 'B' || ch == 'b') {
            // BubbleSort 선택
            sort = new BubbleSort();
        } else if (ch == 'H' || ch == 'h') {
            // HeapSort 선택
            sort = new HeapSort();
        } else if (ch == 'Q' || ch == 'q') {
            // QuickSort 선택
            sort = new QuickSort();
        } else {
            // 지원되지 않는 입력
            System.out.println("지원되지 않는 정렬 알고리즘입니다.");
            return;
        }
        
        // 테스트용 배열 생성
        int[] arr = {5, 2, 8, 1, 9};
        
        // 선택된 정렬 알고리즘 설명 출력
        sort.description();
        
        // 오름차순 정렬 실행
        sort.ascending(arr);
        
        // 내림차순 정렬 실행
        sort.descending(arr);
    }
}
