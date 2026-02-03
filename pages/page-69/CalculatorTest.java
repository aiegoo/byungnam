/**
 * Test suite for Calculator class
 * Tests both if and switch implementations with all operators
 * 
 * @author byungnam
 */
public class CalculatorTest {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== Calculator Test Suite ===\n");
        
        // 요구사항 테스트: num1=10, num2=2, operator='+'
        testRequirement();
        
        // if문 구현 테스트
        testCalculateWithIf();
        
        // switch문 구현 테스트
        testCalculateWithSwitch();
        
        // 일관성 테스트: if와 switch 결과 비교
        testConsistency();
        
        // 에러 처리 테스트
        testErrorHandling();
        
        // 결과 요약
        printTestSummary();
    }
    
    /**
     * 요구사항 테스트: num1=10, num2=2, operator='+'
     */
    private static void testRequirement() {
        System.out.println("## 요구사항 테스트 (num1=10, num2=2, operator='+')");
        int num1 = 10;
        int num2 = 2;
        char operator = '+';
        
        assertEquals(12.0, Calculator.calculateWithIf(num1, num2, operator), 
                     "Requirement (if): 10 + 2 = 12");
        assertEquals(12.0, Calculator.calculateWithSwitch(num1, num2, operator), 
                     "Requirement (switch): 10 + 2 = 12");
        System.out.println();
    }
    
    /**
     * if문 구현 테스트
     */
    private static void testCalculateWithIf() {
        System.out.println("## if문 구현 테스트");
        
        // 덧셈 테스트
        assertEquals(12.0, Calculator.calculateWithIf(10, 2, '+'), "if: 10 + 2");
        assertEquals(0.0, Calculator.calculateWithIf(-5, 5, '+'), "if: -5 + 5");
        
        // 뺄셈 테스트
        assertEquals(8.0, Calculator.calculateWithIf(10, 2, '-'), "if: 10 - 2");
        assertEquals(-10.0, Calculator.calculateWithIf(-5, 5, '-'), "if: -5 - 5");
        
        // 곱셈 테스트
        assertEquals(20.0, Calculator.calculateWithIf(10, 2, '*'), "if: 10 * 2");
        assertEquals(-25.0, Calculator.calculateWithIf(-5, 5, '*'), "if: -5 * 5");
        
        // 나눗셈 테스트
        assertEquals(5.0, Calculator.calculateWithIf(10, 2, '/'), "if: 10 / 2");
        assertEquals(2.5, Calculator.calculateWithIf(5, 2, '/'), "if: 5 / 2 (decimal)");
        
        System.out.println();
    }
    
    /**
     * switch문 구현 테스트
     */
    private static void testCalculateWithSwitch() {
        System.out.println("## switch문 구현 테스트");
        
        // 덧셈 테스트
        assertEquals(12.0, Calculator.calculateWithSwitch(10, 2, '+'), "switch: 10 + 2");
        assertEquals(0.0, Calculator.calculateWithSwitch(-5, 5, '+'), "switch: -5 + 5");
        
        // 뺄셈 테스트
        assertEquals(8.0, Calculator.calculateWithSwitch(10, 2, '-'), "switch: 10 - 2");
        assertEquals(-10.0, Calculator.calculateWithSwitch(-5, 5, '-'), "switch: -5 - 5");
        
        // 곱셈 테스트
        assertEquals(20.0, Calculator.calculateWithSwitch(10, 2, '*'), "switch: 10 * 2");
        assertEquals(-25.0, Calculator.calculateWithSwitch(-5, 5, '*'), "switch: -5 * 5");
        
        // 나눗셈 테스트
        assertEquals(5.0, Calculator.calculateWithSwitch(10, 2, '/'), "switch: 10 / 2");
        assertEquals(2.5, Calculator.calculateWithSwitch(5, 2, '/'), "switch: 5 / 2 (decimal)");
        
        System.out.println();
    }
    
    /**
     * 일관성 테스트: if와 switch 결과가 동일한지 확인
     */
    private static void testConsistency() {
        System.out.println("## 일관성 테스트 (if vs switch)");
        
        char[] operators = {'+', '-', '*', '/'};
        int[][] testCases = {{10, 2}, {5, 3}, {20, 4}, {15, 5}};
        
        for (int[] testCase : testCases) {
            int num1 = testCase[0];
            int num2 = testCase[1];
            
            for (char op : operators) {
                double ifResult = Calculator.calculateWithIf(num1, num2, op);
                double switchResult = Calculator.calculateWithSwitch(num1, num2, op);
                
                assertEquals(ifResult, switchResult, 
                           String.format("Consistency: %d %c %d", num1, op, num2));
            }
        }
        
        System.out.println();
    }
    
    /**
     * 에러 처리 테스트
     */
    private static void testErrorHandling() {
        System.out.println("## 에러 처리 테스트");
        
        // 0으로 나누기 테스트
        assertNaN(Calculator.calculateWithIf(10, 0, '/'), "if: Division by zero");
        assertNaN(Calculator.calculateWithSwitch(10, 0, '/'), "switch: Division by zero");
        
        // 잘못된 연산자 테스트
        assertNaN(Calculator.calculateWithIf(10, 2, '%'), "if: Invalid operator '%'");
        assertNaN(Calculator.calculateWithSwitch(10, 2, '%'), "switch: Invalid operator '%'");
        assertNaN(Calculator.calculateWithIf(10, 2, 'x'), "if: Invalid operator 'x'");
        assertNaN(Calculator.calculateWithSwitch(10, 2, 'x'), "switch: Invalid operator 'x'");
        
        System.out.println();
    }
    
    /**
     * 테스트 어설션 헬퍼 메서드 (double)
     */
    private static void assertEquals(double expected, double actual, String testName) {
        totalTests++;
        double epsilon = 0.0001; // 부동소수점 오차 허용
        
        if (Math.abs(expected - actual) < epsilon) {
            passedTests++;
            System.out.println("✓ PASS: " + testName + " - Expected: " + expected + ", Got: " + actual);
        } else {
            System.out.println("✗ FAIL: " + testName + " - Expected: " + expected + ", Got: " + actual);
        }
    }
    
    /**
     * NaN 테스트 어설션 헬퍼 메서드
     */
    private static void assertNaN(double actual, String testName) {
        totalTests++;
        
        if (Double.isNaN(actual)) {
            passedTests++;
            System.out.println("✓ PASS: " + testName + " - Correctly returned NaN");
        } else {
            System.out.println("✗ FAIL: " + testName + " - Expected NaN, Got: " + actual);
        }
    }
    
    /**
     * 테스트 결과 요약 출력
     */
    private static void printTestSummary() {
        System.out.println("================================");
        System.out.println("Test Results Summary:");
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed: " + passedTests);
        System.out.println("Failed: " + (totalTests - passedTests));
        System.out.println("Success Rate: " + (passedTests * 100 / totalTests) + "%");
        System.out.println("================================");
    }
}
