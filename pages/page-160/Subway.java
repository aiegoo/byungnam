// ============================================================
// Subway: 지하철 클래스
// ============================================================
// 목적: 지하철의 상태(승객 수, 수입)를 관리
// 협력 관계: Student 객체로부터 요금을 받음
// ============================================================

public class Subway {
    public String lineNumber;  // 지하철 노선 (예: "2호선")
    public int passengerCount; // 승객 수
    public int money;          // 수입
    
    // 생성자: 지하철 노선 번호를 받아 초기화
    // passengerCount와 money는 자동으로 0으로 초기화됨
    public Subway(String lineNumber) {
        this.lineNumber = lineNumber;
    }
    
    // 승객 탑승 메서드
    // Student 객체가 호출하여 요금을 전달
    // 1. 전달받은 요금을 지하철 수입에 추가
    // 2. 승객 수를 1 증가
    public void take(int money) {
        this.money += money;  // 수입 증가
        passengerCount++;     // 승객 수 증가
    }
    
    // 지하철 정보 출력 메서드
    // 노선, 승객 수, 총 수입을 출력
    public void showInfo() {
        System.out.println("지하철 " + lineNumber + "의 승객은 " + passengerCount + 
                          "명이고, 수입은 " + money + "원입니다.");
    }
}
