// PriorityAllocation 스케줄러 - 우선순위에 따라 배분하는 정책
// 고객 등급이 높을수록 우선 처리하고, 능력이 좋은 상담원에게 배분
// 상속과 static을 활용하여 고객 등급 정보를 관리
public class PriorityAllocation implements Scheduler {
    // 현재 처리할 고객의 등급을 저장하는 정적 변수
    // 1: 일반, 2: 우수, 3: VIP
    // static으로 선언하여 모든 인스턴스가 공유
    private static int customerGrade = 1;
    
    @Override
    public void getNextCall() {
        // 등급이 높은 고객의 전화를 우선적으로 가져옴
        // 실제로는 우선순위 큐를 사용하여 VIP 고객을 먼저 처리
        System.out.println("등급이 높은 고객 (등급 " + customerGrade + ") 전화를 먼저 가져옵니다");
    }
    
    @Override
    public void sendCallToAgent() {
        // 고객 등급에 따라 상담원 배분
        // 등급이 높은 고객일수록 능력이 우수한 상담원에게 배분
        
        if (customerGrade >= 3) {
            // VIP 고객 (등급 3 이상)은 가장 능력이 우수한 상담원 0번에게 배분
            // 중요한 고객이므로 최고 능력의 상담원이 처리
            System.out.println("VIP 고객을 능력이 우수한 상담원 0번에게 배분합니다");
        } else if (customerGrade == 2) {
            // 우수 고객 (등급 2)은 중간 능력의 상담원 1번에게 배분
            System.out.println("우수 고객을 상담원 1번에게 배분합니다");
        } else {
            // 일반 고객 (등급 1)은 상담원 2번에게 배분
            System.out.println("일반 고객을 상담원 2번에게 배분합니다");
        }
        
        // 다음 고객 등급으로 변경 (테스트용 시뮬레이션)
        // % 연산자로 1 -> 2 -> 3 -> 1 순환
        customerGrade = (customerGrade % 3) + 1;
    }
}
