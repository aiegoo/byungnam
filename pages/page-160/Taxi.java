// ============================================================
// Taxi: 택시 클래스
// ============================================================
// 목적: 택시의 상태(승객 수, 수입)를 관리
// 협력 관계: Student 객체로부터 요금을 받음
// 시나리오: 학생이 늦잠을 자서 택시를 타고 등교
// ============================================================

public class Taxi {
    public String taxiNumber;  // 택시 번호
    public int passengerCount; // 승객 수
    public int money;          // 수입
    
    // 생성자: 택시 번호를 받아 초기화
    // passengerCount와 money는 자동으로 0으로 초기화됨
    public Taxi(String taxiNumber) {
        this.taxiNumber = taxiNumber;
    }
    
    // 승객 탑승 메서드
    // Student 객체가 호출하여 요금을 전달
    // 1. 전달받은 요금을 택시 수입에 추가
    // 2. 승객 수를 1 증가
    public void take(int money) {
        this.money += money;  // 수입 증가
        passengerCount++;     // 승객 수 증가
    }
    
    // 택시 정보 출력 메서드
    // 택시 번호, 승객 수, 총 수입을 출력
    public void showInfo() {
        System.out.println("택시 " + taxiNumber + "의 승객은 " + passengerCount + 
                          "명이고, 수입은 " + money + "원입니다.");
    }
}
