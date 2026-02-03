// Page 57-1: 섭씨 ↔ 화씨 온도 변환기
// 변환 공식: °F = °C × 9/5 + 32, °C = (°F - 32) × 5/9
public class CelToFah {
    
    // 섭씨를 화씨로 변환
    // 공식: F = C * 9/5 + 32
    // 9.0/5.0을 사용하여 정수 나눗셈 방지 (부동소수점 연산)
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }
    
    // 화씨를 섭씨로 변환
    // 공식: C = (F - 32) * 5/9
    // 역변환 관계: celsiusToFahrenheit의 역함수
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
    
    public static void main(String[] args) {
        // 테스트용 섭씨 온도 배열 (물의 어는점, 실온, 체온, 물의 끓는점 등)
        double[] celsius = {0, 10, 20, 25, 30, 37, 100};
        
        System.out.println("=== 온도 변환기 ===");
        // 섭씨 → 화씨 변환 출력
        for (double c : celsius) {
            double f = celsiusToFahrenheit(c);
            System.out.printf("%.1f°C → %.1f°F%n", c, f);
        }
        
        System.out.println();
        // 테스트용 화씨 온도 배열
        double[] fahrenheit = {32, 50, 68, 77, 86, 98.6, 212};
        // 화씨 → 섭씨 변환 출력
        for (double f : fahrenheit) {
            double c = fahrenheitToCelsius(f);
            System.out.printf("%.1f°F → %.1f°C%n", f, c);
        }
    }
}
