// ============================================================
// DateValidatorTest: DateValidator 테스트 스위트
// ============================================================
// 테스트 목표:
// 1. 날짜 유효성 검증 로직 확인
// 2. 윤년 계산 정확성 검증
// 3. 나이 계산 정확성 검증
// ============================================================

public class DateValidatorTest {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== DateValidator 테스트 시작 ===\n");
        
        // 테스트 실행
        testValidDate();
        testInvalidMonth();
        testInvalidDay();
        testInvalidYear();
        testLeapYear();
        testNonLeapYear();
        testFebruaryInLeapYear();
        testFebruaryInNonLeapYear();
        testAgeCalculation();
        testDateStringParsing();
        
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
    
    // 테스트 1: 유효한 날짜
    // given: 유효한 년, 월, 일이 주어졌을 때
    // when: isValidDate를 호출하면
    // then: true를 반환해야 함
    private static void testValidDate() {
        System.out.println("테스트 1: 유효한 날짜");
        totalTests++;
        
        try {
            // given: 유효한 날짜
            boolean result = DateValidator.isValidDate(1976, 2, 7);
            
            // then: true 반환
            if (result) {
                System.out.println("✅ 통과: 1976-02-07은 유효한 날짜");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 유효한 날짜를 무효로 판정");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: 무효한 월
    // given: 월이 13인 날짜가 주어졌을 때
    // when: isValidDate를 호출하면
    // then: false를 반환해야 함
    private static void testInvalidMonth() {
        System.out.println("테스트 2: 무효한 월");
        totalTests++;
        
        try {
            // given: 월이 13
            boolean result = DateValidator.isValidDate(2000, 13, 1);
            
            // then: false 반환
            if (!result) {
                System.out.println("✅ 통과: 13월은 무효한 날짜");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 무효한 월을 유효로 판정");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 3: 무효한 일
    // given: 일이 32인 날짜가 주어졌을 때
    // when: isValidDate를 호출하면
    // then: false를 반환해야 함
    private static void testInvalidDay() {
        System.out.println("테스트 3: 무효한 일");
        totalTests++;
        
        try {
            // given: 일이 32 (1월은 31일까지)
            boolean result = DateValidator.isValidDate(2000, 1, 32);
            
            // then: false 반환
            if (!result) {
                System.out.println("✅ 통과: 1월 32일은 무효한 날짜");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 무효한 일을 유효로 판정");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: 무효한 년도
    // given: 년도가 1800인 날짜가 주어졌을 때
    // when: isValidDate를 호출하면
    // then: false를 반환해야 함
    private static void testInvalidYear() {
        System.out.println("테스트 4: 무효한 년도");
        totalTests++;
        
        try {
            // given: 년도가 1800 (1900년 이전)
            boolean result = DateValidator.isValidDate(1800, 1, 1);
            
            // then: false 반환
            if (!result) {
                System.out.println("✅ 통과: 1800년은 유효 범위 밖");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 무효한 년도를 유효로 판정");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 5: 윤년 판정
    // given: 2000년, 2004년이 주어졌을 때
    // when: 2월 29일로 날짜를 검증하면
    // then: 윤년이므로 유효해야 함
    private static void testLeapYear() {
        System.out.println("테스트 5: 윤년 판정");
        totalTests++;
        
        try {
            // given: 윤년 (2000, 2004)
            boolean result2000 = DateValidator.isValidDate(2000, 2, 29);
            boolean result2004 = DateValidator.isValidDate(2004, 2, 29);
            
            // then: 2월 29일이 유효
            if (result2000 && result2004) {
                System.out.println("✅ 통과: 2000년, 2004년은 윤년");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 윤년 판정 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 6: 평년 판정
    // given: 1900년, 2001년이 주어졌을 때
    // when: 2월 29일로 날짜를 검증하면
    // then: 평년이므로 무효해야 함
    private static void testNonLeapYear() {
        System.out.println("테스트 6: 평년 판정");
        totalTests++;
        
        try {
            // given: 평년 (1900, 2001)
            boolean result1900 = DateValidator.isValidDate(1900, 2, 29);
            boolean result2001 = DateValidator.isValidDate(2001, 2, 29);
            
            // then: 2월 29일이 무효
            if (!result1900 && !result2001) {
                System.out.println("✅ 통과: 1900년, 2001년은 평년");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 평년 판정 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 7: 윤년의 2월 28일
    // given: 윤년 2월 28일이 주어졌을 때
    // when: isValidDate를 호출하면
    // then: 유효해야 함
    private static void testFebruaryInLeapYear() {
        System.out.println("테스트 7: 윤년의 2월 28일");
        totalTests++;
        
        try {
            // given: 윤년 2월 28일
            boolean result = DateValidator.isValidDate(2000, 2, 28);
            
            // then: 유효
            if (result) {
                System.out.println("✅ 통과: 윤년 2월 28일 유효");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 유효한 날짜를 무효로 판정");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 8: 평년의 2월 28일
    // given: 평년 2월 28일이 주어졌을 때
    // when: isValidDate를 호출하면
    // then: 유효해야 함
    private static void testFebruaryInNonLeapYear() {
        System.out.println("테스트 8: 평년의 2월 28일");
        totalTests++;
        
        try {
            // given: 평년 2월 28일
            boolean result = DateValidator.isValidDate(2001, 2, 28);
            
            // then: 유효
            if (result) {
                System.out.println("✅ 통과: 평년 2월 28일 유효");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 유효한 날짜를 무효로 판정");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 9: 나이 계산
    // given: 1976년 2월 7일 생일이 주어졌을 때
    // when: calculateAge를 호출하면 (기준: 2026년 2월 6일)
    // then: 49세가 반환되어야 함 (생일 하루 전)
    private static void testAgeCalculation() {
        System.out.println("테스트 9: 나이 계산");
        totalTests++;
        
        try {
            // given: 1976년 2월 7일 생
            int age = DateValidator.calculateAge(1976, 2, 7);
            
            // then: 49세 (2026년 2월 6일 기준, 생일 하루 전)
            if (age == 49) {
                System.out.println("✅ 통과: 나이 계산 정확 (49세)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 나이 계산 오류 (예상: 49, 실제: " + age + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 10: 날짜 문자열 파싱
    // given: "1976-02-07" 형식의 날짜 문자열이 주어졌을 때
    // when: isValidDateString을 호출하면
    // then: true를 반환해야 함
    private static void testDateStringParsing() {
        System.out.println("테스트 10: 날짜 문자열 파싱");
        totalTests++;
        
        try {
            // given: 유효한 날짜 문자열
            boolean result1 = DateValidator.isValidDateString("1976-02-07");
            boolean result2 = DateValidator.isValidDateString("2000-02-29");
            boolean result3 = DateValidator.isValidDateString("invalid");
            
            // then: 첫 두 개는 true, 마지막은 false
            if (result1 && result2 && !result3) {
                System.out.println("✅ 통과: 날짜 문자열 파싱 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 날짜 문자열 파싱 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
