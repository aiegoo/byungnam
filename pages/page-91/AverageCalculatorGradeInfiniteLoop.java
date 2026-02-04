// Scanner 클래스를 가져오기: 사용자 입력을 받기 위해 필요
import java.util.Scanner;

// ============================================================
// Page 91: Page 66의 if-else 조건문 로직 + 무한 반복문(Infinite Loop) 결합
// ============================================================
// 학습 목표:
// 1. Page 66에서 배운 if-else 조건문으로 학점 판단 (calculateGrade 메서드)
// 2. while(true) 무한 반복문으로 사용자가 원하는 만큼 학점 계산 반복
// 3. break와 continue로 반복 흐름 제어하는 방법 이해
// 4. 사용자 명령어(keep/quit)로 프로그램 제어하기
// ============================================================

// AverageCalculatorGradeInfiniteLoop 클래스 정의: 무한 반복문으로 학점 계산
public class AverageCalculatorGradeInfiniteLoop {
    
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
        
        // 프로그램 제목 출력: 무한 반복문 버전임을 표시
        System.out.println("=== 성적 학점 계산기 (Infinite Loop) ===");
        // 사용 방법 안내 출력: keep으로 계산 계속, quit으로 종료
        System.out.println("'keep' 입력: 학점 계산 | 'quit' 입력: 종료");
        
        // while (true): 조건이 항상 참이므로 무한 반복
        // break 문을 만나야만 반복문 탈출 가능
        while (true) {
            // %n: 줄바꿈, 명령어 입력 요청 출력
            System.out.print("%n명령어를 입력하세요 (keep/quit): ");
            // next(): 공백으로 구분된 문자열 하나를 읽어 command 변수에 저장
            String command = scanner.next();
            
            // equals(): 문자열 비교 메서드 (==는 문자열에 사용 불가)
            // command가 "quit"과 같은지 확인
            if (command.equals("quit")) {
                // quit 입력 시 종료 메시지 출력
                System.out.println("프로그램을 종료합니다.");
                // break: while 반복문을 즉시 탈출하여 프로그램 종료
                break;
            }
            
            // !command.equals("keep"): command가 "keep"이 아니면 참
            // keep도 아니고 quit도 아닌 경우 처리
            if (!command.equals("keep")) {
                // 잘못된 명령어 입력 시 안내 메시지 출력
                System.out.println("올바른 명령어를 입력하세요 (keep/quit)");
                // continue: 현재 반복을 건너뛰고 다음 반복(while 시작)으로 이동
                // 아래 코드들을 실행하지 않고 다시 명령어 입력 요청으로 돌아감
                continue;
            }
            
            // 여기까지 도달했다면 command가 "keep"인 경우
            // 과목 개수 입력 요청 (줄바꿈 없이)
            System.out.print("과목 개수를 입력하세요: ");
            // nextInt(): 정수를 읽어 count 변수에 저장
            int count = scanner.nextInt();
            
            // total 변수 선언 및 초기화: 점수 합계를 저장 (초기값 0)
            int total = 0;
            
            // for 반복문: count번만큼 점수 입력받기
            // int i = 0: 초기화, i < count: 조건, i++: 증감
            for (int i = 0; i < count; i++) {
                // printf로 과목 번호와 함께 입력 요청 출력
                // %d는 정수 출력 형식, i+1로 1부터 시작하는 번호 표시
                System.out.printf("과목 %d 점수 입력: ", i + 1);
                // nextInt(): 점수를 읽어 score 변수에 저장
                int score = scanner.nextInt();
                // total += score: total에 score를 누적 (total = total + score)
                total += score;
            }
            
            // 평균 계산: total을 count로 나눔
            // (double) total: int를 double로 형변환하여 소수점 계산 가능
            double average = (double) total / count;
            // calculateGrade 호출: 평균을 int로 변환하여 전달, 학점 문자열 받음
            // (int) average: 소수점 버림 (87.33 -> 87)
            String grade = calculateGrade((int) average);
            
            // 결과 출력 시작
            // %n: 줄바꿈, %d: 정수 출력 (total 값)
            System.out.printf("%n총점: %d점%n", total);
            // %.2f: 소수점 둘째 자리까지 출력 (average 값)
            System.out.printf("평균: %.2f점%n", average);
            // %s: 문자열 출력 (grade 값)
            System.out.printf("학점: %s%n", grade);
            // 이 반복이 끝나면 while (true)로 돌아가서 다시 명령어 입력 대기
        }
        
        // while 반복문을 break로 탈출한 후 실행
        // Scanner 리소스 해제: 메모리 누수 방지
        scanner.close();
    }
}
