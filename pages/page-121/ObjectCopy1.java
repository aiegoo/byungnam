// ============================================================
// Page 121: 얼치복사(Shallow Copy) - System.arraycopy 사용
// ============================================================
// 학습 목표:
// 1. System.arraycopy로 배열의 참조값만 복사하는 얼치복사 이해
// 2. 얼치복사의 문제점: 원본 객체 변경 시 복사본도 함께 변경됨
// 3. 객체 배열의 참조와 힙 메모리 개념
// ============================================================

public class ObjectCopy1 {
    public static void main(String[] args) {
        // Book 객체 배열 2개 선언 (원본과 복사본)
        // 배열 선언만 했으므로 각 요소는 null로 초기화됨
        Book[] bookArray1 = new Book[2];  // 원본 배열
        Book[] bookArray2 = new Book[2];  // 복사본 배열
        
        // bookArray1에 Book 객체 생성 및 할당
        // new Book(): 힙 메모리에 새로운 Book 객체 생성
        // bookArray1[0]: 배열의 0번 인덱스에 객체의 참조값(주소) 저장
        bookArray1[0] = new Book("신곡", "단테");
        bookArray1[1] = new Book("데미안", "헤르만 헤세");
        
        // System.arraycopy: 배열의 내용을 복사하는 시스템 메서드
        // 파라미터: (원본배열, 시작인덱스, 복사본배열, 복사시작인덱스, 복사개수)
        // bookArray1의 0번부터 2개를 bookArray2의 0번부터 복사
        // ⚠️ 주의: 객체의 참조값(주소)만 복사됨 (얼치복사)
        // 즉, bookArray1[0]과 bookArray2[0]은 같은 Book 객체를 가리킴
        System.arraycopy(bookArray1, 0, bookArray2, 0, 2);
        
        // 복사 후 bookArray2의 내용 출력
        // 결과: "신곡, 단테" 및 "데미안, 헤르만 헤세" 출력
        for (int i = 0; i < bookArray2.length; i++) {
            bookArray2[i].showBookInfo();
        }
        
        // ⚠️ 중요: bookArray1[0]의 내용을 변경
        // bookArray1[0]과 bookArray2[0]이 같은 객체를 가리키므로
        // bookArray1[0]을 변경하면 bookArray2[0]도 함께 변경됨
        bookArray1[0].setBookName("토지");     // 책 제목 변경
        bookArray1[0].setAuthor("박완서");    // 저자 변경
        
        // bookArray1 출력: 변경된 내용 확인
        // 결과: "토지, 박완서" 및 "데미안, 헤르만 헤세" 출력
        for (int i = 0; i < bookArray1.length; i++) {
            bookArray1[i].showBookInfo();
        }
        
        // ⚠️ 얼치복사의 문제점 확인: bookArray2도 함께 변경되었음
        // bookArray2[0]을 수정하지 않았는데도 "토지, 박완서"가 출력됨
        // 이유: bookArray1[0]과 bookArray2[0]이 같은 객체를 참조하기 때문
        // 결과: "토지, 박완서" 및 "데미안, 헤르만 헤세" 출력 (원치 않는 변경!)
        for (int i = 0; i < bookArray2.length; i++) {
            bookArray2[i].showBookInfo();
        }
        
        // 결론: 얼치복사는 참조값만 복사하므로 원본 변경 시 복사본도 영향을 받음
        // 이를 해결하려면 깊은복사(Deep Copy)를 사용해야 함 (ObjectCopy2 참고)
    }
}
