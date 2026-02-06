// ============================================================
// MyDateTestSuite: MyDate 클래스 종합 테스트
// ============================================================
// 테스트 목표:
// 1. Getter/Setter 메서드 정확성 확인
// 2. 날짜 유효성 검증 로직 확인
// 3. 윤년 처리 정확성 확인
// ============================================================

public class MyDateTestSuite {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== MyDate 클래스 테스트 시작 ===\n");
        
        testConstructorAndGetters();
        testSetters();
        testValidDate();
        testInvalidMonth();
        testInvalidDay();
        testInvalidYear();
        testLeapYearFebruary29();
        testNonLeapYearFebruary29();
        testThirtyOneDayMonths();
        testThirtyDayMonths();
        
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
    
    // 테스트 1: 생성자와 Getter 메서드
    private static void testConstructorAndGetters() {
        System.out.println("테스트 1: 생성자와 Getter 메서드");
        totalTests++;
        
        try {
            MyDate date = new MyDate(7, 2, 1976);
            
            if (date.getDay() == 7 && date.getMonth() == 2 && date.getYear() == 1976) {
                System.out.println("✅ 통과: 생성자와 Getter 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 값 불일치");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: Setter 메서드
    private static void testSetters() {
        System.out.println("테스트 2: Setter 메서드");
        totalTests++;
        
        try {
            MyDate date = new MyDate(1, 1, 2000);
            date.setDay(15);
            date.setMonth(6);
            date.setYear(2020);
            
            if (date.getDay() == 15 && date.getMonth() == 6 && date.getYear() == 2020) {
                System.out.println("✅ 통과: Setter 메서드 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Setter 후 값 불일치");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 3: 유효한 날짜
    private static void testValidDate() {
        System.out.println("테스트 3: 유효한 날짜");
        totalTests++;
        
        try {
            MyDate date = new MyDate(7, 2, 1976);
            
            if (date.isValid()) {
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
    
    // 테스트 4: 무효한 월
    private static void testInvalidMonth() {
        System.out.println("테스트 4: 무효한 월");
        totalTests++;
        
        try {
            MyDate date = new MyDate(15, 13, 2000);
            
            if (!date.isValid()) {
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
    
    // 테스트 5: 무효한 일
    private static void testInvalidDay() {
        System.out.println("테스트 5: 무효한 일");
        totalTests++;
        
        try {
            MyDate date = new MyDate(32, 1, 2000);
            
            if (!date.isValid()) {
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
    
    // 테스트 6: 무효한 년도
    private static void testInvalidYear() {
        System.out.println("테스트 6: 무효한 년도");
        totalTests++;
        
        try {
            MyDate date = new MyDate(1, 1, 1800);
            
            if (!date.isValid()) {
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
    
    // 테스트 7: 윤년의 2월 29일
    private static void testLeapYearFebruary29() {
        System.out.println("테스트 7: 윤년의 2월 29일");
        totalTests++;
        
        try {
            MyDate date1 = new MyDate(29, 2, 2000); // 400으로 나누어떨어짐
            MyDate date2 = new MyDate(29, 2, 2004); // 4로 나누어떨어짐
            MyDate date3 = new MyDate(29, 2, 2024); // 4로 나누어떨어짐
            
            if (date1.isValid() && date2.isValid() && date3.isValid()) {
                System.out.println("✅ 통과: 윤년 2월 29일 유효");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 윤년 판정 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 8: 평년의 2월 29일
    private static void testNonLeapYearFebruary29() {
        System.out.println("테스트 8: 평년의 2월 29일");
        totalTests++;
        
        try {
            MyDate date1 = new MyDate(29, 2, 1900); // 100으로 나누어떨어지지만 400으로는 안됨
            MyDate date2 = new MyDate(29, 2, 2001); // 4로 나누어떨어지지 않음
            
            if (!date1.isValid() && !date2.isValid()) {
                System.out.println("✅ 통과: 평년 2월 29일 무효");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 평년 판정 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 9: 31일까지 있는 월
    private static void testThirtyOneDayMonths() {
        System.out.println("테스트 9: 31일까지 있는 월");
        totalTests++;
        
        try {
            MyDate jan31 = new MyDate(31, 1, 2000);
            MyDate mar31 = new MyDate(31, 3, 2000);
            MyDate may31 = new MyDate(31, 5, 2000);
            MyDate jul31 = new MyDate(31, 7, 2000);
            MyDate aug31 = new MyDate(31, 8, 2000);
            MyDate oct31 = new MyDate(31, 10, 2000);
            MyDate dec31 = new MyDate(31, 12, 2000);
            
            if (jan31.isValid() && mar31.isValid() && may31.isValid() && 
                jul31.isValid() && aug31.isValid() && oct31.isValid() && dec31.isValid()) {
                System.out.println("✅ 통과: 31일 월 유효");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 31일 월 판정 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 10: 30일까지 있는 월
    private static void testThirtyDayMonths() {
        System.out.println("테스트 10: 30일까지 있는 월");
        totalTests++;
        
        try {
            MyDate apr30 = new MyDate(30, 4, 2000);
            MyDate apr31 = new MyDate(31, 4, 2000);
            MyDate jun30 = new MyDate(30, 6, 2000);
            MyDate jun31 = new MyDate(31, 6, 2000);
            MyDate sep30 = new MyDate(30, 9, 2000);
            MyDate nov30 = new MyDate(30, 11, 2000);
            
            if (apr30.isValid() && !apr31.isValid() && 
                jun30.isValid() && !jun31.isValid() && 
                sep30.isValid() && nov30.isValid()) {
                System.out.println("✅ 통과: 30일 월 유효, 31일 무효");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 30일 월 판정 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
