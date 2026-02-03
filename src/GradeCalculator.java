/**
 * Page No.70 - Grade Calculator
 * 
 * This program calculates letter grades based on numerical scores.
 * Uses if-else if-else conditional statements to determine grade ranges.
 * 
 * Grade Scale:
 * - A+: 95-100
 * - A:  90-94
 * - B+: 85-89
 * - B:  80-84
 * - C:  70-79
 * - D:  60-69
 * - F:  0-59
 * 
 * @author 이병남
 * @page 70
 */
public class GradeCalculator {
    
    /**
     * Calculates the letter grade based on the numerical score.
     * 
     * @param score The numerical score (0-100)
     * @return The letter grade (A+, A, B+, B, C, D, or F)
     */
    public static String calculateGrade(int score) {
        // KEEP: Validate score is within valid range
        if (score < 0 || score > 100) {
            return "Invalid";
        }
        
        // Check grade ranges from highest to lowest
        if (score >= 95) {
            return "A+";
        } else if (score >= 90) {
            return "A";
        } else if (score >= 85) {
            return "B+";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    /**
     * Main method to demonstrate grade calculation.
     * Tests various score values and displays their corresponding grades.
     */
    public static void main(String[] args) {
        // Test cases demonstrating the grade calculator
        int[] testScores = {100, 95, 92, 88, 83, 75, 65, 55};
        
        System.out.println("=== Grade Calculator Demo ===\n");
        
        for (int score : testScores) {
            String grade = calculateGrade(score);
            System.out.println("Score: " + score + " → Grade: " + grade);
        }
        
        System.out.println("\n=== Custom Score Example ===");
        int myScore = 87;
        String myGrade = calculateGrade(myScore);
        System.out.println("My score of " + myScore + " gives me a grade of: " + myGrade);
    }
}
