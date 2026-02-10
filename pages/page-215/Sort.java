// Sort 인터페이스 - 정렬 알고리즘의 공통 규약 정의
// 오름차순/내림차순 정렬 메서드와 설명을 위한 디폴트 메서드 제공
public interface Sort {
    // 오름차순 정렬 메서드
    // 정수형 배열을 오름차순으로 정렬
    void ascending(int[] arr);
    
    // 내림차순 정렬 메서드
    // 정수형 배열을 내림차순으로 정렬
    void descending(int[] arr);
    
    // 정렬 알고리즘 설명을 출력하는 디폴트 메서드
    // 구현 클래스에서 오버라이드하여 각 알고리즘의 특징 설명 가능
    default void description() {
        System.out.println("정렬 알고리즘");
    }
}
