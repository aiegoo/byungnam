/**
 * Page No.69 - Assignment 3
 * Operator 값이 +,-,*,/ 인 경우에 사칙 연산을 수행하는 프로그램
 * 
 * 요구사항:
 * - if문과 switch문을 사용해 작성
 * - int num1 = 10;
 * - int num2 = 2;
 * - char operator = '+';
 * 
 * @author byungnam
 */
public class Calculator {
    
    /**
     * if문을 사용한 사칙연산 계산
     * @param num1 첫 번째 피연산자
     * @param num2 두 번째 피연산자
     * @param operator 연산자 (+, -, *, /)
     * @return 계산 결과 (에러 시 Double.NaN)
     */
    public static double calculateWithIf(int num1, int num2, char operator) {
        double result;
        
        if (operator == '+') { // 덧셈 연산
            result = num1 + num2;
        } else if (operator == '-') { // 뺄셈 연산
            result = num1 - num2;
        } else if (operator == '*') { // 곱셈 연산
            result = num1 * num2;
        } else if (operator == '/') { // 나눗셈 연산
            if (num2 != 0) { // 0으로 나누기 체크
                result = (double) num1 / num2;
            } else {
                System.err.println("Error: 0으로 나눌 수 없습니다.");
                return Double.NaN;
            }
        } else { // 유효하지 않은 연산자
            System.err.println("Error: 잘못된 연산자입니다.");
            return Double.NaN;
        }
        
        return result;
    }
    
    /**
     * switch문을 사용한 사칙연산 계산
     * @param num1 첫 번째 피연산자
     * @param num2 두 번째 피연산자
     * @param operator 연산자 (+, -, *, /)
     * @return 계산 결과 (에러 시 Double.NaN)
     */
    public static double calculateWithSwitch(int num1, int num2, char operator) {
        double result;
        
        switch (operator) {
            case '+': // 덧셈 연산
                result = num1 + num2;
                break;
            case '-': // 뺄셈 연산
                result = num1 - num2;
                break;
            case '*': // 곱셈 연산
                result = num1 * num2;
                break;
            case '/': // 나눗셈 연산
                if (num2 != 0) { // 0으로 나누기 체크
                    result = (double) num1 / num2;
                } else {
                    System.err.println("Error: 0으로 나눌 수 없습니다.");
                    return Double.NaN;
                }
                break;
            default: // 유효하지 않은 연산자
                System.err.println("Error: 잘못된 연산자입니다.");
                return Double.NaN;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // 요구사항에 명시된 초기값
        int num1 = 10;
        int num2 = 2;
        char operator = '+';
        
        System.out.println("=== if문 사용 ===");
        double resultIf = calculateWithIf(num1, num2, operator);
        if (!Double.isNaN(resultIf)) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + resultIf);
        }
        
        System.out.println("\n=== switch문 사용 ===");
        double resultSwitch = calculateWithSwitch(num1, num2, operator);
        if (!Double.isNaN(resultSwitch)) {
            System.out.println(num1 + " " + operator + " " + num2 + " = " + resultSwitch);
        }
    }
}
