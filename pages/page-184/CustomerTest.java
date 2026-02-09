public class CustomerTest { // 메인 메서드를 통해 두 고객의 결제 금액을 검증하는 클래스
    public static void main(String[] args) { // 프로그램 진입점
        Customer customerPark = new Customer(10010, "박새로이"); // 일반 고객 생성
        VIPCustomer customerYoon = new VIPCustomer(10020, "윤세리"); // VIP 고객 생성

        int pricePark = customerPark.calcPrice(10000); // 일반 고객 결제 금액 계산 (할인 없음)
        int priceYoon = customerYoon.calcPrice(10000); // VIP 고객 결제 금액 계산 (10% 할인)

        System.out.println("박새로이님이 지불해야하는 금액은 " + pricePark + "원입니다."); // 일반 고객 금액 출력
        System.out.println("윤세리님이 지불해야하는 금액은 " + priceYoon + "원입니다."); // VIP 고객 금액 출력
    }
}
