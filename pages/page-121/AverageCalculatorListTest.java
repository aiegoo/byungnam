// ============================================================
// AverageCalculatorListTest: AverageCalculatorList 테스트
// ============================================================
// 테스트 목표:
// 1. List를 사용한 평균 계산 로직 검증
// 2. ArrayList의 동적 추가(add) 기능 확인
// 3. Generics와 auto-boxing/unboxing 동작 검증
// ============================================================

import java.util.ArrayList;
import java.util.List;

public class AverageCalculatorListTest {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== AverageCalculatorList 테스트 시작 ===\n");
        
        // 테스트 실행
        testListInitialization();
        testAverageCalculation();
        testListDynamicSize();
        testAutoBoxingUnboxing();
        
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
    
    // 테스트 1: List 초기화 및 add 검증
    // given: 빈 ArrayList가 주어졌을 때
    // when: add 메서드로 요소를 추가하면
    // then: 모든 요소가 순서대로 저장되어야 함
    private static void testListInitialization() {
        System.out.println("테스트 1: List 초기화 및 add");
        totalTests++;
        
        try {
            // given: 빈 ArrayList
            List<String> subjects = new ArrayList<>();
            
            // when: 과목 추가
            subjects.add("수학");
            subjects.add("물리");
            subjects.add("영어");
            subjects.add("프로그래밍");
            
            // then: 모든 과목이 순서대로 저장됨
            boolean hasAllSubjects = subjects.get(0).equals("수학")
                && subjects.get(1).equals("물리")
                && subjects.get(2).equals("영어")
                && subjects.get(3).equals("프로그래밍")
                && subjects.size() == 4;
            
            if (hasAllSubjects) {
                System.out.println("✅ 통과: List 초기화 및 add 정상");
                passedTests++;
            } else {
                System.out.println("❌ 실패: List 초기화 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: 평균 계산 검증
    // given: 점수 List {85, 90, 88, 92}가 주어졌을 때
    // when: 평균을 계산하면
    // then: 88.75가 나와야 함
    private static void testAverageCalculation() {
        System.out.println("테스트 2: 평균 계산");
        totalTests++;
        
        try {
            // given: 점수 List
            List<Integer> scores = new ArrayList<>();
            scores.add(85);
            scores.add(90);
            scores.add(88);
            scores.add(92);
            
            // when: 합계 계산 (auto-unboxing)
            int sum = 0;
            for (int i = 0; i < scores.size(); i++) {
                sum += scores.get(i);  // Integer -> int 자동 변환
            }
            double average = (double) sum / scores.size();
            
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
    
    // 테스트 3: List의 동적 크기 검증
    // given: 빈 ArrayList가 주어졌을 때
    // when: 요소를 추가하면서 size를 확인하면
    // then: size가 동적으로 증가해야 함
    private static void testListDynamicSize() {
        System.out.println("테스트 3: List 동적 크기");
        totalTests++;
        
        try {
            // given: 빈 ArrayList
            List<Integer> scores = new ArrayList<>();
            
            // when: 요소를 하나씩 추가하며 size 확인
            boolean sizesCorrect = (scores.size() == 0);  // 초기: 0
            scores.add(85);
            sizesCorrect = sizesCorrect && (scores.size() == 1);
            scores.add(90);
            sizesCorrect = sizesCorrect && (scores.size() == 2);
            scores.add(88);
            sizesCorrect = sizesCorrect && (scores.size() == 3);
            scores.add(92);
            sizesCorrect = sizesCorrect && (scores.size() == 4);
            
            // then: 각 단계마다 size가 정확
            if (sizesCorrect) {
                System.out.println("✅ 통과: List 동적 크기 변경 정상 (0→1→2→3→4)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: List 크기 변경 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: Auto-boxing/Unboxing 검증
    // given: List<Integer>가 주어졌을 때
    // when: int 값을 add하고 get으로 가져오면
    // then: 자동으로 boxing/unboxing이 수행되어야 함
    private static void testAutoBoxingUnboxing() {
        System.out.println("테스트 4: Auto-boxing/Unboxing");
        totalTests++;
        
        try {
            // given: List<Integer>
            List<Integer> numbers = new ArrayList<>();
            
            // when: int 값을 add (auto-boxing: int -> Integer)
            int primitiveValue = 42;
            numbers.add(primitiveValue);  // int가 자동으로 Integer로 boxing됨
            
            // when: get으로 가져오기 (auto-unboxing: Integer -> int)
            int retrievedValue = numbers.get(0);  // Integer가 자동으로 int로 unboxing됨
            
            // then: 값이 동일하게 유지됨
            if (primitiveValue == retrievedValue) {
                System.out.println("✅ 통과: Auto-boxing/Unboxing 정상 (42 -> Integer -> 42)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Auto-boxing/Unboxing 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
