import java.util.Scanner;

public class AverageCalculatorArray {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 평균 계산기 (Array 사용) ===");
        
        String[] subjects = {"수학", "물리", "영어", "프로그래밍"};
        int[] scores = new int[4];
        
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%s 점수 입력: ", subjects[i]);
            scores[i] = scanner.nextInt();
        }
        
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        
        double average = (double) total / scores.length;
        
        System.out.printf("%n=== 결과 ===%n");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%s: %d점%n", subjects[i], scores[i]);
        }
        System.out.printf("총점: %d점%n", total);
        System.out.printf("평균: %.2f점%n", average);
        
        scanner.close();
    }
}
