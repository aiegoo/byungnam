// ============================================================
// Book 클래스: 책 정보를 저장하는 객체
// ============================================================
// 목적: ObjectCopy 예제에서 얼치복사(Shallow Copy)와
//       깊은복사(Deep Copy)의 차이를 보여주기 위한 클래스
// ============================================================

public class Book {
    // private 필드: 외부에서 직접 접근 불가, getter/setter로만 접근
    // bookName: 책 제목을 저장하는 변수
    private String bookName;
    // author: 저자명을 저장하는 변수
    private String author;
    
    // 기본 생성자 (Default Constructor)
    // 매개변수가 없는 생성자, 필드는 null로 초기화됨
    // ObjectCopy2에서 빈 객체 생성 후 setter로 값 설정 시 사용
    public Book() {
    }
    
    // 매개변수가 있는 생성자 (Parameterized Constructor)
    // 책 제목과 저자를 받아서 객체 생성 시 초기화
    // this.bookName: 현재 객체의 bookName 필드
    // bookName: 매개변수로 받은 값
    public Book(String bookName, String author) {
        this.bookName = bookName;  // 필드에 매개변수 값 할당
        this.author = author;      // 필드에 매개변수 값 할당
    }
    
    // Getter 메서드: bookName 필드의 값을 반환
    // private 필드를 외부에서 읽기 위해 사용
    public String getBookName() {
        return bookName;  // bookName 필드의 값 반환
    }
    
    // Setter 메서드: bookName 필드의 값을 변경
    // private 필드를 외부에서 수정하기 위해 사용
    public void setBookName(String bookName) {
        this.bookName = bookName;  // 매개변수 값을 필드에 할당
    }
    
    // Getter 메서드: author 필드의 값을 반환
    public String getAuthor() {
        return author;  // author 필드의 값 반환
    }
    
    // Setter 메서드: author 필드의 값을 변경
    public void setAuthor(String author) {
        this.author = author;  // 매개변수 값을 필드에 할당
    }
    
    // 책 정보 출력 메서드
    // "책제목, 저자" 형식으로 출력
    public void showBookInfo() {
        System.out.println(bookName + ", " + author);
    }
}
