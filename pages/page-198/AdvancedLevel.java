// ============================================================
// AdvancedLevel: run + jump 가능, turn 불가인 중급자 레벨
// ============================================================
public class AdvancedLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("Advanced: 빠르게 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("Advanced: 높게 jump 합니다.");
    }

    @Override
    public void turn() {
        // 중급자도 턴은 아직 불가
        printUnavailable("Advanced: turn");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("*** Advanced Level입니다. run과 jump가 가능합니다. ***");
    }
}
