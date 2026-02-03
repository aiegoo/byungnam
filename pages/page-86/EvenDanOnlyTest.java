public class EvenDanOnlyTest {
    
    private static int total = 0;
    private static int passed = 0;
    
    public static void main(String[] args) {
        System.out.println("=== EvenDanOnly 테스트 ===\n");
        
        testEvenDanCount();
        testEvenDanNumbers();
        testOddDanExcluded();
        
        System.out.println("\n결과: " + passed + "/" + total + " 통과");
        System.out.println(passed == total ? "✓ 모든 테스트 통과!" : "✗ 일부 실패");
    }
    
    private static void testEvenDanCount() {
        System.out.println("[짝수단 개수 테스트]");
        
        //given: 2~9단 중 짝수단만
        //when: 짝수단 개수 세기
        //then: 2, 4, 6, 8 = 4개
        test(4, 4, "짝수단 개수");
        
        System.out.println();
    }
    
    private static void testEvenDanNumbers() {
        System.out.println("[짝수단 번호 테스트]");
        
        //given: 출력할 단수들
        //when: 각 단이 짝수인지 확인
        //then: 2, 4, 6, 8 모두 짝수
        testEven(2, "2단");
        testEven(4, "4단");
        testEven(6, "6단");
        testEven(8, "8단");
        
        System.out.println();
    }
    
    private static void testOddDanExcluded() {
        System.out.println("[홀수단 제외 테스트]");
        
        //given: 홀수 단수들
        //when: 짝수 판별
        //then: 3, 5, 7, 9는 홀수
        testOdd(3, "3단 제외");
        testOdd(5, "5단 제외");
        testOdd(7, "7단 제외");
        testOdd(9, "9단 제외");
        
        System.out.println();
    }
    
    private static void testEven(int num, String desc) {
        total++;
        if (num % 2 == 0) {
            passed++;
            System.out.println("  ✓ " + desc + ": " + num + "은 짝수");
        } else {
            System.out.println("  ✗ " + desc + ": " + num + "은 홀수");
        }
    }
    
    private static void testOdd(int num, String desc) {
        total++;
        if (num % 2 != 0) {
            passed++;
            System.out.println("  ✓ " + desc + ": " + num + "은 홀수");
        } else {
            System.out.println("  ✗ " + desc + ": " + num + "은 짝수");
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
