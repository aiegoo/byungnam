// ============================================================
// PersonTest: Person 클래스 테스트 스위트
// ============================================================
// 테스트 목표:
// 1. Person 객체 생성 및 초기화 검증
// 2. Getter 메서드 정확성 확인
// 3. 유효성 검증 (나이, 자녀 수 등)
// ============================================================

public class PersonTestSuite {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== Person 클래스 테스트 시작 ===\n");
        
        // 테스트 실행
        testPersonCreation();
        testGetAge();
        testGetName();
        testIsMarried();
        testGetNumberOfChildren();
        testPrintInfo();
        testValidAge();
        testValidChildrenCount();
        
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
    
    // 테스트 1: Person 객체 생성
    // given: Person 생성자에 값을 전달했을 때
    // when: Person 객체를 생성하면
    // then: 객체가 null이 아니어야 함
    private static void testPersonCreation() {
        System.out.println("테스트 1: Person 객체 생성");
        totalTests++;
        
        try {
            // given: 생성자 파라미터
            int age = 50;
            String name = "김사부";
            boolean isMarried = true;
            int children = 4;
            
            // when: Person 객체 생성
            Person person = new Person(age, name, isMarried, children);
            
            // then: 객체가 null이 아님
            if (person != null) {
                System.out.println("✅ 통과: Person 객체 생성 성공");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Person 객체가 null");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: getAge 메서드
    // given: 나이 50으로 Person 객체를 생성했을 때
    // when: getAge()를 호출하면
    // then: 50이 반환되어야 함
    private static void testGetAge() {
        System.out.println("테스트 2: getAge 메서드");
        totalTests++;
        
        try {
            // given: 나이 50인 Person
            Person person = new Person(50, "김사부", true, 4);
            
            // when: getAge 호출
            int age = person.getAge();
            
            // then: 50 반환
            if (age == 50) {
                System.out.println("✅ 통과: getAge() 정확 (50)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: getAge() 오류 (예상: 50, 실제: " + age + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 3: getName 메서드
    // given: 이름 "김사부"로 Person 객체를 생성했을 때
    // when: getName()을 호출하면
    // then: "김사부"가 반환되어야 함
    private static void testGetName() {
        System.out.println("테스트 3: getName 메서드");
        totalTests++;
        
        try {
            // given: 이름 "김사부"인 Person
            Person person = new Person(50, "김사부", true, 4);
            
            // when: getName 호출
            String name = person.getName();
            
            // then: "김사부" 반환
            if (name.equals("김사부")) {
                System.out.println("✅ 통과: getName() 정확 (김사부)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: getName() 오류 (예상: 김사부, 실제: " + name + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: isMarried 메서드
    // given: 결혼 여부 true로 Person 객체를 생성했을 때
    // when: isMarried()를 호출하면
    // then: true가 반환되어야 함
    private static void testIsMarried() {
        System.out.println("테스트 4: isMarried 메서드");
        totalTests++;
        
        try {
            // given: 기혼인 Person
            Person person = new Person(50, "김사부", true, 4);
            
            // when: isMarried 호출
            boolean married = person.isMarried();
            
            // then: true 반환
            if (married == true) {
                System.out.println("✅ 통과: isMarried() 정확 (true)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: isMarried() 오류 (예상: true, 실제: " + married + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 5: getNumberOfChildren 메서드
    // given: 자녀 수 4로 Person 객체를 생성했을 때
    // when: getNumberOfChildren()을 호출하면
    // then: 4가 반환되어야 함
    private static void testGetNumberOfChildren() {
        System.out.println("테스트 5: getNumberOfChildren 메서드");
        totalTests++;
        
        try {
            // given: 자녀 4명인 Person
            Person person = new Person(50, "김사부", true, 4);
            
            // when: getNumberOfChildren 호출
            int children = person.getNumberOfChildren();
            
            // then: 4 반환
            if (children == 4) {
                System.out.println("✅ 통과: getNumberOfChildren() 정확 (4)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: getNumberOfChildren() 오류 (예상: 4, 실제: " + children + ")");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 6: printInfo 메서드
    // given: Person 객체가 주어졌을 때
    // when: printInfo()를 호출하면
    // then: 예외 없이 정상 실행되어야 함
    private static void testPrintInfo() {
        System.out.println("테스트 6: printInfo 메서드");
        totalTests++;
        
        try {
            // given: Person 객체
            Person person = new Person(50, "김사부", true, 4);
            
            // when: printInfo 호출
            person.printInfo();
            
            // then: 예외 없이 실행됨
            System.out.println("✅ 통과: printInfo() 정상 실행");
            passedTests++;
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 7: 유효한 나이 범위
    // given: 다양한 나이 값으로 Person 객체를 생성했을 때
    // when: getAge()로 나이를 확인하면
    // then: 0보다 크고 150보다 작은 값이어야 함
    private static void testValidAge() {
        System.out.println("테스트 7: 유효한 나이 범위");
        totalTests++;
        
        try {
            // given: 유효한 나이의 Person들
            Person person1 = new Person(1, "신생아", false, 0);
            Person person2 = new Person(50, "중년", true, 2);
            Person person3 = new Person(100, "백세", true, 5);
            
            // when: 나이 확인
            boolean validAges = person1.getAge() > 0 && person1.getAge() < 150
                && person2.getAge() > 0 && person2.getAge() < 150
                && person3.getAge() > 0 && person3.getAge() < 150;
            
            // then: 모든 나이가 유효 범위
            if (validAges) {
                System.out.println("✅ 통과: 나이 범위 유효 (0 < age < 150)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 나이 범위 유효성 검증 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 8: 유효한 자녀 수
    // given: 다양한 자녀 수로 Person 객체를 생성했을 때
    // when: getNumberOfChildren()으로 자녀 수를 확인하면
    // then: 0 이상의 값이어야 함
    private static void testValidChildrenCount() {
        System.out.println("테스트 8: 유효한 자녀 수");
        totalTests++;
        
        try {
            // given: 다양한 자녀 수의 Person들
            Person person1 = new Person(25, "신혼", true, 0);
            Person person2 = new Person(40, "중년", true, 2);
            Person person3 = new Person(50, "다자녀", true, 10);
            
            // when: 자녀 수 확인
            boolean validCounts = person1.getNumberOfChildren() >= 0
                && person2.getNumberOfChildren() >= 0
                && person3.getNumberOfChildren() >= 0;
            
            // then: 모든 자녀 수가 0 이상
            if (validCounts) {
                System.out.println("✅ 통과: 자녀 수 유효 (>= 0)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 자녀 수 유효성 검증 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
