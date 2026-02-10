// RoundRobin 스케줄러 - 순서대로 배분하는 정책
// 모든 상담원이 동일한 상담 건수를 처리하도록 하는 것이 목표
// static 변수를 사용하여 모든 인스턴스가 배분 순서를 공유
public class RoundRobin implements Scheduler {
    // 상담원 수를 저장하는 정적 상수
    // final로 선언하여 변경 불가능하게 설정
    private static final int AGENT_COUNT = 3;
    
    // 현재 배분할 상담원 인덱스를 저장하는 정적 변수
    // 모든 RoundRobin 인스턴스가 이 값을 공유하여 순서 유지
    private static int currentAgentIndex = 0;
    
    @Override
    public void getNextCall() {
        // 대기열에서 순서대로 전화를 가져옴
        // RoundRobin에서는 특별한 우선순위 없이 순서대로 처리
        System.out.println("상담 전화를 순서대로 대기열에서 가져옵니다");
    }
    
    @Override
    public void sendCallToAgent() {
        // 현재 인덱스에 해당하는 상담원에게 전화를 배분
        // 간단하게 다음 순서 상담원에게 배분한다고 출력
        System.out.println("다음 순서 상담원에게 배분합니다.");
        
        // 다음 상담원으로 인덱스를 이동 (순환 구조)
        // % 연산자를 사용하여 마지막 상담원 다음에는 첫 번째 상담원으로 돌아감
        // 예: 0 -> 1 -> 2 -> 0 -> 1 -> 2 ...
        currentAgentIndex = (currentAgentIndex + 1) % AGENT_COUNT;
    }
}
