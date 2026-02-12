import collection.Member;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MemberTestSuite {
    private static int passCount = 0;
    private static int failCount = 0;

    public static void main(String[] args) {
        System.out.println("===== Member Test Suite =====\n");

        testToStringMessage();
        testGetterValues();
        testSetterUpdates();

        System.out.println("===== Test Results =====");
        System.out.println("Pass: " + passCount);
        System.out.println("Fail: " + failCount);
        System.out.println("Total: " + (passCount + failCount));
    }

    // given: 멤버 객체가 있을 때
    // when: toString을 호출하면
    // then: 지정된 메시지 형식이 출력된다
    private static void testToStringMessage() {
        System.out.println("Test 1: toString message format");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        Member member = new Member(100, "홍길동");

        member.toString();
        System.out.println(member);

        System.setOut(originalOut);
        String output = outputStream.toString();
        boolean hasMessage = output.contains("홍길동 회원님의 아이디는 100입니다");

        report(hasMessage);
    }

    // given: 생성된 Member가 있을 때
    // when: getter를 호출하면
    // then: 생성자 값이 그대로 반환된다
    private static void testGetterValues() {
        System.out.println("Test 2: getter returns constructor values");

        Member member = new Member(200, "이순신");
        boolean idMatches = member.getMemberId() == 200;
        boolean nameMatches = "이순신".equals(member.getMemberName());

        report(idMatches && nameMatches);
    }

    // given: Member 객체가 있을 때
    // when: setter로 값을 변경하면
    // then: 새로운 값이 반영된다
    private static void testSetterUpdates() {
        System.out.println("Test 3: setter updates fields");

        Member member = new Member(300, "강감찬");
        member.setMemberId(301);
        member.setMemberName("김유신");

        boolean idMatches = member.getMemberId() == 301;
        boolean nameMatches = "김유신".equals(member.getMemberName());

        report(idMatches && nameMatches);
    }

    private static void report(boolean condition) {
        if (condition) {
            System.out.println("✅ PASS\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL\n");
            failCount++;
        }
    }
}
