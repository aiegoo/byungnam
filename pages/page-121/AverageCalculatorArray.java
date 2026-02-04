// Scanner 클래스를 가져오기: 사용자 입력을 받기 위해 필요
import java.util.Scanner;

// ============================================================
// Page 121: 배열(Array)을 사용한 4과목 평균 계산기
// ============================================================
// 학습 목표:
// 1. Array(배열): 고정된 크기의 같은 타입 데이터를 순서대로 저장
// 2. 배열 선언과 초기화 방법 (String[], int[])
// 3. 인덱스를 사용한 배열 접근 (subjects[i], scores[i])
// 4. 배열의 length 속성으로 크기 확인
// 5. Enhanced for loop (for-each)로 배열 순회
// ============================================================

public class AverageCalculatorArray {
    
    public static void main(String[] args) {
        // Scanner 객체 생성: 키보드 입력을 받기 위한 객체
        Scanner scanner = new Scanner(System.in);
        
        // 프로그램 제목 출력
        System.out.println("=== 평균 계산기 (Array 사용) ===");
        
        // String 배열 선언 및 초기화: 과목 이름을 저장
        // {} 안에 초기값을 넣으면 배열의 크기가 자동으로 결정됨 (크기 4)
        // subjects[0]="수학", subjects[1]="물리", subjects[2]="영어", subjects[3]="프로그래밍"
        String[] subjects = {"수학", "물리", "영어", "프로그래밍"};
        
        // int 배열 선언: 점수를 저장할 배열, 크기 4로 생성
        // new int[4]: 크기가 4인 정수 배열 생성, 모든 값은 자동으로 0으로 초기화됨
        // scores[0], scores[1], scores[2], scores[3] 총 4개의 공간
        int[] scores = new int[4];
        
        // for 반복문: 배열의 인덱스(i)를 사용하여 순회
        // i < subjects.length: subjects 배열의 크기(4)만큼 반복
        // length는 배열의 속성으로 배열의 크기를 반환 (여기서는 4)
        for (int i = 0; i < subjects.length; i++) {
            // subjects[i]: i번째 과목 이름 (i=0일 때 "수학")
            // %s는 문자열을 출력하는 형식 지정자
            System.out.printf("%s 점수 입력: ", subjects[i]);
            // scanner.nextInt(): 정수 입력을 받아서 scores 배열의 i번째에 저장
            // scores[i] = 입력값: 인덱스 i 위치에 점수 저장
            scores[i] = scanner.nextInt();
        }
        
        // total 변수 선언 및 초기화: 모든 점수의 합계를 저장 (초기값 0)
        int total = 0;
        
        // Enhanced for loop (for-each): 배열의 모든 요소를 순회
        // for (타입 변수명 : 배열명) 형식
        // scores 배열의 각 요소를 score 변수에 하나씩 담아서 반복
        // 인덱스가 필요 없을 때 사용하면 편리함
        for (int score : scores) {
            // total += score: total = total + score와 동일
            // 현재 점수를 total에 누적
            total += score;
        }
        
        // 평균 계산: 총점을 과목 수로 나눔
        // (double) total: int를 double로 형변환하여 소수점 계산 가능
        // scores.length: 배열의 크기 (4)
        double average = (double) total / scores.length;
        
        // 결과 출력 시작
        // %n: 줄바꿈 (플랫폼 독립적)
        System.out.printf("%n=== 결과 ===%n");
        
        // for 반복문: 인덱스를 사용하여 과목명과 점수를 함께 출력
        // subjects[i]와 scores[i]를 같은 인덱스로 접근하여 매칭
        for (int i = 0; i < subjects.length; i++) {
            // %s: 문자열(subjects[i]), %d: 정수(scores[i])
            System.out.printf("%s: %d점%n", subjects[i], scores[i]);
        }
        
        // 총점 출력: %d는 정수 출력 형식 지정자
        System.out.printf("총점: %d점%n", total);
        
        // 평균 출력: %.2f는 소수점 둘째 자리까지 출력
        System.out.printf("평균: %.2f점%n", average);
        
        // Scanner 리소스 해제: 메모리 누수 방지
        scanner.close();
    }
}
