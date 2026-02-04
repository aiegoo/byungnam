// Scanner 클래스를 가져오기: 사용자 입력을 받기 위해 필요
import java.util.Scanner;
// HashMap 클래스를 가져오기: Key-Value 쌍으로 데이터 저장
import java.util.HashMap;
// Map 인터페이스를 가져오기: HashMap의 상위 인터페이스
import java.util.Map;

// ============================================================
// Page 121: 맵(Map)을 사용한 4과목 평균 계산기
// ============================================================
// 학습 목표:
// 1. Map(맵): Key-Value 쌍으로 데이터를 저장하는 컬렉션
// 2. HashMap 생성과 사용 방법 (put, get, values, size)
// 3. Key를 통한 빠른 Value 접근 (인덱스 불필요)
// 4. 제네릭 타입 사용 (Map<String, Integer>)
// 5. Map의 values()로 모든 값 순회
// ============================================================

public class AverageCalculatorMap {
    
    public static void main(String[] args) {
        // Scanner 객체 생성: 키보드 입력을 받기 위한 객체
        Scanner scanner = new Scanner(System.in);
        
        // 프로그램 제목 출력
        System.out.println("=== 평균 계산기 (Map 사용) ===");
        
        // String 배열: 과목 이름을 순서대로 저장 (출력 순서 유지용)
        // Map은 순서를 보장하지 않으므로 배열로 순서 관리
        String[] subjects = {"수학", "물리", "영어", "프로그래밍"};
        
        // Map<String, Integer> 객체 생성: 과목명(Key) → 점수(Value) 매핑
        // Map<String, Integer>: Key는 String, Value는 Integer 타입
        // new HashMap<>(): HashMap 객체 생성, 타입은 자동 추론
        // HashMap: 해시 테이블 기반으로 빠른 검색 가능 (O(1))
        Map<String, Integer> scoreMap = new HashMap<>();
        
        // Enhanced for loop: subjects 배열의 각 과목을 순회
        for (String subject : subjects) {
            // subject: 현재 과목명 ("수학", "물리" 등)
            System.out.printf("%s 점수 입력: ", subject);
            // put(key, value) 메서드: Map에 Key-Value 쌍 추가
            // subject를 Key로, 입력받은 점수를 Value로 저장
            // 예: put("수학", 85) → scoreMap에 "수학" → 85 매핑 저장
            // 같은 Key로 다시 put하면 Value가 덮어써짐
            scoreMap.put(subject, scanner.nextInt());
        }
        
        // total 변수 선언 및 초기화: 모든 점수의 합계를 저장
        int total = 0;
        
        // Enhanced for loop: Map의 모든 Value(점수)를 순회
        // scoreMap.values(): Map의 모든 Value를 Collection으로 반환
        // Key는 필요 없고 Value만 필요할 때 사용
        for (int score : scoreMap.values()) {
            // score: 현재 반복의 점수 값
            // total += score: 현재 점수를 total에 누적
            total += score;
        }
        
        // 평균 계산: 총점을 과목 수로 나눔
        // (double) total: int를 double로 형변환
        // scoreMap.size(): Map에 저장된 Key-Value 쌍의 개수 (여기서는 4)
        double average = (double) total / scoreMap.size();
        
        // 결과 출력 시작
        System.out.printf("%n=== 결과 ===%n");
        
        // for 반복문: subjects 배열의 순서대로 출력 (Map은 순서 없으므로)
        // Map은 입력 순서를 보장하지 않지만, 배열로 순서 제어
        for (String subject : subjects) {
            // get(key) 메서드: 주어진 Key에 매핑된 Value를 반환
            // scoreMap.get(subject): subject 과목의 점수를 가져옴
            // 예: get("수학") → 85 반환
            // Key가 존재하지 않으면 null 반환
            System.out.printf("%s: %d점%n", subject, scoreMap.get(subject));
        }
        
        // 총점 출력
        System.out.printf("총점: %d점%n", total);
        
        // 평균 출력: 소수점 둘째 자리까지
        System.out.printf("평균: %.2f점%n", average);
        
        // Scanner 리소스 해제
        scanner.close();
    }
}
