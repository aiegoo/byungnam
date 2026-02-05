// ============================================================
// ObjectCopy2Test: 깊은복사(Deep Copy) 테스트
// ============================================================
// 테스트 목표:
// 1. 새 객체 생성을 통한 깊은복사 동작 검증
// 2. 원본 변경 시 복사본이 독립적인지 확인
// 3. 얼치복사와의 차이점 명확히 확인
// ============================================================

public class ObjectCopy2Test {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== ObjectCopy2 (Deep Copy) 테스트 시작 ===\n");
        
        // 테스트 실행
        testDeepCopySeparateReferences();
        testOriginalModificationDoesNotAffectCopy();
        testCopyModificationDoesNotAffectOriginal();
        testValuesCopiedCorrectly();
        
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
    
    // 테스트 1: 깊은복사 시 별도 참조값 확인
    // given: 원본 배열과 복사본 배열이 주어졌을 때
    // when: 수동으로 새 객체를 생성하여 복사하면
    // then: 두 배열의 요소가 서로 다른 객체를 가리켜야 함
    private static void testDeepCopySeparateReferences() {
        System.out.println("테스트 1: 깊은복사 - 별도 참조값");
        totalTests++;
        
        try {
            // given: 원본 배열
            Book[] bookArray1 = new Book[2];
            bookArray1[0] = new Book("신곡", "단테");
            bookArray1[1] = new Book("데미안", "헤르만 헤세");
            
            // when: 수동으로 새 객체 생성 및 값 복사
            Book[] bookArray2 = new Book[2];
            bookArray2[0] = new Book();
            bookArray2[1] = new Book();
            for (int i = 0; i < bookArray1.length; i++) {
                bookArray2[i].setBookName(bookArray1[i].getBookName());
                bookArray2[i].setAuthor(bookArray1[i].getAuthor());
            }
            
            // then: bookArray1[0]과 bookArray2[0]이 서로 다른 객체
            // == 연산자로 참조값 비교 시 false여야 함
            boolean differentReferences = (bookArray1[0] != bookArray2[0]) 
                && (bookArray1[1] != bookArray2[1]);
            
            if (differentReferences) {
                System.out.println("✅ 통과: 깊은복사로 인해 별도의 객체 생성됨");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 같은 객체를 가리킴");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: 원본 수정 시 복사본은 독립적임 확인
    // given: 깊은복사된 배열이 주어졌을 때
    // when: 원본 배열의 요소를 수정하면
    // then: 복사본 배열의 요소는 변경되지 않아야 함
    private static void testOriginalModificationDoesNotAffectCopy() {
        System.out.println("테스트 2: 원본 수정 시 복사본 독립적");
        totalTests++;
        
        try {
            // given: 깊은복사된 배열
            Book[] bookArray1 = new Book[2];
            bookArray1[0] = new Book("신곡", "단테");
            bookArray1[1] = new Book("데미안", "헤르만 헤세");
            
            Book[] bookArray2 = new Book[2];
            bookArray2[0] = new Book();
            bookArray2[1] = new Book();
            for (int i = 0; i < bookArray1.length; i++) {
                bookArray2[i].setBookName(bookArray1[i].getBookName());
                bookArray2[i].setAuthor(bookArray1[i].getAuthor());
            }
            
            // when: bookArray1[0] 수정
            bookArray1[0].setBookName("토지");
            bookArray1[0].setAuthor("박완서");
            
            // then: bookArray2[0]은 변경되지 않음 (여전히 "신곡", "단테")
            boolean copyNotAffected = bookArray2[0].getBookName().equals("신곡")
                && bookArray2[0].getAuthor().equals("단테");
            
            if (copyNotAffected) {
                System.out.println("✅ 통과: 원본 수정이 복사본에 영향 없음 (깊은복사의 특징)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 복사본이 변경됨");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 3: 복사본 수정 시 원본은 독립적임 확인
    // given: 깊은복사된 배열이 주어졌을 때
    // when: 복사본 배열의 요소를 수정하면
    // then: 원본 배열의 요소는 변경되지 않아야 함
    private static void testCopyModificationDoesNotAffectOriginal() {
        System.out.println("테스트 3: 복사본 수정 시 원본 독립적");
        totalTests++;
        
        try {
            // given: 깊은복사된 배열
            Book[] bookArray1 = new Book[1];
            bookArray1[0] = new Book("원본책", "원본저자");
            
            Book[] bookArray2 = new Book[1];
            bookArray2[0] = new Book();
            bookArray2[0].setBookName(bookArray1[0].getBookName());
            bookArray2[0].setAuthor(bookArray1[0].getAuthor());
            
            // when: bookArray2[0] 수정 (복사본 수정)
            bookArray2[0].setBookName("수정된책");
            bookArray2[0].setAuthor("수정된저자");
            
            // then: bookArray1[0]은 변경되지 않음 (여전히 "원본책", "원본저자")
            boolean originalNotAffected = bookArray1[0].getBookName().equals("원본책")
                && bookArray1[0].getAuthor().equals("원본저자");
            
            if (originalNotAffected) {
                System.out.println("✅ 통과: 복사본 수정이 원본에 영향 없음 (양방향 독립)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 원본이 변경됨");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: 값이 정확히 복사되었는지 확인
    // given: 원본 배열이 주어졌을 때
    // when: 깊은복사를 수행하면
    // then: 복사본의 값들이 원본과 동일해야 함 (참조는 다르지만 값은 동일)
    private static void testValuesCopiedCorrectly() {
        System.out.println("테스트 4: 값 정확히 복사됨 확인");
        totalTests++;
        
        try {
            // given: 원본 배열
            Book[] bookArray1 = new Book[2];
            bookArray1[0] = new Book("자바의 정석", "남궁성");
            bookArray1[1] = new Book("클린 코드", "로버트 마틴");
            
            // when: 깊은복사
            Book[] bookArray2 = new Book[2];
            for (int i = 0; i < bookArray1.length; i++) {
                bookArray2[i] = new Book();
                bookArray2[i].setBookName(bookArray1[i].getBookName());
                bookArray2[i].setAuthor(bookArray1[i].getAuthor());
            }
            
            // then: 값은 동일하지만 참조는 다름
            boolean valuesEqual = bookArray2[0].getBookName().equals("자바의 정석")
                && bookArray2[0].getAuthor().equals("남궁성")
                && bookArray2[1].getBookName().equals("클린 코드")
                && bookArray2[1].getAuthor().equals("로버트 마틴");
            boolean referencesDifferent = (bookArray1[0] != bookArray2[0])
                && (bookArray1[1] != bookArray2[1]);
            
            if (valuesEqual && referencesDifferent) {
                System.out.println("✅ 통과: 값은 동일하고 참조는 다름 (깊은복사의 정의)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 값 복사 오류 또는 참조 공유");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
