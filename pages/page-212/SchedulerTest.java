import java.io.IOException;

public class SchedulerTest {
    public static void main(String[] args) throws IOException {
        // 사용자에게 상담 할당 방식 선택 안내
        System.out.println("전화 상담 할당 방식을 선택 하세요.");
        System.out.println("R : 한명씩 차례로 할당 ");
        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당 ");
        System.out.println("P : 우선순위가 높은 고객 먼저 할당 ");
        System.out.println("A : 상담원이 전화를 가져감 ");
        
        // 사용자 입력 받기 (한 글자)
        int ch = System.in.read();
        
        // 선택된 정책에 따라 스케줄러 인스턴스 생성
        Scheduler scheduler = null;
        
        if(ch == 'R' || ch == 'r') {
            // RoundRobin: 순서대로 배분
            scheduler = new RoundRobin();
        } else if(ch == 'L' || ch == 'l') {
            // LeastJob: 대기가 가장 적은 상담원에게 배분
            scheduler = new LeastJob();
        } else if(ch == 'P'|| ch == 'p') {
            // PriorityAllocation: 우선순위에 따라 배분
            scheduler = new PriorityAllocation();
        } else if(ch == 'A' || ch == 'a') {
            // AgentGetCall: 상담원이 직접 가져감
            scheduler = new AgentGetCall();
        } else {
            // 지원되지 않는 입력
            System.out.println("지원되지 않는 기능입니다.");
            return;
        }
        
        // 선택된 스케줄러로 전화 배분 실행
        scheduler.getNextCall();
        scheduler.sendCallToAgent();
    }
}
