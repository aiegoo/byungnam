// StudentTest: 두 명의 학생 객체를 생성하여 학번/학생카드 번호 자동 부여를 확인
public class StudentTest {
    public static void main(String[] args) {
        // 1. 첫 번째 학생 생성 및 이름 설정
        Student studentYeon = new Student();
        studentYeon.setStudentName("연주미");

        // 생성된 직후의 시리얼 번호, 학번, 학생카드 번호 출력
        System.out.println("현재 시리얼 번호: " + Student.getSerialNum());
        System.out.println(studentYeon.getStudentName() + " 학번 : " + studentYeon.getStudentID());
        System.out.println(studentYeon.getStudentName() + " 학생카드 번호 : " + studentYeon.getStudentCardNumber());

        // 2. 두 번째 학생 생성 및 이름 설정 (시리얼 번호가 다시 증가해야 함)
        Student studentLee = new Student();
        studentLee.setStudentName("이지안");

        // 두 번째 학생의 학번/학생카드 번호가 연속적으로 증가했는지 확인
        System.out.println("현재 시리얼 번호: " + Student.getSerialNum());
        System.out.println(studentLee.getStudentName() + " 학번 : " + studentLee.getStudentID());
        System.out.println(studentLee.getStudentName() + " 학생카드 번호 : " + studentLee.getStudentCardNumber());
    }
}
