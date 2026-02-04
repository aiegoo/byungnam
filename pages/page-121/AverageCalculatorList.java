import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AverageCalculatorList {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 평균 계산기 (List 사용) ===");
        
        List<String> subjects = new ArrayList<>();
        subjects.add("수학");
        subjects.add("물리");
        subjects.add("영어");
        subjects.add("프로그래밍");
        
        List<Integer> scores = new ArrayList<>();
        
        for (String subject : subjects) {
            System.out.printf("%s 점수 입력: ", subject);
            scores.add(scanner.nextInt());
        }
        
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        
        double average = (double) total / scores.size();
        
        System.out.printf("%n=== 결과 ===%n");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.printf("%s: %d점%n", subjects.get(i), scores.get(i));
        }
        System.out.printf("총점: %d점%n", total);
        System.out.printf("평균: %.2f점%n", average);
        
        scanner.close();
    }
}
