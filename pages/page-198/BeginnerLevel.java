// ============================================================
// BeginnerLevel: 달리기만 가능한 초보자 레벨 구현
// ============================================================
public class BeginnerLevel extends PlayerLevel {
    @Override
    public void run() {
        System.out.println("Beginner: 천천히 달립니다.");
    }

    @Override
    public void jump() {
        // 초보자는 점프 불가 → 공통 헬퍼로 안내 메시지 출력
        printUnavailable("Beginner: jump");
    }

    @Override
    public void turn() {
        // 초보자는 턴 불가 → 공통 헬퍼로 안내 메시지 출력
        printUnavailable("Beginner: turn");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("*** Beginner Level입니다. 런 기능만 가능합니다. ***");
    }
}
