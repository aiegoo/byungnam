// Page 86-1: 중첩 반복문을 사용한 구구단 (2단~9단 전체)
// 외부 루프는 단수를 제어하고, 내부 루프는 곱하는 수를 제어
public class MultiplicationTable {
    
    // 전체 구구단을 출력하는 메서드 (2단부터 9단까지)
    public static void printFullTable() {
        // 외부 for문: 단수를 2부터 9까지 반복
        // dan 변수: 현재 출력 중인 단수 (2, 3, 4, ..., 9)
        // 조건: dan <= 9가 true인 동안 반복
        // 증감: 각 반복마다 dan++로 1씩 증가
        for (int dan = 2; dan <= 9; dan++) {
            // 각 단의 제목 출력
            // + 연산자: 문자열 연결, dan 값이 자동으로 문자열로 변환됨
            System.out.println("=== " + dan + "단 ===");
            
            // 내부 for문: 곱하는 수를 1부터 9까지 반복
            // num 변수: 현재 곱하는 수 (1, 2, 3, ..., 9)
            // 중첩 루프: 외부 루프가 한 번 실행될 때마다 내부 루프는 9번 실행
            // 예: dan=2일 때, num은 1부터 9까지 반복 → 2×1, 2×2, ..., 2×9
            for (int num = 1; num <= 9; num++) {
                // 곱셈 결과 출력
                // (dan * num): 괄호 안에서 곱셈이 먼저 계산된 후 문자열로 변환
                // 출력 형식: "2 × 1 = 2", "2 × 2 = 4", ...
                System.out.println(dan + " × " + num + " = " + (dan * num));
            }
            // 각 단 사이에 빈 줄 출력 (가독성 향상)
            System.out.println();
        }
        // 중첩 반복문 총 실행 횟수: 외부 8번 × 내부 9번 = 72회
    }
    
    // 메인 메서드: 프로그램 진입점
    public static void main(String[] args) {
        System.out.println("*** 구구단 (2단 ~ 9단) ***\n");
        // printFullTable 메서드 호출: 전체 구구단 출력
        printFullTable();
    }
}

