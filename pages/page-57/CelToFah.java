// Page 57-1: 섭씨 ↔ 화씨 온도 변환기
// 변환 공식: °F = °C × 9/5 + 32, °C = (°F - 32) × 5/9
public class CelToFah {
    
    // 섭씨를 화씨로 변환하는 메서드
    // 매개변수 celsius: 변환할 섭씨 온도값 (double 타입으로 소수점 지원)
    // 반환값: 변환된 화씨 온도값 (double 타입)
    // 공식: F = C * 9/5 + 32
    // 9.0/5.0을 사용하는 이유: 정수 나눗셈을 피하고 정확한 부동소수점 연산을 위함
    // 예: celsius가 0이면 → 0 * 9.0 / 5.0 + 32.0 = 0 + 32 = 32.0 (화씨)
    public static double celsiusToFahrenheit(double celsius) {
        // celsius 값을 9.0으로 곱한 후 5.0으로 나누고, 마지막에 32.0을 더함
        // 연산 순서: 곱셈(*) → 나눗셈(/) → 덧셈(+)
        return celsius * 9.0 / 5.0 + 32.0;
    }
    
    // 화씨를 섭씨로 변환하는 메서드
    // 매개변수 fahrenheit: 변환할 화씨 온도값 (double 타입)
    // 반환값: 변환된 섭씨 온도값 (double 타입)
    // 공식: C = (F - 32) * 5/9
    // celsiusToFahrenheit의 역함수 관계: F를 입력하면 원래 C값 복원
    // 예: fahrenheit가 32이면 → (32 - 32) * 5.0 / 9.0 = 0 * 5.0 / 9.0 = 0.0 (섭씨)
    public static double fahrenheitToCelsius(double fahrenheit) {
        // 먼저 fahrenheit에서 32.0을 뺌 (괄호로 먼저 계산)
        // 그 결과에 5.0을 곱하고 9.0으로 나눔
        // 연산 순서: 괄호 안 뺄셈(-) → 곱셈(*) → 나눗셈(/)
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
    
    // 메인 메서드: 프로그램 진입점
    // args: 명령줄 인자 배열 (여기서는 사용하지 않음)
    public static void main(String[] args) {
        // celsius 배열: 테스트할 섭씨 온도값들을 저장
        // double[] 타입: 실수(소수점) 배열
        // 초기화: 0°C(물의 어는점), 10°C, 20°C, 25°C(실온), 30°C, 37°C(체온), 100°C(물의 끓는점)
        double[] celsius = {0, 10, 20, 25, 30, 37, 100};
        
        // 제목 출력: println은 출력 후 자동 줄바꿈
        System.out.println("=== 온도 변환기 ===");
        
        // 향상된 for문 (for-each): celsius 배열의 모든 요소를 순회
        // 각 반복마다 배열의 한 요소가 변수 c에 할당됨
        // c는 double 타입으로, celsius 배열의 각 온도값을 순서대로 받음
        for (double c : celsius) {
            // celsiusToFahrenheit 메서드를 호출하여 c를 화씨로 변환
            // 변환 결과를 변수 f에 저장 (double 타입)
            double f = celsiusToFahrenheit(c);
            
            // printf: 형식화된 출력 (format string 사용)
            // %.1f: 소수점 첫째자리까지 표시하는 부동소수점 형식 지정자
            // %n: 플랫폼 독립적인 줄바꿈 문자
            // 출력 예: "0.0°C → 32.0°F"
            System.out.printf("%.1f°C → %.1f°F%n", c, f);
        }
        
        // 빈 줄 출력: 섭씨→화씨 결과와 화씨→섭씨 결과를 구분하기 위함
        System.out.println();
        
        // fahrenheit 배열: 테스트할 화씨 온도값들을 저장
        // 32°F(물의 어는점), 50°F, 68°F(실온), 77°F, 86°F, 98.6°F(체온), 212°F(물의 끓는점)
        double[] fahrenheit = {32, 50, 68, 77, 86, 98.6, 212};
        
        // 향상된 for문: fahrenheit 배열의 모든 요소를 순회
        // 각 반복마다 배열의 한 요소가 변수 f에 할당됨
        for (double f : fahrenheit) {
            // fahrenheitToCelsius 메서드를 호출하여 f를 섭씨로 변환
            // 변환 결과를 변수 c에 저장
            double c = fahrenheitToCelsius(f);
            
            // printf로 화씨→섭씨 변환 결과 출력
            // 출력 예: "32.0°F → 0.0°C"
            System.out.printf("%.1f°F → %.1f°C%n", f, c);
        }
    }
}
