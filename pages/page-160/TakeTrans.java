// ============================================================
// TakeTrans: 교통 이용 시뮬레이션 테스트
// ============================================================
// 목적: Student, Bus, Subway 객체들의 상호작용을 테스트
// 시나리오:
// 1. James는 버스를 타고 등교
// 2. Tomas는 지하철을 타고 등교
// ============================================================

public class TakeTrans {
    public static void main(String[] args) {
        // 학생 객체 생성
        Student studentJames = new Student("James", 5000);  // James, 소지금 5000원
        Student studentTomas = new Student("Tomas", 10000); // Tomas, 소지금 10000원
        
        // 시나리오 1: James가 100번 버스를 탐
        Bus bus100 = new Bus(100);          // 100번 버스 생성
        studentJames.takeBus(bus100);       // James가 버스 탑승 (1000원 지불)
        studentJames.showInfo();            // James 정보 출력 (남은 돈: 4000원)
        bus100.showInfo();                  // 버스 정보 출력 (승객 1명, 수입 1000원)
        
        System.out.println();
        
        // 시나리오 2: Tomas가 2호선 지하철을 탐
        Subway subwayGreen = new Subway("2호선"); // 2호선 지하철 생성
        studentTomas.takeSubway(subwayGreen);    // Tomas가 지하철 탑승 (1500원 지불)
        studentTomas.showInfo();                 // Tomas 정보 출력 (남은 돈: 8500원)
        subwayGreen.showInfo();                  // 지하철 정보 출력 (승객 1명, 수입 1500원)
        
        System.out.println();
        
        // 시나리오 3: Jenna가 늦잠을 자서 택시를 탐
        Student studentJenna = new Student("Jenna", 15000); // Jenna, 소지금 15000원
        Taxi taxi5678 = new Taxi("5678");                   // 5678 택시 생성
        studentJenna.takeTaxi(taxi5678);                    // Jenna가 택시 탑승 (10000원 지불)
        studentJenna.showInfo();                            // Jenna 정보 출력 (남은 돈: 5000원)
        taxi5678.showInfo();                                // 택시 정보 출력 (승객 1명, 수입 10000원)
    }
}
