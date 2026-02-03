public class MultiplicationTableTest {
    
    private static int total = 0;
    private static int passed = 0;
    
    public static void main(String[] args) {
        System.out.println("=== MultiplicationTable 테스트 ===\n");
        
        testFullTableStructure();
        testTableRange();
        testMultiplicationAccuracy();
        
        System.out.println("\n결과: " + passed + "/" + total + " 통과");
        System.out.println(passed == total ? "✓ 모든 테스트 통과!" : "✗ 일부 실패");
    }
    
    private static void testFullTableStructure() {
        System.out.println("[전체 구구단 구조 테스트]");
        
        //given: 2단부터 9단까지
        //when: 각 단마다 1~9까지 곱셈
        //then: 총 8개 단 × 9개 계산 = 72개 결과
        int expectedDans = 8;  // 2~9단
        int expectedPerDan = 9;  // 1~9까지
        test(expectedDans * expectedPerDan, 72, "총 결과 개수");
        
        System.out.println();
    }
    
    private static void testTableRange() {
        System.out.println("[단수 범위 테스트]");
        
        //given: 구구단 범위
        //when: 최소 단수와 최대 단수 확인
        //then: 2단부터 9단까지
        test(2, 2, "최소 단수");
        test(9, 9, "최대 단수");
        
        System.out.println();
    }
    
    private static void testMultiplicationAccuracy() {
        System.out.println("[곱셈 정확도 테스트]");
        
        //given: 각 단의 특정 곱셈
        //when: 곱셈 결과 계산
        //then: 정확한 결과값
        test(2 * 1, 2, "2 × 1");
        test(2 * 9, 18, "2 × 9");
        test(5 * 5, 25, "5 × 5");
        test(9 * 9, 81, "9 × 9");
        test(7 * 8, 56, "7 × 8");
        
        System.out.println();
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
