/**
 * Test suite for AmusementParkFee class
 * Tests all age ranges and boundary conditions
 * 
 * @author byungnam
 */
public class AmusementParkFeeTest {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== AmusementParkFee Test Suite ===\n");
        
        // 취학 전 아동 테스트 (8살 미만)
        testPreschool();
        
        // 초등학생 테스트 (14살 미만)
        testElementary();
        
        // 중고등학생 테스트 (20살 미만)
        testHighSchool();
        
        // 성인 테스트 (60살 미만)
        testAdult();
        
        // 경로 우대 테스트 (60세 이상)
        testSenior();
        
        // 경계값 테스트
        testBoundaryValues();
        
        // 결과 요약
        printTestSummary();
    }
    
    /**
     * 취학 전 아동 테스트 (0-7세)
     */
    private static void testPreschool() {
        System.out.println("## 취학 전 아동 테스트 (8살 미만: 1,000원)");
        assertEquals(1000, AmusementParkFee.calculateFee(0), "Age 0");
        assertEquals(1000, AmusementParkFee.calculateFee(5), "Age 5");
        assertEquals(1000, AmusementParkFee.calculateFee(7), "Age 7");
        System.out.println();
    }
    
    /**
     * 초등학생 테스트 (8-13세)
     */
    private static void testElementary() {
        System.out.println("## 초등학생 테스트 (14살 미만: 2,000원)");
        assertEquals(2000, AmusementParkFee.calculateFee(8), "Age 8");
        assertEquals(2000, AmusementParkFee.calculateFee(10), "Age 10");
        assertEquals(2000, AmusementParkFee.calculateFee(13), "Age 13");
        System.out.println();
    }
    
    /**
     * 중고등학생 테스트 (14-19세)
     */
    private static void testHighSchool() {
        System.out.println("## 중고등학생 테스트 (20살 미만: 2,500원)");
        assertEquals(2500, AmusementParkFee.calculateFee(14), "Age 14");
        assertEquals(2500, AmusementParkFee.calculateFee(16), "Age 16");
        assertEquals(2500, AmusementParkFee.calculateFee(19), "Age 19");
        System.out.println();
    }
    
    /**
     * 성인 테스트 (20-59세)
     */
    private static void testAdult() {
        System.out.println("## 성인 테스트 (60살 미만: 3,000원)");
        assertEquals(3000, AmusementParkFee.calculateFee(20), "Age 20");
        assertEquals(3000, AmusementParkFee.calculateFee(30), "Age 30");
        assertEquals(3000, AmusementParkFee.calculateFee(59), "Age 59");
        System.out.println();
    }
    
    /**
     * 경로 우대 테스트 (60세 이상)
     */
    private static void testSenior() {
        System.out.println("## 경로 우대 테스트 (60세 이상: 0원)");
        assertEquals(0, AmusementParkFee.calculateFee(60), "Age 60");
        assertEquals(0, AmusementParkFee.calculateFee(70), "Age 70");
        assertEquals(0, AmusementParkFee.calculateFee(100), "Age 100");
        System.out.println();
    }
    
    /**
     * 경계값 테스트 (범주 경계 지점)
     */
    private static void testBoundaryValues() {
        System.out.println("## 경계값 테스트");
        assertEquals(1000, AmusementParkFee.calculateFee(7), "Boundary: 7 (preschool)");
        assertEquals(2000, AmusementParkFee.calculateFee(8), "Boundary: 8 (elementary)");
        assertEquals(2000, AmusementParkFee.calculateFee(13), "Boundary: 13 (elementary)");
        assertEquals(2500, AmusementParkFee.calculateFee(14), "Boundary: 14 (high school)");
        assertEquals(2500, AmusementParkFee.calculateFee(19), "Boundary: 19 (high school)");
        assertEquals(3000, AmusementParkFee.calculateFee(20), "Boundary: 20 (adult)");
        assertEquals(3000, AmusementParkFee.calculateFee(59), "Boundary: 59 (adult)");
        assertEquals(0, AmusementParkFee.calculateFee(60), "Boundary: 60 (senior)");
        System.out.println();
    }
    
    /**
     * 테스트 어설션 헬퍼 메서드
     */
    private static void assertEquals(int expected, int actual, String testName) {
        totalTests++;
        if (expected == actual) {
            passedTests++;
            System.out.println("✓ PASS: " + testName + " - Expected: " + expected + ", Got: " + actual);
        } else {
            System.out.println("✗ FAIL: " + testName + " - Expected: " + expected + ", Got: " + actual);
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
