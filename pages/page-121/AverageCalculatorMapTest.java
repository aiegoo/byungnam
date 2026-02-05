// ============================================================
// AverageCalculatorMapTest: AverageCalculatorMap 테스트
// ============================================================
// 테스트 목표:
// 1. Map을 사용한 평균 계산 로직 검증
// 2. HashMap의 put/get 동작 확인
// 3. Key-Value 매핑과 O(1) 조회 성능 검증
// ============================================================

import java.util.HashMap;
import java.util.Map;

public class AverageCalculatorMapTest {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== AverageCalculatorMap 테스트 시작 ===\n");
        
        // 테스트 실행
        testMapPutGet();
        testAverageCalculation();
        testKeyValueMapping();
        testMapValues();
        
        // 테스트 결과 출력
        System.out.println("\n=== 테스트 결과 ===");
        System.out.println("전체 테스트: " + totalTests);
        System.out.println("통과: " + passedTests);
        System.out.println("실패: " + (totalTests - passedTests));
        
        if (passedTests == totalTests) {
            System.out.println("\n✅ 모든 테스트 통과!");
        } else {
            System.out.println("\n❌ 일부 테스트 실패");
        }
    }
    
    // 테스트 1: Map의 put/get 검증
    // given: 빈 HashMap이 주어졌을 때
    // when: put으로 추가하고 get으로 조회하면
    // then: 올바른 값이 반환되어야 함
    private static void testMapPutGet() {
        System.out.println("테스트 1: Map put/get");
        totalTests++;
        
        try {
            // given: 빈 HashMap
            Map<String, Integer> scoreMap = new HashMap<>();
            
            // when: 과목-점수 쌍 추가
            scoreMap.put("수학", 85);
            scoreMap.put("물리", 90);
            scoreMap.put("영어", 88);
            scoreMap.put("프로그래밍", 92);
            
            // then: get으로 조회 시 올바른 값 반환
            boolean allCorrect = scoreMap.get("수학") == 85
                && scoreMap.get("물리") == 90
                && scoreMap.get("영어") == 88
                && scoreMap.get("프로그래밍") == 92;
            
            if (allCorrect && scoreMap.size() == 4) {
                System.out.println("✅ 통과: Map put/get 정상");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Map put/get 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: 평균 계산 검증
    // given: 점수 Map {수학:85, 물리:90, 영어:88, 프로그래밍:92}가 주어졌을 때
    // when: 평균을 계산하면
    // then: 88.75가 나와야 함
    private static void testAverageCalculation() {
        System.out.println("테스트 2: 평균 계산");
        totalTests++;
        
        try {
            // given: 점수 Map
            Map<String, Integer> scoreMap = new HashMap<>();
            scoreMap.put("수학", 85);
            scoreMap.put("물리", 90);
            scoreMap.put("영어", 88);
            scoreMap.put("프로그래밍", 92);
            
            // when: values()로 모든 점수를 가져와 합계 계산
            int sum = 0;
            for (int score : scoreMap.values()) {
                sum += score;
            }
            double average = (double) sum / scoreMap.size();
            
            // then: 평균이 88.75
            if (Math.abs(average - 88.75) < 0.01) {
                System.out.println("✅ 통과: 평균 계산 정확 (88.75)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 평균 계산 오류 (예상: 88.75, 실제: " + average + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 3: Key-Value 매핑 검증
    // given: 과목명과 점수가 주어졌을 때
    // when: Map에 저장하면
    // then: 과목명으로 점수를 빠르게 조회할 수 있어야 함
    private static void testKeyValueMapping() {
        System.out.println("테스트 3: Key-Value 매핑");
        totalTests++;
        
        try {
            // given: 과목명-점수 쌍
            Map<String, Integer> scoreMap = new HashMap<>();
            scoreMap.put("Java", 95);
            scoreMap.put("Python", 88);
            scoreMap.put("JavaScript", 92);
            
            // when: 특정 과목의 점수 조회
            Integer javaScore = scoreMap.get("Java");
            Integer pythonScore = scoreMap.get("Python");
            Integer jsScore = scoreMap.get("JavaScript");
            Integer notExist = scoreMap.get("C++");  // 존재하지 않는 키
            
            // then: 올바른 매핑과 null 반환
            if (javaScore == 95 && pythonScore == 88 && jsScore == 92 && notExist == null) {
                System.out.println("✅ 통과: Key-Value 매핑 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Key-Value 매핑 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: Map.values() 검증
    // given: Map에 여러 값이 저장되어 있을 때
    // when: values()를 호출하면
    // then: 모든 값의 Collection을 반환해야 함
    private static void testMapValues() {
        System.out.println("테스트 4: Map.values()");
        totalTests++;
        
        try {
            // given: 점수 Map
            Map<String, Integer> scoreMap = new HashMap<>();
            scoreMap.put("A", 10);
            scoreMap.put("B", 20);
            scoreMap.put("C", 30);
            
            // when: values()로 모든 값을 가져와 합계 계산
            int sum = 0;
            int count = 0;
            for (int value : scoreMap.values()) {
                sum += value;
                count++;
            }
            
            // then: 모든 값이 반환됨 (합계 60, 개수 3)
            if (sum == 60 && count == 3) {
                System.out.println("✅ 통과: Map.values() 정상 (합계: 60, 개수: 3)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Map.values() 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
