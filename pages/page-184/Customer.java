// Customer: 기본 고객 정보를 유지하고 결제 시 보너스 포인트를 적립하는 클래스
public class Customer { // 모든 고객이 공통으로 사용하는 데이터와 로직을 모아둔 클래스
    protected int customerID;            // 고객 고유 번호
    protected String customerName;       // 고객 이름
    protected String customerGrade;      // 고객 등급 (기본값 SILVER)
    protected int bonusPoint;            // 적립된 보너스 포인트
    protected double bonusRatio;         // 결제 금액 대비 포인트 적립 비율

    public Customer(int customerID, String customerName) { // 생성자: 고객 번호와 이름을 받아 초기화
        this.customerID = customerID;     // 전달받은 고객 번호 저장
        this.customerName = customerName; // 전달받은 고객 이름 저장
        this.customerGrade = "SILVER";   // 기본 등급은 SILVER
        this.bonusRatio = 0.01;           // 기본 적립 비율은 1%
    }

    public int calcPrice(int price) {    // 결제 금액을 계산하고 포인트를 적립하는 메서드
        bonusPoint += price * bonusRatio; // 결제 금액 * 적립 비율만큼 포인트 누적
        return price;                     // SILVER 고객은 할인 없이 원금액을 지불
    }

    public String getCustomerName() {    // 고객 이름을 반환하는 getter
        return customerName;              // 저장된 고객 이름 반환
    }
}
