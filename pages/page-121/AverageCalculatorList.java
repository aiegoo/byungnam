// Scanner 클래스를 가져오기: 사용자 입력을 받기 위해 필요
import java.util.Scanner;
// ArrayList 클래스를 가져오기: 동적 크기 리스트 사용
import java.util.ArrayList;
// List 인터페이스를 가져오기: ArrayList의 상위 인터페이스
import java.util.List;

// ============================================================
// Page 121: 리스트(List)를 사용한 4과목 평균 계산기
// ============================================================
// 학습 목표:
// 1. List(리스트): 동적으로 크기가 변하는 순서있는 컬렉션
// 2. ArrayList 생성과 사용 방법 (add, get, size)
// 3. List vs Array: 크기 변경 가능 vs 고정 크기
// 4. 제네릭 타입 사용 (List<String>, List<Integer>)
// 5. Enhanced for loop으로 List 순회
// ============================================================

public class AverageCalculatorList {
    
    public static void main(String[] args) {
        // Scanner 객체 생성: 키보드 입력을 받기 위한 객체
        Scanner scanner = new Scanner(System.in);
        
        // 프로그램 제목 출력
        System.out.println("=== 평균 계산기 (List 사용) ===");
        
        // List<String> 객체 생성: 과목 이름을 저장할 리스트
        // List<String>: String 타입만 저장할 수 있는 리스트 (제네릭)
        // new ArrayList<>(): ArrayList 객체 생성, <>는 타입 추론으로 생략 가능
        List<String> subjects = new ArrayList<>();
        
        // add() 메서드: 리스트의 끝에 요소 추가
        // 배열과 달리 크기를 미리 정할 필요 없이 동적으로 추가 가능
        subjects.add("수학");       // 인덱스 0에 "수학" 추가
        subjects.add("물리");       // 인덱스 1에 "물리" 추가
        subjects.add("영어");       // 인덱스 2에 "영어" 추가
        subjects.add("프로그래밍"); // 인덱스 3에 "프로그래밍" 추가
        
        // List<Integer> 객체 생성: 점수를 저장할 리스트
        // Integer는 int의 Wrapper 클래스 (컬렉션은 primitive 타입 사용 불가)
        // 빈 리스트로 시작, 나중에 add()로 점수 추가 예정
        List<Integer> scores = new ArrayList<>();
        
        // Enhanced for loop: subjects 리스트의 각 과목명을 순회
        // for (타입 변수명 : 컬렉션) 형식
        for (String subject : subjects) {
            // subject: 현재 반복의 과목명 ("수학", "물리", "영어", "프로그래밍")
            System.out.printf("%s 점수 입력: ", subject);
            // add() 메서드: 입력받은 점수를 scores 리스트에 추가
            // nextInt()로 입력받은 int는 자동으로 Integer로 박싱됨 (Auto-boxing)
            scores.add(scanner.nextInt());
        }
        
        // total 변수 선언 및 초기화: 모든 점수의 합계를 저장
        int total = 0;
        
        // Enhanced for loop: scores 리스트의 각 점수를 순회
        // Integer 타입 score가 자동으로 int로 언박싱됨 (Auto-unboxing)
        for (int score : scores) {
            // total += score: 현재 점수를 total에 누적
            total += score;
        }
        
        // 평균 계산: 총점을 과목 수로 나눔
        // (double) total: int를 double로 형변환
        // scores.size(): 리스트의 크기 반환 (배열의 length와 유사, 여기서는 4)
        double average = (double) total / scores.size();
        
        // 결과 출력 시작
        System.out.printf("%n=== 결과 ===%n");
        
        // for 반복문: 인덱스를 사용하여 순회
        // i < subjects.size(): subjects 리스트의 크기만큼 반복
        for (int i = 0; i < subjects.size(); i++) {
            // get(i) 메서드: 인덱스 i 위치의 요소를 반환
            // subjects.get(i): i번째 과목명
            // scores.get(i): i번째 점수
            System.out.printf("%s: %d점%n", subjects.get(i), scores.get(i));
        }
        
        // 총점 출력
        System.out.printf("총점: %d점%n", total);
        
        // 평균 출력: 소수점 둘째 자리까지
        System.out.printf("평균: %.2f점%n", average);
        
        // Scanner 리소스 해제
        scanner.close();
    }
}
