// ============================================================
// SuperLevel: run, jump, turn 모두 가능한 고급자 레벨
// ============================================================
public class SuperLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("Super: 매우 빠르게 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("Super: 더 높이 jump 합니다.");
    }

    @Override
    public void turn() {
        System.out.println("Super: 화려하게 turn 합니다.");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("*** Super Level입니다. 모든 스킬 사용 가능! ***");
    }
}
