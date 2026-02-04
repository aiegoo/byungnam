import java.util.Scanner;

public class AverageCalculatorGradeFor {
    
    public static String calculateGrade(int score) {
        if (score >= 95) return "A+";
        if (score >= 90) return "A";
        if (score >= 85) return "B+";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 성적 학점 계산기 (For Loop) ===");
        System.out.print("과목 개수를 입력하세요: ");
        int count = scanner.nextInt();
        
        int total = 0;
        
        for (int i = 0; i < count; i++) {
            System.out.printf("과목 %d 점수 입력: ", i + 1);
            int score = scanner.nextInt();
            total += score;
        }
        
        double average = (double) total / count;
        String grade = calculateGrade((int) average);
        
        System.out.printf("%n총점: %d점%n", total);
        System.out.printf("평균: %.2f점%n", average);
        System.out.printf("학점: %s%n", grade);
        
        scanner.close();
    }
}
