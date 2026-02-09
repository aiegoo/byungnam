// StudentTestSuite: Student 클래스 기능을 검증하는 간단한 수동 테스트 러너
public class StudentTestSuite {
    private static int totalTests = 0;
    private static int passedTests = 0;

    public static void main(String[] args) {
        runTest("serial number increments per student", StudentTestSuite::testSerialIncrement);
        runTest("student card number equals studentID + 100", StudentTestSuite::testStudentCardOffset);
        runTest("serial number setter rewinds sequence", StudentTestSuite::testSerialReset);

        System.out.println("==============================");
        System.out.println("테스트 결과: " + passedTests + "/" + totalTests + " passed");
    }

    private static void runTest(String name, Runnable test) {
        totalTests++;
        try {
            Student.setSerialNum(1000); // 각 테스트는 동일한 초기 상태에서 시작
            test.run();
            passedTests++;
            System.out.println("[PASS] " + name);
        } catch (AssertionError error) {
            System.out.println("[FAIL] " + name + " -> " + error.getMessage());
        }
    }

    private static void testSerialIncrement() {
        Student first = new Student();
        Student second = new Student();

        expect(first.getStudentID() == 1001, "첫 번째 학생 학번이 1001이어야 함");
        expect(second.getStudentID() == 1002, "두 번째 학생 학번이 1002이어야 함");
        expect(Student.getSerialNum() == 1002, "시리얼 번호가 1002로 업데이트되어야 함");
    }

    private static void testStudentCardOffset() {
        Student student = new Student();
        expect(student.getStudentCardNumber() - student.getStudentID() == 100,
               "학생카드 번호는 학번보다 100 커야 함");
    }

    private static void testSerialReset() {
        Student.setSerialNum(2000);
        Student student = new Student();
        expect(student.getStudentID() == 2001, "시리얼 초기화 이후 학번이 2001이어야 함");
    }

    private static void expect(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
