// Page 86-2: 짝수단만 출력하는 구구단 (2, 4, 6, 8단)
// if문으로 짝수 판별 후 해당 단만 출력
public class EvenDanOnly {
    
    // 짝수단만 출력하는 메서드
    public static void printEvenDanTable() {
        // 외부 for문: 2부터 9까지 모든 단수를 순회
        // dan 변수: 현재 검사 중인 단수
        for (int dan = 2; dan <= 9; dan++) {
            // if문: 조건이 true일 때만 내부 블록 실행
            // dan % 2: dan을 2로 나눈 나머지
            // - 짝수: 2로 나누어떨어지므로 나머지 0 → (0 == 0) → true
            // - 홀수: 2로 나누면 나머지 1 → (1 == 0) → false
            // 예: 2 % 2 = 0 (true), 3 % 2 = 1 (false), 4 % 2 = 0 (true)
            if (dan % 2 == 0) {
                // 짝수단만 이 블록 실행 (2, 4, 6, 8단)
                System.out.println("=== " + dan + "단 ===");
                
                // 내부 for문: 짝수단일 때만 실행됨
                // num 변수: 곱하는 수 (1~9)
                // 중첩 구조: if문 안에 for문이 중첩되어 조건부 반복 구현
                for (int num = 1; num <= 9; num++) {
                    // 곱셈 결과 출력 (짝수단 × 1~9)
                    System.out.println(dan + " × " + num + " = " + (dan * num));
                }
                System.out.println();
            }
            // if문이 false면 (홀수단) 이 반복은 건너뛰고 다음 dan으로 이동
        }
        // 총 출력 단수: 4개 (2, 4, 6, 8단)
        // 총 출력 개수: 4단 × 9개 = 36개
    }
    
    // 메인 메서드: 프로그램 진입점
    public static void main(String[] args) {
        System.out.println("*** 구구단 (짝수단만) ***\n");
        // printEvenDanTable 메서드 호출: 짝수단 구구단 출력
        printEvenDanTable();
    }
}

