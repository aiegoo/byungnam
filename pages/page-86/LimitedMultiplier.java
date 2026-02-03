// Page 86-3: 곱하는 수가 단수 이하인 경우만 출력하는 구구단
// 내부 루프의 조건을 단수로 제한하여 삼각형 모양 출력
public class LimitedMultiplier {
    
    // 제한된 범위의 구구단을 출력하는 메서드
    public static void printLimitedTable() {
        // 외부 for문: 단수를 2부터 9까지 반복
        // dan 변수: 현재 출력 중인 단수
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("=== " + dan + "단 ===");
            
            // 내부 for문의 종료 조건이 고정값(9)이 아닌 변수(dan)를 사용
            // num 변수: 곱하는 수, 1부터 시작하여 dan까지만 반복
            // 조건: num <= dan (곱하는 수가 단수보다 작거나 같을 때만)
            // 
            // 각 단별 반복 횟수:
            // - 2단: num ≤ 2 → 1, 2 (2회)
            // - 3단: num ≤ 3 → 1, 2, 3 (3회)
            // - 4단: num ≤ 4 → 1, 2, 3, 4 (4회)
            // - ...
            // - 9단: num ≤ 9 → 1, 2, 3, ..., 9 (9회)
            //
            // 결과: 단수가 증가할수록 출력되는 줄 수도 증가 (삼각형 패턴)
            for (int num = 1; num <= dan; num++) {
                // dan과 num의 곱셈 결과 출력
                // num은 항상 dan 이하이므로 짧은 구구단 형태
                // 예: 2단은 2×1, 2×2만 출력 (2×3~2×9는 출력 안 됨)
                System.out.println(dan + " × " + num + " = " + (dan * num));
            }
            System.out.println();
        }
        // 총 출력 개수: 2+3+4+5+6+7+8+9 = 44개
        // 일반 구구단(72개)보다 적은 출력
    }
    
    // 메인 메서드: 프로그램 진입점
    public static void main(String[] args) {
        System.out.println("*** 구구단 (곱하는 수 ≤ 단수) ***\n");
        // printLimitedTable 메서드 호출: 제한된 구구단 출력
        printLimitedTable();
    }
}

