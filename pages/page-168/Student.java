// ============================================================
// Student: 학번과 학생카드 번호를 자동으로 부여하는 클래스
// ============================================================
// 역할:
// 1) 모든 Student 인스턴스가 공유하는 시리얼 번호(serialNum)를 기반으로 학번을 생성
// 2) 학번에 100을 더한 값을 학생카드 번호로 관리
// 3) 외부에서는 getter/setter를 통해 정보에 접근
// ============================================================
public class Student {
    // 모든 학생이 공유하는 시리얼 번호. 생성될 때마다 1씩 증가한다.
    private static int serialNum = 1000;

    private int studentID;        // 자동으로 부여되는 학번
    private String studentName;   // 학생 이름
    private int grade;            // 학년
    private String address;       // 주소
    private int studentCardNumber;// 학번 + 100 으로 계산되는 학생카드 번호

    // 기본 생성자: 학생이 생성될 때 학번과 학생카드 번호를 자동 부여한다.
    public Student() {
        serialNum++;              // 1. 공용 시리얼 번호 증가
        studentID = serialNum;    // 2. 증가된 값을 학번으로 저장
        studentCardNumber = studentID + 100; // 3. 학번에 100을 더해 학생카드 번호 생성
    }

    public static int getSerialNum() {
        return serialNum;
    }

    // 외부에서 초기화하거나 테스트를 위해 시리얼 번호를 조정할 때 사용
    public static void setSerialNum(int newSerialNum) {
        serialNum = newSerialNum;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudentCardNumber() {
        return studentCardNumber;
    }
}
