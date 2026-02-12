import collection.Member;
import collection.arraylist.MemberArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MemberArrayListTestSuite {
    private static int passCount = 0;
    private static int failCount = 0;

    public static void main(String[] args) {
        System.out.println("===== MemberArrayList Test Suite =====\n");

        testAddAndSize();
        testRemoveExistingMember();
        testRemoveNonExistingMember();
        testShowAllMemberOutput();
        testInsertMemberAtIndex();

        System.out.println("===== Test Results =====");
        System.out.println("Pass: " + passCount);
        System.out.println("Fail: " + failCount);
        System.out.println("Total: " + (passCount + failCount));
    }

    // given: 두 명의 회원 뒤에 새로운 회원을 끼워 넣을 때
    // when: insertMember로 특정 위치에 추가하면
    // then: 출력 순서가 기대한 대로 유지된다
    private static void testInsertMemberAtIndex() {
        System.out.println("Test 5: insertMember inserts at given index");

        MemberArrayList memberArrayList = new MemberArrayList();
        Member first = new Member(1, "첫번째");
        Member second = new Member(2, "두번째");
        Member inserted = new Member(3, "중간");

        memberArrayList.addMember(first);
        memberArrayList.addMember(second);
        memberArrayList.insertMember(inserted, 1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        memberArrayList.showAllMember();

        System.setOut(originalOut);
        String output = outputStream.toString();

        String firstMsg = "첫번째 회원님의 아이디는 1입니다";
        String middleMsg = "중간 회원님의 아이디는 3입니다";
        String secondMsg = "두번째 회원님의 아이디는 2입니다";

        int firstIndex = output.indexOf(firstMsg);
        int middleIndex = output.indexOf(middleMsg);
        int secondIndex = output.indexOf(secondMsg);

        boolean inOrder = firstIndex != -1 && middleIndex != -1 && secondIndex != -1
                && firstIndex < middleIndex && middleIndex < secondIndex;

        report(inOrder);
    }

    // given: 빈 리스트가 있을 때
    // when: 회원을 3명 추가하면
    // then: size는 3이 된다
    private static void testAddAndSize() {
        System.out.println("Test 1: addMember increases size");

        MemberArrayList memberArrayList = new MemberArrayList();
        memberArrayList.addMember(new Member(1, "A"));
        memberArrayList.addMember(new Member(2, "B"));
        memberArrayList.addMember(new Member(3, "C"));

        boolean condition = memberArrayList.size() == 3;
        report(condition);
    }

    // given: 2명의 회원이 있을 때
    // when: 존재하는 회원을 삭제하면
    // then: true를 반환하고 size가 줄어든다
    private static void testRemoveExistingMember() {
        System.out.println("Test 2: removeMember removes existing");

        MemberArrayList memberArrayList = new MemberArrayList();
        memberArrayList.addMember(new Member(1, "A"));
        memberArrayList.addMember(new Member(2, "B"));

        boolean removed = memberArrayList.removeMember(1);
        boolean sizeMatches = memberArrayList.size() == 1;

        report(removed && sizeMatches);
    }

    // given: 리스트에 없는 아이디를 삭제할 때
    // when: removeMember 호출하면
    // then: false를 반환하고 안내 문구를 출력한다
    private static void testRemoveNonExistingMember() {
        System.out.println("Test 3: removeMember handles missing member");

        MemberArrayList memberArrayList = new MemberArrayList();
        memberArrayList.addMember(new Member(1, "A"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        boolean removed = memberArrayList.removeMember(99);

        System.setOut(originalOut);
        String output = outputStream.toString();
        boolean hasMessage = output.contains("99가 존재하지 않습니다");

        report(!removed && hasMessage);
    }

    // given: 리스트에 2명의 회원이 있을 때
    // when: showAllMember를 호출하면
    // then: 두 회원 정보가 출력된다
    private static void testShowAllMemberOutput() {
        System.out.println("Test 4: showAllMember prints all members");

        MemberArrayList memberArrayList = new MemberArrayList();
        memberArrayList.addMember(new Member(1, "A"));
        memberArrayList.addMember(new Member(2, "B"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        memberArrayList.showAllMember();

        System.setOut(originalOut);
        String output = outputStream.toString();
        boolean printsA = output.contains("A 회원님의 아이디는 1입니다");
        boolean printsB = output.contains("B 회원님의 아이디는 2입니다");

        report(printsA && printsB);
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
