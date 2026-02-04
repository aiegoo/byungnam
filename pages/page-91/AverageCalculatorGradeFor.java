// Scanner 클래스를 가져오기: 사용자 입력을 받기 위해 필요
import java.util.Scanner;

// AverageCalculatorGradeFor 클래스 정의: for 반복문으로 학점 계산
public class AverageCalculatorGradeFor {
    
    // calculateGrade 메서드: 점수를 받아 학점을 반환하는 함수
    // 매개변수 int score: 평균 점수 (0-100 사이의 정수)
    // 반환값 String: 학점 문자열 (A+, A, B+, B, C, D, F 중 하나)
    public static String calculateGrade(int score) {
        // 95점 이상이면 "A+" 학점을 반환하고 메서드 종료
        if (score >= 95) return "A+";
        // 90점 이상이면 "A" 학점을 반환하고 메서드 종료
        if (score >= 90) return "A";
        // 85점 이상이면 "B+" 학점을 반환하고 메서드 종료
        if (score >= 85) return "B+";
        // 80점 이상이면 "B" 학점을 반환하고 메서드 종료
        if (score >= 80) return "B";
        // 70점 이상이면 "C" 학점을 반환하고 메서드 종료
        if (score >= 70) return "C";
        // 60점 이상이면 "D" 학점을 반환하고 메서드 종료
        if (score >= 60) return "D";
        // 위의 모든 조건에 해당하지 않으면 (60점 미만) "F" 학점 반환
        return "F";
    }
    
    // main 메서드: 프로그램의 시작점
    public static void main(String[] args) {
        // Scanner 객체 생성: System.in(키보드 입력)으로부터 데이터를 읽음
        Scanner scanner = new Scanner(System.in);
        
        // 프로그램 제목 출력: for 반복문 버전임을 표시
        System.out.println("=== 성적 학점 계산기 (For Loop) ===");
        // 과목 개수 입력 요청 메시지 출력 (줄바꿈 없이)
        System.out.print("과목 개수를 입력하세요: ");
        // nextInt(): 사용자가 입력한 정수를 읽어 count 변수에 저장
        int count = scanner.nextInt();
        
        // total 변수 선언 및 초기화: 모든 과목 점수의 합을 저장 (초기값 0)
        int total = 0;
        
        // for 반복문: 초기화(int i=0), 조건(i<count), 증감(i++)을 한 줄에 작성
        // 1. int i = 0: 카운터 변수 i를 0으로 초기화 (반복문 시작 전 1회 실행)
        // 2. i < count: i가 count보다 작으면 반복 계속 (매 반복마다 검사)
        // 3. i++: 각 반복이 끝날 때마다 i를 1씩 증가
        // 예: count=3이면 i=0, 1, 2일 때 반복 (총 3번 실행)
        for (int i = 0; i < count; i++) {
            // printf로 과목 번호와 함께 입력 요청 출력 (i+1은 1부터 시작하도록)
            // %d는 정수를 출력하는 형식 지정자
            System.out.printf("과목 %d 점수 입력: ", i + 1);
            // nextInt(): 사용자가 입력한 점수를 읽어 score 변수에 저장
            int score = scanner.nextInt();
            // total += score는 total = total + score와 동일
            // 현재 입력받은 점수를 total에 누적
            total += score;
            // for 반복문은 자동으로 i++를 실행하여 다음 반복으로 이동
        }
        
        // 평균 계산: total을 count로 나눔
        // (double) total: int를 double로 형변환하여 소수점 계산 가능하게 함
        // 형변환 없이 total / count 하면 정수 나눗셈이 되어 소수점 버려짐
        double average = (double) total / count;
        // calculateGrade 메서드 호출: 평균을 int로 변환하여 전달
        // (int) average: double을 int로 변환 (소수점 버림)
        // 반환된 학점 문자열을 grade 변수에 저장
        String grade = calculateGrade((int) average);
        
        // %n: 플랫폼 독립적인 줄바꿈 (\n과 유사하지만 운영체제에 맞게 자동 변환)
        // %d: 정수를 출력하는 형식 지정자 (total 값이 들어감)
        System.out.printf("%n총점: %d점%n", total);
        // %.2f: 소수점 둘째 자리까지 출력하는 형식 지정자 (average 값이 들어감)
        System.out.printf("평균: %.2f점%n", average);
        // %s: 문자열을 출력하는 형식 지정자 (grade 값이 들어감)
        System.out.printf("학점: %s%n", grade);
        
        // Scanner 리소스 해제: 메모리 누수 방지를 위해 사용 후 닫아줌
        scanner.close();
    }
}
