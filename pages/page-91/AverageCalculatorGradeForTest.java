public class AverageCalculatorGradeForTest {
    
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    private static void test(String testName, boolean condition) {
        totalTests++;
        if (condition) {
            passedTests++;
            System.out.println("✓ " + testName);
        } else {
            System.out.println("✗ " + testName);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== AverageCalculatorGradeFor 테스트 시작 ===\n");
        
        // Given-When-Then 패턴으로 calculateGrade 메서드 테스트
        
        // Test 1: A+ 학점 (95점 이상)
        // Given: 95점
        // When: calculateGrade 호출
        // Then: "A+" 반환
        test("95점은 A+ 학점", 
            AverageCalculatorGradeFor.calculateGrade(95).equals("A+"));
        
        // Test 2: A+ 학점 경계값 (100점)
        // Given: 100점
        // When: calculateGrade 호출
        // Then: "A+" 반환
        test("100점은 A+ 학점", 
            AverageCalculatorGradeFor.calculateGrade(100).equals("A+"));
        
        // Test 3: A 학점 (90-94점)
        // Given: 90점
        // When: calculateGrade 호출
        // Then: "A" 반환
        test("90점은 A 학점", 
            AverageCalculatorGradeFor.calculateGrade(90).equals("A"));
        
        // Test 4: A 학점 경계값
        // Given: 94점
        // When: calculateGrade 호출
        // Then: "A" 반환
        test("94점은 A 학점", 
            AverageCalculatorGradeFor.calculateGrade(94).equals("A"));
        
        // Test 5: B+ 학점 (85-89점)
        // Given: 85점
        // When: calculateGrade 호출
        // Then: "B+" 반환
        test("85점은 B+ 학점", 
            AverageCalculatorGradeFor.calculateGrade(85).equals("B+"));
        
        // Test 6: B 학점 (80-84점)
        // Given: 80점
        // When: calculateGrade 호출
        // Then: "B" 반환
        test("80점은 B 학점", 
            AverageCalculatorGradeFor.calculateGrade(80).equals("B"));
        
        // Test 7: C 학점 (70-79점)
        // Given: 70점
        // When: calculateGrade 호출
        // Then: "C" 반환
        test("70점은 C 학점", 
            AverageCalculatorGradeFor.calculateGrade(70).equals("C"));
        
        // Test 8: D 학점 (60-69점)
        // Given: 60점
        // When: calculateGrade 호출
        // Then: "D" 반환
        test("60점은 D 학점", 
            AverageCalculatorGradeFor.calculateGrade(60).equals("D"));
        
        // Test 9: F 학점 (60점 미만)
        // Given: 59점
        // When: calculateGrade 호출
        // Then: "F" 반환
        test("59점은 F 학점", 
            AverageCalculatorGradeFor.calculateGrade(59).equals("F"));
        
        // Test 10: F 학점 최소값
        // Given: 0점
        // When: calculateGrade 호출
        // Then: "F" 반환
        test("0점은 F 학점", 
            AverageCalculatorGradeFor.calculateGrade(0).equals("F"));
        
        // Test 11: 경계값 테스트 (89점은 B+)
        // Given: 89점
        // When: calculateGrade 호출
        // Then: "B+" 반환
        test("89점은 B+ 학점", 
            AverageCalculatorGradeFor.calculateGrade(89).equals("B+"));
        
        // Test 12: 경계값 테스트 (79점은 C)
        // Given: 79점
        // When: calculateGrade 호출
        // Then: "C" 반환
        test("79점은 C 학점", 
            AverageCalculatorGradeFor.calculateGrade(79).equals("C"));
        
        System.out.println("\n=== 테스트 결과 ===");
        System.out.println(totalTests + "/" + totalTests + " 통과");
        
        if (passedTests == totalTests) {
            System.out.println("✓ 모든 테스트 통과!");
        } else {
            System.out.println("✗ " + (totalTests - passedTests) + "개 테스트 실패");
        }
    }
}
