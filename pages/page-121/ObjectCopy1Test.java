// ============================================================
// ObjectCopy1Test: 얼치복사(Shallow Copy) 테스트
// ============================================================
// 테스트 목표:
// 1. System.arraycopy의 얼치복사 동작 검증
// 2. 원본 변경 시 복사본도 변경되는지 확인
// 3. 참조값 공유로 인한 문제점 확인
// ============================================================

public class ObjectCopy1Test {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== ObjectCopy1 (Shallow Copy) 테스트 시작 ===\n");
        
        // 테스트 실행
        testShallowCopyReferencesShared();
        testOriginalModificationAffectsCopy();
        testArrayCopyLength();
        testBothArraysPointToSameObjects();
        
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
    
    // 테스트 1: 얼치복사 시 참조값 공유 확인
    // given: 원본 배열과 복사본 배열이 주어졌을 때
    // when: System.arraycopy로 복사하면
    // then: 두 배열의 요소가 같은 객체를 가리켜야 함
    private static void testShallowCopyReferencesShared() {
        System.out.println("테스트 1: 얼치복사 - 참조값 공유");
        totalTests++;
        
        try {
            // given: 원본 배열
            Book[] bookArray1 = new Book[2];
            bookArray1[0] = new Book("신곡", "단테");
            bookArray1[1] = new Book("데미안", "헤르만 헤세");
            
            // when: System.arraycopy로 복사
            Book[] bookArray2 = new Book[2];
            System.arraycopy(bookArray1, 0, bookArray2, 0, 2);
            
            // then: bookArray1[0]과 bookArray2[0]이 같은 객체를 가리킴
            // Java에서 == 연산자는 참조값(주소)을 비교함
            boolean sameReference = (bookArray1[0] == bookArray2[0]) 
                && (bookArray1[1] == bookArray2[1]);
            
            if (sameReference) {
                System.out.println("✅ 통과: 얼치복사로 인해 참조값이 공유됨");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 참조값이 공유되지 않음");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: 원본 수정 시 복사본도 변경됨 확인
    // given: 얼치복사된 배열이 주어졌을 때
    // when: 원본 배열의 요소를 수정하면
    // then: 복사본 배열의 요소도 변경되어야 함
    private static void testOriginalModificationAffectsCopy() {
        System.out.println("테스트 2: 원본 수정 시 복사본도 변경");
        totalTests++;
        
        try {
            // given: 얼치복사된 배열
            Book[] bookArray1 = new Book[2];
            bookArray1[0] = new Book("신곡", "단테");
            bookArray1[1] = new Book("데미안", "헤르만 헤세");
            
            Book[] bookArray2 = new Book[2];
            System.arraycopy(bookArray1, 0, bookArray2, 0, 2);
            
            // when: bookArray1[0] 수정
            bookArray1[0].setBookName("토지");
            bookArray1[0].setAuthor("박완서");
            
            // then: bookArray2[0]도 변경됨
            boolean copyAffected = bookArray2[0].getBookName().equals("토지")
                && bookArray2[0].getAuthor().equals("박완서");
            
            if (copyAffected) {
                System.out.println("✅ 통과: 원본 수정이 복사본에 영향을 줌 (얼치복사의 특징)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 복사본이 변경되지 않음");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 3: System.arraycopy의 길이 파라미터 검증
    // given: 원본 배열이 주어졌을 때
    // when: 특정 개수만큼만 복사하면
    // then: 지정한 개수만큼만 복사되어야 함
    private static void testArrayCopyLength() {
        System.out.println("테스트 3: System.arraycopy 길이 파라미터");
        totalTests++;
        
        try {
            // given: 3개 요소의 배열
            Book[] bookArray1 = new Book[3];
            bookArray1[0] = new Book("책1", "저자1");
            bookArray1[1] = new Book("책2", "저자2");
            bookArray1[2] = new Book("책3", "저자3");
            
            // when: 2개만 복사 (0번부터 2개)
            Book[] bookArray2 = new Book[3];
            System.arraycopy(bookArray1, 0, bookArray2, 0, 2);
            
            // then: 0번, 1번만 복사되고 2번은 null
            boolean correctCopy = bookArray2[0] != null
                && bookArray2[1] != null
                && bookArray2[2] == null;
            
            if (correctCopy) {
                System.out.println("✅ 통과: 지정한 개수만큼만 복사됨 (2개)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 복사 길이 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: 복사본 수정 시 원본도 영향받음 확인
    // given: 얼치복사된 배열이 주어졌을 때
    // when: 복사본 배열의 요소를 수정하면
    // then: 원본 배열의 요소도 변경되어야 함 (양방향 영향)
    private static void testBothArraysPointToSameObjects() {
        System.out.println("테스트 4: 복사본 수정 시 원본도 변경");
        totalTests++;
        
        try {
            // given: 얼치복사된 배열
            Book[] bookArray1 = new Book[1];
            bookArray1[0] = new Book("원본책", "원본저자");
            
            Book[] bookArray2 = new Book[1];
            System.arraycopy(bookArray1, 0, bookArray2, 0, 1);
            
            // when: bookArray2[0] 수정 (복사본 수정)
            bookArray2[0].setBookName("수정된책");
            bookArray2[0].setAuthor("수정된저자");
            
            // then: bookArray1[0]도 변경됨 (원본도 영향받음)
            boolean originalAffected = bookArray1[0].getBookName().equals("수정된책")
                && bookArray1[0].getAuthor().equals("수정된저자");
            
            if (originalAffected) {
                System.out.println("✅ 통과: 복사본 수정이 원본에도 영향을 줌 (양방향 영향)");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 원본이 변경되지 않음");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
