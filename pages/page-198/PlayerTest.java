// PlayerTest: 레벨 승급과 go() 시나리오를 수동으로 확인하는 진입점
public class PlayerTest {
    public static void main(String[] args) {
        Player player = new Player(); // 기본 레벨(초보) 상태로 시작

        System.out.println("\n[Beginner 레벨 플레이]");
        player.play(1);               // 점프 1회 시도

        System.out.println("\n[Advanced 레벨로 승급]");
        player.upgradeLevel(new AdvancedLevel());
        player.play(2);               // 점프 2회 시도 (중급 가능)

        System.out.println("\n[Super 레벨로 승급]");
        player.upgradeLevel(new SuperLevel());
        player.play(3);               // 점프 3회 + 턴 수행
    }
}
