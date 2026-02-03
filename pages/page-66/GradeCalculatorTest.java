// GradeCalculator 테스트 스위트
// Given-When-Then 패턴으로 테스트 구조화 (디버깅 용이)
public class GradeCalculatorTest {
    
    private static int total = 0;
    private static int passed = 0;
    
    public static void main(String[] args) {
        System.out.println("=== GradeCalculator 테스트 ===\n");
        
        testAPlusGrade();
        testAGrade();
        testBPlusGrade();
        testBGrade();
        testCGrade();
        testDGrade();
        testFGrade();
        
        // 결과 출력
        System.out.println("\n결과: " + passed + "/" + total + " 통과");
        System.out.println(passed == total ? "✓ 모든 테스트 통과!" : "✗ 일부 실패");
    }
    
    // A+ 학점 테스트 (95-100점)
    private static void testAPlusGrade() {
        System.out.println("[A+ 학점 테스트]");
        
        //given: 100점 만점
        //when: 학점 계산
        //then: A+ 반환
        test("A+", 100, "만점 100점");
        
        //given: 95점 (A+ 경계값)
        //when: 학점 계산
        //then: A+ 반환
        test("A+", 95, "경계값 95점");
        
        System.out.println();
    }
    
    // A 학점 테스트 (90-94점)
    private static void testAGrade() {
        System.out.println("[A 학점 테스트]");
        
        //given: 94점 (A 최고점)
        //when: 학점 계산
        //then: A 반환
        test("A", 94, "최고점 94점");
        
        //given: 90점 (A 경계값)
        //when: 학점 계산
        //then: A 반환
        test("A", 90, "경계값 90점");
        
        System.out.println();
    }
    
    // B+ 학점 테스트 (85-89점)
    private static void testBPlusGrade() {
        System.out.println("[B+ 학점 테스트]");
        
        //given: 89점 (B+ 최고점)
        //when: 학점 계산
        //then: B+ 반환
        test("B+", 89, "최고점 89점");
        
        //given: 85점 (B+ 경계값)
        //when: 학점 계산
        //then: B+ 반환
        test("B+", 85, "경계값 85점");
        
        System.out.println();
    }
    
    // B 학점 테스트 (80-84점)
    private static void testBGrade() {
        System.out.println("[B 학점 테스트]");
        
        //given: 84점 (B 최고점)
        //when: 학점 계산
        //then: B 반환
        test("B", 84, "최고점 84점");
        
        //given: 80점 (B 경계값)
        //when: 학점 계산
        //then: B 반환
        test("B", 80, "경계값 80점");
        
        System.out.println();
    }
    
    // C 학점 테스트 (70-79점)
    private static void testCGrade() {
        System.out.println("[C 학점 테스트]");
        
        //given: 79점 (C 최고점)
        //when: 학점 계산
        //then: C 반환
        test("C", 79, "최고점 79점");
        
        //given: 70점 (C 경계값)
        //when: 학점 계산
        //then: C 반환
        test("C", 70, "경계값 70점");
        
        System.out.println();
    }
    
    // D 학점 테스트 (60-69점)
    private static void testDGrade() {
        System.out.println("[D 학점 테스트]");
        
        //given: 69점 (D 최고점)
        //when: 학점 계산
        //then: D 반환
        test("D", 69, "최고점 69점");
        
        //given: 60점 (D 경계값)
        //when: 학점 계산
        //then: D 반환
        test("D", 60, "경계값 60점");
        
        System.out.println();
    }
    
    // F 학점 테스트 (0-59점)
    private static void testFGrade() {
        System.out.println("[F 학점 테스트]");
        
        //given: 59점 (F 최고점)
        //when: 학점 계산
        //then: F 반환
        test("F", 59, "최고점 59점");
        
        //given: 0점 (최저점)
        //when: 학점 계산
        //then: F 반환
        test("F", 0, "최저점 0점");
        
        System.out.println();
    }
    
    // 테스트 헬퍼 메서드
    private static void test(String expected, int score, String desc) {
        total++;
        String result = GradeCalculator.calculateGrade(score);
        if (expected.equals(result)) {
            passed++;
            System.out.println("  ✓ " + desc + ": " + score + "점 → " + result);
        } else {
            System.out.println("  ✗ " + desc + ": 예상=" + expected + ", 실제=" + result);
        }
    }
}
