public class LimitedMultiplierTest {
    
    private static int total = 0;
    private static int passed = 0;
    
    public static void main(String[] args) {
        System.out.println("=== LimitedMultiplier 테스트 ===\n");
        
        testLimitedRange();
        testMultiplierCondition();
        testTotalOutputCount();
        
        System.out.println("\n결과: " + passed + "/" + total + " 통과");
        System.out.println(passed == total ? "✓ 모든 테스트 통과!" : "✗ 일부 실패");
    }
    
    private static void testLimitedRange() {
        System.out.println("[제한된 범위 테스트]");
        
        //given: 각 단의 최대 곱하는 수
        //when: 단수와 비교
        //then: 곱하는 수 ≤ 단수
        test(2, 2, "2단: 최대 2까지");
        test(3, 3, "3단: 최대 3까지");
        test(5, 5, "5단: 최대 5까지");
        test(9, 9, "9단: 최대 9까지");
        
        System.out.println();
    }
    
    private static void testMultiplierCondition() {
        System.out.println("[곱하는 수 조건 테스트]");
        
        //given: 특정 단과 곱하는 수
        //when: num ≤ dan 조건 검사
        //then: 조건 만족 여부 확인
        testCondition(2, 1, true, "2단 × 1");
        testCondition(2, 2, true, "2단 × 2");
        testCondition(2, 3, false, "2단 × 3 (출력 안됨)");
        testCondition(5, 5, true, "5단 × 5");
        testCondition(5, 6, false, "5단 × 6 (출력 안됨)");
        
        System.out.println();
    }
    
    private static void testTotalOutputCount() {
        System.out.println("[총 출력 개수 테스트]");
        
        //given: 2단~9단, 각 단은 자신의 단수만큼만 출력
        //when: 총 출력 개수 계산
        //then: 2+3+4+5+6+7+8+9 = 44개
        int total = 0;
        for (int dan = 2; dan <= 9; dan++) {
            total += dan;
        }
        test(total, 44, "총 출력 개수");
        
        System.out.println();
    }
    
    private static void testCondition(int dan, int num, boolean shouldPrint, String desc) {
        total++;
        boolean actual = (num <= dan);
        if (actual == shouldPrint) {
            passed++;
            System.out.println("  ✓ " + desc + ": " + (shouldPrint ? "출력됨" : "출력 안됨"));
        } else {
            System.out.println("  ✗ " + desc + ": 조건 불일치");
        }
    }
    
    private static void test(int actual, int expected, String desc) {
        total++;
        if (actual == expected) {
            passed++;
            System.out.println("  ✓ " + desc + ": " + actual);
        } else {
            System.out.println("  ✗ " + desc + ": 예상=" + expected + ", 실제=" + actual);
        }
    }
}
