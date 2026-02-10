// LeastJob 스케줄러 - 짧은 대기열 찾아 배분하는 정책
// 고객 대기 시간을 최소화하기 위해 대기 건수가 가장 적은 상담원에게 배분
// static 배열을 사용하여 모든 인스턴스가 상담원 대기 상태를 공유
public class LeastJob implements Scheduler {
    // 각 상담원의 현재 대기 건수를 저장하는 정적 배열
    // 인덱스는 상담원 번호, 값은 해당 상담원의 대기 중인 전화 건수
    // static으로 선언하여 모든 LeastJob 인스턴스가 공유
    private static int[] agentWaitingCalls = {0, 0, 0};
    
    @Override
    public void getNextCall() {
        // 대기열에서 순서대로 전화를 가져옴
        // LeastJob은 배분 시점에만 대기열을 고려
        System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다");
    }
    
    @Override
    public void sendCallToAgent() {
        // 가장 적은 대기열을 가진 상담원을 찾는 과정
        // 첫 번째 상담원을 초기 최소값으로 설정
        int minWaitingAgent = 0;
        int minWaitingCount = agentWaitingCalls[0];
        
        // 나머지 상담원들과 비교하여 최소 대기 건수를 가진 상담원 찾기
        for (int i = 1; i < agentWaitingCalls.length; i++) {
            // 현재 상담원의 대기 건수가 더 적으면 갱신
            if (agentWaitingCalls[i] < minWaitingCount) {
                minWaitingCount = agentWaitingCalls[i];
                minWaitingAgent = i;
            }
        }
        
        // 대기 건수가 가장 적은 상담원에게 전화를 배분
        System.out.println("상담원 " + minWaitingAgent + "번에게 배분합니다 (현재 대기: " + agentWaitingCalls[minWaitingAgent] + "건)");
        
        // 해당 상담원의 대기 건수를 1 증가
        // 실제로는 상담이 끝나면 감소시켜야 하지만 여기서는 배분만 시뮬레이션
        agentWaitingCalls[minWaitingAgent]++;
    }
}
