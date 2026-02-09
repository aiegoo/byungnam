// VIPCustomer: Customer를 상속받아 추가 할인 혜택을 주는 고객 클래스
public class VIPCustomer extends Customer { // 상위 Customer 기능을 확장하여 VIP 혜택 제공
    private double saleRatio; // 추가 할인율(10%)

    public VIPCustomer(int customerID, String customerName) { // VIP 고객 생성자
        super(customerID, customerName); // 기본 고객 정보는 부모 생성자에서 초기화
        customerGrade = "VIP";           // VIP 등급으로 설정
        bonusRatio = 0.05;                // VIP는 5% 포인트 적립
        saleRatio = 0.1;                  // VIP는 10% 할인율 적용
    }

    @Override
    public int calcPrice(int price) {     // 결제 금액을 VIP 정책에 맞게 계산
        bonusPoint += price * bonusRatio; // 결제 금액의 5%를 포인트로 적립
        return price - (int)(price * saleRatio); // 10% 할인된 금액을 반환
    }
}
