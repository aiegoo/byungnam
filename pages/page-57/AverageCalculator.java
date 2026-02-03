// Page 57-2: 4과목 평균 계산기
// 수학, 국어, 영어, 프로그래밍 점수의 평균을 구함
public class AverageCalculator {
    
    // 4과목의 평균을 계산하여 반환
    // 정수 나눗셈을 피하기 위해 4.0으로 나눔 (부동소수점 연산)
    // 소수점 결과가 필요하므로 반환 타입은 double
    public static double calculateAverage(int math, int korean, int english, int programming) {
        return (math + korean + english + programming) / 4.0;
    }
    
    public static void main(String[] args) {
        // 각 과목의 점수 (예시)
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
        
        // 평균 계산 및 소수점 둘째자리까지 출력
        double average = calculateAverage(math, korean, english, programming);
        System.out.printf("평균: %.2f점%n", average);
    }
}
