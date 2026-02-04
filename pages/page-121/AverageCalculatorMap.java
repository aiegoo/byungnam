import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class AverageCalculatorMap {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== 평균 계산기 (Map 사용) ===");
        
        String[] subjects = {"수학", "물리", "영어", "프로그래밍"};
        Map<String, Integer> scoreMap = new HashMap<>();
        
        for (String subject : subjects) {
            System.out.printf("%s 점수 입력: ", subject);
            scoreMap.put(subject, scanner.nextInt());
        }
        
        int total = 0;
        for (int score : scoreMap.values()) {
            total += score;
        }
        
        double average = (double) total / scoreMap.size();
        
        System.out.printf("%n=== 결과 ===%n");
        for (String subject : subjects) {
            System.out.printf("%s: %d점%n", subject, scoreMap.get(subject));
        }
        System.out.printf("총점: %d점%n", total);
        System.out.printf("평균: %.2f점%n", average);
        
        scanner.close();
    }
}
