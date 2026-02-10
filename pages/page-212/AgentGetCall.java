// AgentGetCall 스케줄러 - 상담원이 직접 전화를 가져가는 정책
// 기존 방식과 달리 상담원이 능동적으로 전화를 요청하고 가져감
// 상담원의 자율성을 높이고 업무 흐름을 유연하게 관리
public class AgentGetCall implements Scheduler {
    
    @Override
    public void getNextCall() {
        // 상담원이 능동적으로 다음 전화를 요청
        // 기존의 시스템 배분 방식과 달리 상담원 주도로 전환
        System.out.println("상담원이 다음 전화 요청");
    }
    
    @Override
    public void sendCallToAgent() {
        // 상담원이 직접 전화를 가져감
        // 배분이 아닌 상담원의 능동적 획득 방식
        System.out.println("상담원이 전화 상담을 가져갔습니다");
    }
}
