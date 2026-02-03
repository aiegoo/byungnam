public class AverageCalculatorTest {
    
    private static int total = 0;
    private static int passed = 0;
    
    public static void main(String[] args) {
        System.out.println("=== AverageCalculator 테스트 ===\n");
        
        testNormalScores();
        testPerfectScores();
        testZeroScores();
        testMixedScores();
        
        System.out.println("\n결과: " + passed + "/" + total + " 통과");
        System.out.println(passed == total ? "✓ 모든 테스트 통과!" : "✗ 일부 실패");
    }
    
    private static void testNormalScores() {
        System.out.println("[일반 점수 테스트]");
        
        //given: 수학85, 국어90, 영어78, 프로그래밍95
        //when: 평균 계산
        //then: 87.0
        test(85, 90, 78, 95, 87.0, "일반 점수");
        
        //given: 수학70, 국어75, 영어80, 프로그래밍85
        //when: 평균 계산
        //then: 77.5
        test(70, 75, 80, 85, 77.5, "중간 점수");
        
        System.out.println();
    }
    
    private static void testPerfectScores() {
        System.out.println("[만점 테스트]");
        
        //given: 모든 과목 100점
        //when: 평균 계산
        //then: 100.0
        test(100, 100, 100, 100, 100.0, "전과목 만점");
        
        //given: 수학100, 나머지 80
        //when: 평균 계산
        //then: 90.0
        test(100, 80, 80, 80, 90.0, "수학만 만점");
        
        System.out.println();
    }
    
    private static void testZeroScores() {
        System.out.println("[0점 테스트]");
        
        //given: 모든 과목 0점
        //when: 평균 계산
        //then: 0.0
        test(0, 0, 0, 0, 0.0, "전과목 0점");
        
        //given: 수학0, 나머지 100
        //when: 평균 계산
        //then: 75.0
        test(0, 100, 100, 100, 75.0, "수학만 0점");
        
        System.out.println();
    }
    
    private static void testMixedScores() {
        System.out.println("[다양한 점수 테스트]");
        
        //given: 50, 60, 70, 80
        //when: 평균 계산
        //then: 65.0
        test(50, 60, 70, 80, 65.0, "등차수열");
        
        //given: 90, 85, 95, 90
        //when: 평균 계산
        //then: 90.0
        test(90, 85, 95, 90, 90.0, "우수 점수");
        
        //given: 60, 65, 55, 70
        //when: 평균 계산
        //then: 62.5
        test(60, 65, 55, 70, 62.5, "보통 점수");
        
        System.out.println();
    }
    
    private static void test(int math, int korean, int english, int programming, 
                            double expected, String desc) {
        total++;
        double result = AverageCalculator.calculateAverage(math, korean, english, programming);
        if (Math.abs(result - expected) < 0.01) {
            passed++;
            System.out.printf("  ✓ %s: (수%d, 국%d, 영%d, 프%d) → 평균 %.2f%n", 
                            desc, math, korean, english, programming, result);
        } else {
            System.out.printf("  ✗ %s: 예상=%.2f, 실제=%.2f%n", desc, expected, result);
        }
    }
}
