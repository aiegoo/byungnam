// ============================================================
// PlayerLevel: 플레이어 행동 능력을 정의하는 추상 클래스
// ============================================================
// 역할
// 1) run/jump/turn/showLevelMessage 추상 메서드로 각 레벨의 행동을 캡슐화
// 2) go(count) 시나리오를 템플릿 메서드 패턴으로 제공
// 3) 불가능한 동작 요청 시 공통 메시지를 출력하는 보조 메서드 제공
// ============================================================
public abstract class PlayerLevel {
    // 각 레벨에서 구현해야 하는 핵심 행동 메서드들
    public abstract void run();   // 달리기 구현
    public abstract void jump();  // 점프 구현
    public abstract void turn();  // 턴 구현
    public abstract void showLevelMessage(); // 레벨 안내 메시지

    // 공통 시나리오: 한 번 달리고, count 만큼 점프하고, 한 번 턴하기
    public final void go(int count) {
        run();                     // 1) 기본적으로 달리기 수행
        for (int i = 0; i < count; i++) {
            jump();                // 2) 전달된 횟수만큼 점프 반복
        }
        turn();                    // 3) 마지막으로 턴 시도
    }

    // 레벨에서 지원하지 않는 기능 요청 시 호출할 수 있는 헬퍼 메서드
    protected void printUnavailable(String actionName) {
        System.out.println(actionName + " 할 수 없습니다.");
    }
}
