// ============================================================
// TransportationTestSuite: 교통 시스템 종합 테스트
// ============================================================
// 테스트 목표:
// 1. Student, Bus, Subway 객체 생성 확인
// 2. 교통 수단 이용 시 요금 처리 확인
// 3. 승객 수와 수입 계산 정확성 확인
// 4. 여러 학생이 같은 교통수단 이용 시나리오
// ============================================================

public class TransportationTestSuite {
    private static int totalTests = 0;
    private static int passedTests = 0;
    
    public static void main(String[] args) {
        System.out.println("=== 교통 시스템 테스트 시작 ===\n");
        
        testStudentCreation();
        testBusCreation();
        testSubwayCreation();
        testStudentTakesBus();
        testStudentTakesSubway();
        testMultipleStudentsSameBus();
        testMultipleStudentsSameSubway();
        testStudentTakesMultipleTransports();
        
        System.out.println("\n=== 테스트 결과 ===");
        System.out.println("전체 테스트: " + totalTests);
        System.out.println("통과: " + passedTests);
        System.out.println("실패: " + (totalTests - passedTests));
        
        if (passedTests == totalTests) {
            System.out.println("\n✅ 모든 테스트 통과!");
        } else {
            System.out.println("\n❌ 일부 테스트 실패");
        }
    }
    
    // 테스트 1: Student 객체 생성
    private static void testStudentCreation() {
        System.out.println("테스트 1: Student 객체 생성");
        totalTests++;
        
        try {
            Student student = new Student("James", 5000);
            
            if (student.studentName.equals("James") && student.money == 5000) {
                System.out.println("✅ 통과: Student 생성 및 초기화 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Student 초기화 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 2: Bus 객체 생성
    private static void testBusCreation() {
        System.out.println("테스트 2: Bus 객체 생성");
        totalTests++;
        
        try {
            Bus bus = new Bus(100);
            
            if (bus.busNumber == 100 && bus.passengerCount == 0 && bus.money == 0) {
                System.out.println("✅ 통과: Bus 생성 및 초기화 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Bus 초기화 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 3: Subway 객체 생성
    private static void testSubwayCreation() {
        System.out.println("테스트 3: Subway 객체 생성");
        totalTests++;
        
        try {
            Subway subway = new Subway("2호선");
            
            if (subway.lineNumber.equals("2호선") && 
                subway.passengerCount == 0 && subway.money == 0) {
                System.out.println("✅ 통과: Subway 생성 및 초기화 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: Subway 초기화 오류");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 4: 학생이 버스를 탐
    private static void testStudentTakesBus() {
        System.out.println("테스트 4: 학생이 버스를 탐");
        totalTests++;
        
        try {
            Student student = new Student("James", 5000);
            Bus bus = new Bus(100);
            
            student.takeBus(bus);
            
            if (student.money == 4000 && 
                bus.passengerCount == 1 && bus.money == 1000) {
                System.out.println("✅ 통과: 버스 탑승 시 요금 처리 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 버스 요금 처리 오류");
                System.out.println("   학생 돈: " + student.money + " (예상: 4000)");
                System.out.println("   버스 승객: " + bus.passengerCount + " (예상: 1)");
                System.out.println("   버스 수입: " + bus.money + " (예상: 1000)");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 5: 학생이 지하철을 탐
    private static void testStudentTakesSubway() {
        System.out.println("테스트 5: 학생이 지하철을 탐");
        totalTests++;
        
        try {
            Student student = new Student("Tomas", 10000);
            Subway subway = new Subway("2호선");
            
            student.takeSubway(subway);
            
            if (student.money == 8500 && 
                subway.passengerCount == 1 && subway.money == 1500) {
                System.out.println("✅ 통과: 지하철 탑승 시 요금 처리 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 지하철 요금 처리 오류");
                System.out.println("   학생 돈: " + student.money + " (예상: 8500)");
                System.out.println("   지하철 승객: " + subway.passengerCount + " (예상: 1)");
                System.out.println("   지하철 수입: " + subway.money + " (예상: 1500)");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 6: 여러 학생이 같은 버스를 탐
    private static void testMultipleStudentsSameBus() {
        System.out.println("테스트 6: 여러 학생이 같은 버스를 탐");
        totalTests++;
        
        try {
            Student student1 = new Student("James", 5000);
            Student student2 = new Student("Tomas", 10000);
            Student student3 = new Student("Edward", 8000);
            Bus bus = new Bus(100);
            
            student1.takeBus(bus);
            student2.takeBus(bus);
            student3.takeBus(bus);
            
            if (student1.money == 4000 && student2.money == 9000 && 
                student3.money == 7000 && 
                bus.passengerCount == 3 && bus.money == 3000) {
                System.out.println("✅ 통과: 여러 학생 버스 탑승 처리 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 여러 학생 버스 탑승 오류");
                System.out.println("   버스 승객: " + bus.passengerCount + " (예상: 3)");
                System.out.println("   버스 수입: " + bus.money + " (예상: 3000)");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 7: 여러 학생이 같은 지하철을 탐
    private static void testMultipleStudentsSameSubway() {
        System.out.println("테스트 7: 여러 학생이 같은 지하철을 탐");
        totalTests++;
        
        try {
            Student student1 = new Student("Alice", 10000);
            Student student2 = new Student("Bob", 8000);
            Subway subway = new Subway("3호선");
            
            student1.takeSubway(subway);
            student2.takeSubway(subway);
            
            if (student1.money == 8500 && student2.money == 6500 && 
                subway.passengerCount == 2 && subway.money == 3000) {
                System.out.println("✅ 통과: 여러 학생 지하철 탑승 처리 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 여러 학생 지하철 탑승 오류");
                System.out.println("   지하철 승객: " + subway.passengerCount + " (예상: 2)");
                System.out.println("   지하철 수입: " + subway.money + " (예상: 3000)");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
    
    // 테스트 8: 한 학생이 버스와 지하철을 모두 탐
    private static void testStudentTakesMultipleTransports() {
        System.out.println("테스트 8: 한 학생이 버스와 지하철을 모두 탐");
        totalTests++;
        
        try {
            Student student = new Student("Charlie", 10000);
            Bus bus = new Bus(200);
            Subway subway = new Subway("4호선");
            
            student.takeBus(bus);       // 10000 - 1000 = 9000
            student.takeSubway(subway); // 9000 - 1500 = 7500
            
            if (student.money == 7500 && 
                bus.passengerCount == 1 && bus.money == 1000 &&
                subway.passengerCount == 1 && subway.money == 1500) {
                System.out.println("✅ 통과: 여러 교통수단 이용 처리 정확");
                passedTests++;
            } else {
                System.out.println("❌ 실패: 여러 교통수단 이용 오류");
                System.out.println("   학생 돈: " + student.money + " (예상: 7500)");
            }
        } catch (Exception e) {
            System.out.println("❌ 실패: " + e.getMessage());
        }
        System.out.println();
    }
}
