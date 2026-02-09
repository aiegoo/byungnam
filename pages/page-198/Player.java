// ============================================================
// Player: 현재 레벨 전략을 보유하고 play() 동작을 위임하는 클래스
// ============================================================
public class Player {
    private PlayerLevel level; // 플레이어가 현재 보유한 레벨 전략

    public Player() {
        level = new BeginnerLevel(); // 기본 레벨을 초보자로 설정
        level.showLevelMessage();    // 현재 레벨 안내 출력
    }

    public PlayerLevel getLevel() {
        return level;
    }

    public void upgradeLevel(PlayerLevel newLevel) {
        if (newLevel == null) {
            throw new IllegalArgumentException("업그레이드할 레벨이 null일 수 없습니다.");
        }
        level = newLevel;          // 새로운 전략으로 교체
        level.showLevelMessage();  // 교체 후 사용자에게 안내
    }

    public void play(int jumpCount) {
        level.go(jumpCount);       // 현재 레벨 템플릿 메서드 실행
    }
}
