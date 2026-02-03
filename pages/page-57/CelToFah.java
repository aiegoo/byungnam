public class CelToFah {
    
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32.0;
    }
    
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }
    
    public static void main(String[] args) {
        double[] celsius = {0, 10, 20, 25, 30, 37, 100};
        
        System.out.println("=== 온도 변환기 ===");
        for (double c : celsius) {
            double f = celsiusToFahrenheit(c);
            System.out.printf("%.1f°C → %.1f°F%n", c, f);
        }
        
        System.out.println();
        double[] fahrenheit = {32, 50, 68, 77, 86, 98.6, 212};
        for (double f : fahrenheit) {
            double c = fahrenheitToCelsius(f);
            System.out.printf("%.1f°F → %.1f°C%n", f, c);
        }
    }
}
