import java.util.Scanner;

public class AverageCalculatorGradeInfiniteLoop {
    
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
        
        System.out.println("=== 성적 학점 계산기 (Infinite Loop) ===");
        System.out.println("'keep' 입력: 학점 계산 | 'quit' 입력: 종료");
        
        while (true) {
            System.out.print("%n명령어를 입력하세요 (keep/quit): ");
            String command = scanner.next();
            
            if (command.equals("quit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            if (!command.equals("keep")) {
                System.out.println("올바른 명령어를 입력하세요 (keep/quit)");
                continue;
            }
            
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
        }
        
        scanner.close();
    }
}
