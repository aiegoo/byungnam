/**
 * Test suite for BuildingFloor class
 * Tests all floor numbers and edge cases
 * 
 * @author byungnam
 */
public class BuildingFloorTest {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== BuildingFloor Test Suite ===\n");
        
        // 정상 층 테스트 (1-5층)
        testValidFloors();
        
        // 잘못된 층 테스트
        testInvalidFloors();
        
        // 특정 요구사항 테스트: 5층 헬스 클럽
        testRequirement();
        
        // 결과 요약
        printTestSummary();
    }
    
    /**
     * 정상 층 테스트 (1-5층)
     */
    private static void testValidFloors() {
        System.out.println("## 정상 층 테스트 (1-5층)");
        assertEquals("1층 약국입니다.", BuildingFloor.getFloorInfo(1), "Floor 1: 약국");
        assertEquals("2층 정형외과입니다.", BuildingFloor.getFloorInfo(2), "Floor 2: 정형외과");
        assertEquals("3층 피부과입니다.", BuildingFloor.getFloorInfo(3), "Floor 3: 피부과");
        assertEquals("4층 치과입니다.", BuildingFloor.getFloorInfo(4), "Floor 4: 치과");
        assertEquals("5층 헬스 클럽입니다.", BuildingFloor.getFloorInfo(5), "Floor 5: 헬스 클럽");
        System.out.println();
    }
    
    /**
     * 잘못된 층 테스트
     */
    private static void testInvalidFloors() {
        System.out.println("## 잘못된 층 테스트");
        assertEquals("해당 층은 없습니다.", BuildingFloor.getFloorInfo(0), "Floor 0 (invalid)");
        assertEquals("해당 층은 없습니다.", BuildingFloor.getFloorInfo(6), "Floor 6 (invalid)");
        assertEquals("해당 층은 없습니다.", BuildingFloor.getFloorInfo(-1), "Floor -1 (invalid)");
        assertEquals("해당 층은 없습니다.", BuildingFloor.getFloorInfo(10), "Floor 10 (invalid)");
        System.out.println();
    }
    
    /**
     * 요구사항 특정 테스트: 5층 헬스 클럽
     * "5층인 경우 '5층 헬스 클럽입니다.'라고 출력되도록 구현"
     */
    private static void testRequirement() {
        System.out.println("## 요구사항 테스트: 5층 헬스 클럽");
        String expected = "5층 헬스 클럽입니다.";
        String actual = BuildingFloor.getFloorInfo(5);
        assertEquals(expected, actual, "Requirement: 5층 헬스 클럽 메시지");
        System.out.println();
    }
    
    /**
     * 테스트 어설션 헬퍼 메서드
     */
    private static void assertEquals(String expected, String actual, String testName) {
        totalTests++;
        if (expected.equals(actual)) {
            passedTests++;
            System.out.println("✓ PASS: " + testName);
            System.out.println("  Expected: \"" + expected + "\"");
            System.out.println("  Got:      \"" + actual + "\"");
        } else {
            System.out.println("✗ FAIL: " + testName);
            System.out.println("  Expected: \"" + expected + "\"");
            System.out.println("  Got:      \"" + actual + "\"");
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
