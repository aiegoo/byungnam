public class CelToFahTest {
    
    private static int total = 0;
    private static int passed = 0;
    
    public static void main(String[] args) {
        System.out.println("=== CelToFah 테스트 ===\n");
        
        testCelsiusToFahrenheit();
        testFahrenheitToCelsius();
        testRoundTrip();
        
        System.out.println("\n결과: " + passed + "/" + total + " 통과");
        System.out.println(passed == total ? "✓ 모든 테스트 통과!" : "✗ 일부 실패");
    }
    
    private static void testCelsiusToFahrenheit() {
        System.out.println("[섭씨 → 화씨 변환 테스트]");
        
        //given: 물의 어는점 0°C
        //when: 화씨로 변환
        //then: 32°F
        testC2F(0, 32.0, "물의 어는점");
        
        //given: 물의 끓는점 100°C
        //when: 화씨로 변환
        //then: 212°F
        testC2F(100, 212.0, "물의 끓는점");
        
        //given: 체온 37°C
        //when: 화씨로 변환
        //then: 98.6°F
        testC2F(37, 98.6, "평균 체온");
        
        //given: 실온 25°C
        //when: 화씨로 변환
        //then: 77°F
        testC2F(25, 77.0, "실온");
        
        System.out.println();
    }
    
    private static void testFahrenheitToCelsius() {
        System.out.println("[화씨 → 섭씨 변환 테스트]");
        
        //given: 32°F (물의 어는점)
        //when: 섭씨로 변환
        //then: 0°C
        testF2C(32, 0.0, "물의 어는점");
        
        //given: 212°F (물의 끓는점)
        //when: 섭씨로 변환
        //then: 100°C
        testF2C(212, 100.0, "물의 끓는점");
        
        //given: 98.6°F (체온)
        //when: 섭씨로 변환
        //then: 37°C
        testF2C(98.6, 37.0, "평균 체온");
        
        System.out.println();
    }
    
    private static void testRoundTrip() {
        System.out.println("[왕복 변환 테스트]");
        
        //given: 임의의 섭씨 온도
        //when: 섭씨 → 화씨 → 섭씨로 변환
        //then: 원래 값으로 복원
        testRoundTripC(0, "0°C");
        testRoundTripC(25, "25°C");
        testRoundTripC(100, "100°C");
        
        System.out.println();
    }
    
    private static void testC2F(double celsius, double expectedFahrenheit, String desc) {
        total++;
        double result = CelToFah.celsiusToFahrenheit(celsius);
        if (Math.abs(result - expectedFahrenheit) < 0.1) {
            passed++;
            System.out.printf("  ✓ %s: %.1f°C → %.1f°F%n", desc, celsius, result);
        } else {
            System.out.printf("  ✗ %s: 예상=%.1f°F, 실제=%.1f°F%n", desc, expectedFahrenheit, result);
        }
    }
    
    private static void testF2C(double fahrenheit, double expectedCelsius, String desc) {
        total++;
        double result = CelToFah.fahrenheitToCelsius(fahrenheit);
        if (Math.abs(result - expectedCelsius) < 0.1) {
            passed++;
            System.out.printf("  ✓ %s: %.1f°F → %.1f°C%n", desc, fahrenheit, result);
        } else {
            System.out.printf("  ✗ %s: 예상=%.1f°C, 실제=%.1f°C%n", desc, expectedCelsius, result);
        }
    }
    
    private static void testRoundTripC(double celsius, String desc) {
        total++;
        double fahrenheit = CelToFah.celsiusToFahrenheit(celsius);
        double backToCelsius = CelToFah.fahrenheitToCelsius(fahrenheit);
        if (Math.abs(backToCelsius - celsius) < 0.01) {
            passed++;
            System.out.printf("  ✓ %s: %.1f°C → %.1f°F → %.1f°C%n", desc, celsius, fahrenheit, backToCelsius);
        } else {
            System.out.printf("  ✗ %s: 원본=%.1f°C, 복원=%.1f°C%n", desc, celsius, backToCelsius);
        }
    }
}
