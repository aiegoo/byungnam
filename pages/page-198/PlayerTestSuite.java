import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// PlayerTestSuite: Player와 레벨 클래스의 동작을 검증하는 수동 테스트 러너
public class PlayerTestSuite {
    private static int total = 0;
    private static int passed = 0;

    public static void main(String[] args) {
        run("Beginner level blocks jump/turn", PlayerTestSuite::testBeginnerRestrictions);
        run("Advanced level allows jump only", PlayerTestSuite::testAdvancedAllowsJump);
        run("Super level runs all actions", PlayerTestSuite::testSuperLevelFullActions);
        run("Upgrade level replaces strategy", PlayerTestSuite::testUpgradeLevelChangesState);

        System.out.println("==============================");
        System.out.println("테스트 결과: " + passed + "/" + total + " passed");
    }

    private static void run(String name, Runnable test) {
        total++;
        try {
            test.run();
            passed++;
            System.out.println("[PASS] " + name);
        } catch (AssertionError error) {
            System.out.println("[FAIL] " + name + " -> " + error.getMessage());
        }
    }

    private static void testBeginnerRestrictions() {
        Player player = new Player();
        String output = capture(() -> player.play(2));
        expect(output.contains("Beginner: 천천히 달립니다."), "Beginner run 메시지가 출력되어야 함");
        expect(countOccurrences(output, "Beginner: jump 할 수 없습니다.") == 2,
                "점프 불가 메시지가 점프 횟수만큼 출력되어야 함");
        expect(output.contains("Beginner: turn 할 수 없습니다."), "턴 불가 메시지가 출력되어야 함");
    }

    private static void testAdvancedAllowsJump() {
        Player player = new Player();
        player.upgradeLevel(new AdvancedLevel());
        String output = capture(() -> player.play(2));
        expect(countOccurrences(output, "Advanced: 높게 jump 합니다.") == 2,
                "중급자는 점프를 두 번 수행해야 함");
        expect(output.contains("Advanced: turn 할 수 없습니다."), "중급자는 턴이 불가해야 함");
    }

    private static void testSuperLevelFullActions() {
        Player player = new Player();
        player.upgradeLevel(new SuperLevel());
        String output = capture(() -> player.play(2));
        expect(output.contains("Super: 매우 빠르게 달립니다."), "고급자는 run 메시지를 출력해야 함");
        expect(countOccurrences(output, "Super: 더 높이 jump 합니다.") == 2,
                "고급자는 점프를 모든 횟수만큼 수행해야 함");
        expect(output.contains("Super: 화려하게 turn 합니다."), "고급자는 턴을 수행해야 함");
    }

    private static void testUpgradeLevelChangesState() {
        Player player = new Player();
        player.upgradeLevel(new SuperLevel());
        expect(player.getLevel() instanceof SuperLevel, "업그레이드 후 레벨이 SuperLevel이어야 함");
    }

    private static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream temp = new PrintStream(buffer);
        System.setOut(temp);
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString();
    }

    private static int countOccurrences(String text, String term) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(term, index)) != -1) {
            count++;
            index += term.length();
        }
        return count;
    }

    private static void expect(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
