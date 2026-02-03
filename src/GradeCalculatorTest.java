/**
 * Comprehensive Test Suite for GradeCalculator
 * 
 * Tests all grade boundaries, edge cases, and invalid inputs.
 * Ensures 100% coverage of grade calculation logic.
 * 
 * @author 이병남
 * @page 70
 */
public class GradeCalculatorTest {
    
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║         Grade Calculator - Comprehensive Tests          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");
        
        // Run all test categories
        testAPlusGrades();
        testAGrades();
        testBPlusGrades();
        testBGrades();
        testCGrades();
        testDGrades();
        testFGrades();
        testBoundaryValues();
        testInvalidInputs();
        
        // Display results
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Test Summary:");
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Passed: " + passedTests);
        System.out.println("Failed: " + (totalTests - passedTests));
        System.out.println("Success Rate: " + (passedTests * 100.0 / totalTests) + "%");
        System.out.println("=".repeat(60));
        
        if (passedTests == totalTests) {
            System.out.println("\n✅ All tests PASSED! Grade calculator is working perfectly!");
        } else {
            System.out.println("\n❌ Some tests FAILED. Please review the implementation.");
        }
    }
    
    // Test A+ grade range (95-100)
    private static void testAPlusGrades() {
        System.out.println("\n📌 Testing A+ Grades (95-100):");
        assertEquals("100 should be A+", "A+", GradeCalculator.calculateGrade(100));
        assertEquals("99 should be A+", "A+", GradeCalculator.calculateGrade(99));
        assertEquals("97 should be A+", "A+", GradeCalculator.calculateGrade(97));
        assertEquals("95 should be A+", "A+", GradeCalculator.calculateGrade(95));
    }
    
    // Test A grade range (90-94)
    private static void testAGrades() {
        System.out.println("\n📌 Testing A Grades (90-94):");
        assertEquals("94 should be A", "A", GradeCalculator.calculateGrade(94));
        assertEquals("92 should be A", "A", GradeCalculator.calculateGrade(92));
        assertEquals("90 should be A", "A", GradeCalculator.calculateGrade(90));
    }
    
    // Test B+ grade range (85-89)
    private static void testBPlusGrades() {
        System.out.println("\n📌 Testing B+ Grades (85-89):");
        assertEquals("89 should be B+", "B+", GradeCalculator.calculateGrade(89));
        assertEquals("87 should be B+", "B+", GradeCalculator.calculateGrade(87));
        assertEquals("85 should be B+", "B+", GradeCalculator.calculateGrade(85));
    }
    
    // Test B grade range (80-84)
    private static void testBGrades() {
        System.out.println("\n📌 Testing B Grades (80-84):");
        assertEquals("84 should be B", "B", GradeCalculator.calculateGrade(84));
        assertEquals("82 should be B", "B", GradeCalculator.calculateGrade(82));
        assertEquals("80 should be B", "B", GradeCalculator.calculateGrade(80));
    }
    
    // Test C grade range (70-79)
    private static void testCGrades() {
        System.out.println("\n📌 Testing C Grades (70-79):");
        assertEquals("79 should be C", "C", GradeCalculator.calculateGrade(79));
        assertEquals("75 should be C", "C", GradeCalculator.calculateGrade(75));
        assertEquals("70 should be C", "C", GradeCalculator.calculateGrade(70));
    }
    
    // Test D grade range (60-69)
    private static void testDGrades() {
        System.out.println("\n📌 Testing D Grades (60-69):");
        assertEquals("69 should be D", "D", GradeCalculator.calculateGrade(69));
        assertEquals("65 should be D", "D", GradeCalculator.calculateGrade(65));
        assertEquals("60 should be D", "D", GradeCalculator.calculateGrade(60));
    }
    
    // Test F grade range (0-59)
    private static void testFGrades() {
        System.out.println("\n📌 Testing F Grades (0-59):");
        assertEquals("59 should be F", "F", GradeCalculator.calculateGrade(59));
        assertEquals("50 should be F", "F", GradeCalculator.calculateGrade(50));
        assertEquals("25 should be F", "F", GradeCalculator.calculateGrade(25));
        assertEquals("0 should be F", "F", GradeCalculator.calculateGrade(0));
    }
    
    // Test critical boundary values
    private static void testBoundaryValues() {
        System.out.println("\n📌 Testing Boundary Values:");
        
        // Critical boundaries between grades
        assertEquals("95 (A+ lower bound)", "A+", GradeCalculator.calculateGrade(95));
        assertEquals("94 (A upper bound)", "A", GradeCalculator.calculateGrade(94));
        
        assertEquals("90 (A lower bound)", "A", GradeCalculator.calculateGrade(90));
        assertEquals("89 (B+ upper bound)", "B+", GradeCalculator.calculateGrade(89));
        
        assertEquals("85 (B+ lower bound)", "B+", GradeCalculator.calculateGrade(85));
        assertEquals("84 (B upper bound)", "B", GradeCalculator.calculateGrade(84));
        
        assertEquals("80 (B lower bound)", "B", GradeCalculator.calculateGrade(80));
        assertEquals("79 (C upper bound)", "C", GradeCalculator.calculateGrade(79));
        
        assertEquals("70 (C lower bound)", "C", GradeCalculator.calculateGrade(70));
        assertEquals("69 (D upper bound)", "D", GradeCalculator.calculateGrade(69));
        
        assertEquals("60 (D lower bound)", "D", GradeCalculator.calculateGrade(60));
        assertEquals("59 (F upper bound)", "F", GradeCalculator.calculateGrade(59));
    }
    
    // Test invalid inputs
    private static void testInvalidInputs() {
        System.out.println("\n📌 Testing Invalid Inputs:");
        assertEquals("Score > 100 should be Invalid", "Invalid", GradeCalculator.calculateGrade(101));
        assertEquals("Score 150 should be Invalid", "Invalid", GradeCalculator.calculateGrade(150));
        assertEquals("Score -1 should be Invalid", "Invalid", GradeCalculator.calculateGrade(-1));
        assertEquals("Score -50 should be Invalid", "Invalid", GradeCalculator.calculateGrade(-50));
    }
    
    // Helper method to assert equality
    private static void assertEquals(String testName, String expected, String actual) {
        totalTests++;
        if (expected.equals(actual)) {
            passedTests++;
            System.out.println("  ✅ PASS: " + testName);
        } else {
            System.out.println("  ❌ FAIL: " + testName);
            System.out.println("     Expected: " + expected + ", Got: " + actual);
        }
    }
}
