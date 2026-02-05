// ============================================================
// Page 121: 깊은복사(Deep Copy) - 객체 직접 생성 및 값 복사
// ============================================================
// 학습 목표:
// 1. 깊은복사: 새로운 객체를 생성하고 값만 복사
// 2. 깊은복사의 장점: 원본과 복사본이 독립적으로 동작
// 3. 얼치복사 vs 깊은복사의 차이점 이해
// ============================================================

public class ObjectCopy2 {
    public static void main(String[] args) {
        // Book 객체 배열 2개 선언
        Book[] bookArray1 = new Book[2];  // 원본 배열
        Book[] bookArray2 = new Book[2];  // 복사본 배열
        
        // bookArray1에 Book 객체 생성 및 할당
        // 힙 메모리에 새로운 Book 객체 2개 생성
        bookArray1[0] = new Book("신곡", "단테");
        bookArray1[1] = new Book("데미안", "헤르만 헤세");
        
        // ✅ 중요: bookArray2에 새로운 Book 객체 직접 생성
        // ObjectCopy1과의 차이점: System.arraycopy 대신 새 객체 생성
        // new Book(): 기본 생성자로 빈 Book 객체 생성 (bookName, author는 null)
        // 힙 메모리에 bookArray1과는 별도의 새로운 객체 2개가 생성됨
        bookArray2[0] = new Book();  // 복사본 배열의 0번 인덱스에 새 객체 생성
        bookArray2[1] = new Book();  // 복사본 배열의 1번 인덱스에 새 객체 생성
        
        // for 반복문: bookArray1의 값들을 bookArray2에 복사
        // 원본 객체의 각 필드 값을 가져와서 (참조가 아닌 값만)
        // 복사본 객체의 필드에 하나씩 설정
        for (int i = 0; i < bookArray1.length; i++) {
            // getBookName(): bookArray1[i] 객체의 bookName 필드 값을 가져옴
            // setBookName(): bookArray2[i] 객체의 bookName 필드에 값 설정
            // ✅ 핸심: 참조가 아닌 값만 복사하므로 두 객체는 독립적
            bookArray2[i].setBookName(bookArray1[i].getBookName());
            // getAuthor(): bookArray1[i] 객체의 author 필드 값을 가져옴
            // setAuthor(): bookArray2[i] 객체의 author 필드에 값 설정
            bookArray2[i].setAuthor(bookArray1[i].getAuthor());
        }
        
        // 복사 후 bookArray2의 내용 출력
        // 결과: "신곡, 단테" 및 "데미안, 헤르만 헤세" 출력 (bookArray1과 동일한 값)
        for (int i = 0; i < bookArray2.length; i++) {
            bookArray2[i].showBookInfo();
        }
        
        // bookArray1[0]의 내용을 변경
        // ObjectCopy1과 달리 이번에는 bookArray2에 영향을 주지 않음
        bookArray1[0].setBookName("토지");     // 책 제목 변경
        bookArray1[0].setAuthor("박완서");    // 저자 변경
        
        // bookArray1 출력: 변경된 내용 확인
        // 결과: "토지, 박완서" 및 "데미안, 헤르만 헤세" 출력
        for (int i = 0; i < bookArray1.length; i++) {
            bookArray1[i].showBookInfo();
        }
        
        // ✅ 깊은복사의 장점 확인: bookArray2는 변경되지 않음!
        // bookArray1[0]을 변경했지만 bookArray2[0]은 여전히 "신곡, 단테" 출력
        // 이유: bookArray1[0]과 bookArray2[0]은 서로 다른 별개의 객체
        // 각각의 객체가 독립적으로 자신의 값을 가지고 있음
        // 결과: "신곡, 단테" 및 "데미안, 헤르만 헤세" 출력 (변경 전 값 유지!)
        for (int i = 0; i < bookArray2.length; i++) {
            bookArray2[i].showBookInfo();
        }
        
        // 결론: 깊은복사는 새로운 객체를 생성하고 값만 복사하므로
        //       원본과 복사본이 독립적으로 동작함
        //       원본 변경이 복사본에 영향을 주지 않음
    }
}
