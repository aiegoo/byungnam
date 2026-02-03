public class AverageCalculator {
    
    public static double calculateAverage(int math, int korean, int english, int programming) {
        return (math + korean + english + programming) / 4.0;
    }
    
    public static void main(String[] args) {
        int math = 85;
        int korean = 90;
        int english = 78;
        int programming = 95;
        
        System.out.println("=== 성적 평균 계산기 ===");
        System.out.println("수학: " + math + "점");
        System.out.println("국어: " + korean + "점");
        System.out.println("영어: " + english + "점");
        System.out.println("프로그래밍: " + programming + "점");
        System.out.println("---------------------");
        
        double average = calculateAverage(math, korean, english, programming);
        System.out.printf("평균: %.2f점%n", average);
    }
}
