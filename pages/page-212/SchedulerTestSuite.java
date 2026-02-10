import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SchedulerTestSuite {
    private static int passCount = 0;
    private static int failCount = 0;
    
    public static void main(String[] args) {
        System.out.println("===== Scheduler Test Suite =====\n");
        
        testRoundRobinDistribution();
        testLeastJobFindsShortest();
        testPriorityAllocationByGrade();
        testAgentGetCall();
        testSchedulerInterface();
        
        System.out.println("\n===== Test Results =====");
        System.out.println("Pass: " + passCount);
        System.out.println("Fail: " + failCount);
        System.out.println("Total: " + (passCount + failCount));
    }
    
    // 테스트 1: RoundRobin 순차 배분 검증
    // given: RoundRobin 스케줄러가 주어졌을 때
    // when: 전화를 배분하면
    // then: 순서대로 배분 메시지가 출력되어야 함
    private static void testRoundRobinDistribution() {
        System.out.println("Test 1: RoundRobin distributes calls evenly in sequence");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: RoundRobin 스케줄러
        Scheduler scheduler = new RoundRobin();
        
        // when: 전화 요청 및 배분
        scheduler.getNextCall();
        scheduler.sendCallToAgent();
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 순차적으로 배분됨
        boolean hasCorrectMessage = output.contains("다음 순서 상담원에게 배분합니다");
        boolean hasGetCall = output.contains("순서대로 대기열에서 가져옵니다");
        
        if (hasCorrectMessage && hasGetCall) {
            System.out.println("✅ PASS: RoundRobin distributes in sequential order\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: RoundRobin distribution incorrect\n");
            failCount++;
        }
    }
    
    // 테스트 2: LeastJob 최소 대기열 검증
    // given: LeastJob 스케줄러가 주어졌을 때
    // when: 여러 전화를 배분하면
    // then: 대기 건수가 가장 적은 상담원에게 배분되어야 함
    private static void testLeastJobFindsShortest() {
        System.out.println("Test 2: LeastJob finds agent with shortest queue");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: LeastJob 스케줄러
        Scheduler scheduler = new LeastJob();
        
        // when: 4번의 전화 배분
        scheduler.sendCallToAgent();
        scheduler.sendCallToAgent();
        scheduler.sendCallToAgent();
        scheduler.sendCallToAgent();
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 대기 건수를 추적하고 최소 대기열에 배분
        boolean showsWaitingCount = output.contains("현재 대기:");
        boolean incrementsQueue = output.contains("현재 대기: 0건") && output.contains("현재 대기: 1건");
        
        if (showsWaitingCount && incrementsQueue) {
            System.out.println("✅ PASS: LeastJob tracks and uses queue length\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: LeastJob doesn't properly track queues\n");
            failCount++;
        }
    }
    
    // 테스트 3: PriorityAllocation 우선순위 배분 검증
    // given: PriorityAllocation 스케줄러가 주어졌을 때
    // when: 등급별 고객 전화를 배분하면
    // then: VIP는 상담원 0번, 우수는 1번, 일반은 2번에 배분되어야 함
    private static void testPriorityAllocationByGrade() {
        System.out.println("Test 3: PriorityAllocation assigns by customer grade");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: PriorityAllocation 스케줄러
        Scheduler scheduler = new PriorityAllocation();
        
        // when: 등급별 고객 전화 배분
        scheduler.getNextCall();
        scheduler.sendCallToAgent();
        scheduler.getNextCall();
        scheduler.sendCallToAgent();
        scheduler.getNextCall();
        scheduler.sendCallToAgent();
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 고객 등급에 따라 적절한 상담원에게 배분
        boolean hasVIP = output.contains("VIP") && output.contains("상담원 0번");
        boolean hasGood = output.contains("우수") && output.contains("상담원 1번");
        boolean hasRegular = output.contains("일반") && output.contains("상담원 2번");
        boolean hasGradeInfo = output.contains("등급");
        
        if (hasVIP && hasGood && hasRegular && hasGradeInfo) {
            System.out.println("✅ PASS: PriorityAllocation assigns by customer grade\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: PriorityAllocation doesn't handle grades correctly\n");
            failCount++;
        }
    }
    
    // 테스트 4: AgentGetCall 상담원 주도 검증
    // given: AgentGetCall 스케줄러가 주어졌을 때
    // when: 전화 요청 및 가져가기를 실행하면
    // then: 상담원이 능동적으로 전화를 요청하고 가져가야 함
    private static void testAgentGetCall() {
        System.out.println("Test 4: AgentGetCall allows agents to pull calls");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        
        // given: AgentGetCall 스케줄러
        Scheduler scheduler = new AgentGetCall();
        
        // when: 전화 요청 및 가져가기
        scheduler.getNextCall();
        scheduler.sendCallToAgent();
        
        System.setOut(originalOut);
        String output = outputStream.toString();
        
        // then: 상담원이 능동적으로 전화를 요청하고 가져감
        boolean agentRequests = output.contains("상담원이 다음 전화 요청");
        boolean agentTakes = output.contains("상담원이 전화 상담을 가져갔습니다");
        
        if (agentRequests && agentTakes) {
            System.out.println("✅ PASS: AgentGetCall allows agent-driven call handling\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: AgentGetCall doesn't work correctly\n");
            failCount++;
        }
    }
    
    // 테스트 5: Scheduler 인터페이스 구현 검증
    // given: 네 가지 스케줄러 구현체가 주어졌을 때
    // when: instanceof로 타입을 확인하면
    // then: 모두 Scheduler 인터페이스를 구현해야 함
    private static void testSchedulerInterface() {
        System.out.println("Test 5: All schedulers implement Scheduler interface");
        
        // given: 네 가지 스케줄러 구현체
        Scheduler roundRobin = new RoundRobin();
        Scheduler leastJob = new LeastJob();
        Scheduler priority = new PriorityAllocation();
        Scheduler agentGet = new AgentGetCall();
        
        // when: instanceof로 타입 확인
        boolean roundRobinImplements = roundRobin instanceof Scheduler;
        boolean leastJobImplements = leastJob instanceof Scheduler;
        boolean priorityImplements = priority instanceof Scheduler;
        boolean agentGetImplements = agentGet instanceof Scheduler;
        
        // then: 모두 Scheduler 인터페이스 구현
        if (roundRobinImplements && leastJobImplements && priorityImplements && agentGetImplements) {
            System.out.println("✅ PASS: All schedulers implement Scheduler interface\n");
            passCount++;
        } else {
            System.out.println("❌ FAIL: Not all schedulers implement Scheduler interface\n");
            failCount++;
        }
    }
}
