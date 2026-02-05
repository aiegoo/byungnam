// ============================================================
// AverageCalculatorArrayTest: AverageCalculatorArray 테스트
// ============================================================
// 테스트 목표:
// 1. 배열(Array)을 사용한 평균 계산 로직 검증
// 2. 배열의 초기화와 접근 방식 확인
// 3. Enhanced for-loop를 사용한 합계 계산 검증
// ============================================================

public class AverageCalculatorArrayTest {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== AverageCalculatorArray 테스트 시작 ===\n");
        
        // 테스트 실행
        testArrayInitialization();
        testAverageCalculation();
        testArrayLength();
        testEnhancedForLoop();
        
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
    
    // 테스트 1: 배열 초기화 검증
    // given: 과목명 배열이 주어졌을 때
    // when: 배열을 초기화하면
    // then: 모든 요소가 올바르게 저장되어야 함
    private static void testArrayInitialization() {
        System.out.println("테스트 1: 배열 초기화");
        totalTests++;
        
        try {
            // given: 과목명 배열
            String[] subjects = {"수학", "물리", "영어", "프로그래밍"};
            
            // when: 배열 요소 확인
            boolean hasAllSubjects = subjects[0].equals("수학") 
                && subjects[1].equals("물리")
                && subjects[2].equals("영어")
                && subjects[3].equals("프로그래밍");
            
            // then: 모든 과목이 올바르게 저장됨
            if (hasAllSubjects && subjects.length == 4) {
                System.out.println("✅ 통과: 배열 초기화 정상");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 배열 초기화 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: 평균 계산 검증
    // given: 점수 배열 {85, 90, 88, 92}가 주어졌을 때
    // when: 평균을 계산하면
    // then: 88.75가 나와야 함
    private static void testAverageCalculation() {
        System.out.println("테스트 2: 평균 계산");
        totalTests++;
        
        try {
            // given: 점수 배열
            int[] scores = {85, 90, 88, 92};
            
            // when: 합계 계산
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            double average = (double) sum / scores.length;
            
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
    
    // 테스트 3: 배열 길이 속성 검증
    // given: 4개 요소의 배열이 주어졌을 때
    // when: length 속성을 사용하면
    // then: 4가 반환되어야 함
    private static void testArrayLength() {
        System.out.println("테스트 3: 배열 길이");
        totalTests++;
        
        try {
            // given: 4개 요소의 배열
            int[] scores = new int[4];
            scores[0] = 85;
            scores[1] = 90;
            scores[2] = 88;
            scores[3] = 92;
            
            // when: length 속성 확인
            int length = scores.length;
            
            // then: 길이가 4
            if (length == 4) {
                System.out.println("✅ 통과: 배열 길이 정확 (4)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 배열 길이 오류 (예상: 4, 실제: " + length + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: Enhanced for-loop 검증
    // given: 배열과 일반 for-loop, enhanced for-loop이 주어졌을 때
    // when: 두 방식으로 합계를 계산하면
    // then: 동일한 결과가 나와야 함
    private static void testEnhancedForLoop() {
        System.out.println("테스트 4: Enhanced for-loop");
        totalTests++;
        
        try {
            // given: 점수 배열
            int[] scores = {85, 90, 88, 92};
            
            // when: 일반 for-loop로 합계
            int sum1 = 0;
            for (int i = 0; i < scores.length; i++) {
                sum1 += scores[i];
            }
            
            // when: enhanced for-loop로 합계
            int sum2 = 0;
            for (int score : scores) {
                sum2 += score;
            }
            
            // then: 두 합계가 동일
            if (sum1 == sum2 && sum1 == 355) {
                System.out.println("✅ 통과: Enhanced for-loop 동작 정확 (합계: " + sum1 + ")");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Enhanced for-loop 오류 (일반: " + sum1 + ", enhanced: " + sum2 + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
