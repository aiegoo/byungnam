// CustomerTestSuite: Customer 와 VIPCustomer 로직을 점검하는 간단한 수동 테스트 러너
public class CustomerTestSuite {
    private static int total = 0; // 전체 테스트 수
    private static int passed = 0; // 통과한 테스트 수

    public static void main(String[] args) {
        run("silver customer pays full price", CustomerTestSuite::testSilverPaysFullPrice);
        run("vip customer gets 10 percent discount", CustomerTestSuite::testVipDiscount);
        run("bonus points accumulate correctly", CustomerTestSuite::testBonusAccumulation);

        System.out.println("==============================");
        System.out.println("테스트 결과: " + passed + "/" + total + " passed");
    }

    private static void run(String name, Runnable test) {
        total++;
        try {
            test.run();
            passed++;
            System.out.println("[PASS] " + name);
        } catch (AssertionError error) {
            System.out.println("[FAIL] " + name + " -> " + error.getMessage());
        }
    }

    private static void testSilverPaysFullPrice() {
        Customer customer = new Customer(1, "silver");
        int paid = customer.calcPrice(10000);
        expect(paid == 10000, "SILVER 고객은 할인 없이 10,000원을 지불해야 함");
    }

    private static void testVipDiscount() {
        VIPCustomer customer = new VIPCustomer(2, "vip");
        int paid = customer.calcPrice(10000);
        expect(paid == 9000, "VIP 고객은 10% 할인으로 9,000원을 지불해야 함");
    }

    private static void testBonusAccumulation() {
        VIPCustomer customer = new VIPCustomer(3, "bonus");
        customer.calcPrice(20000);
        expect(customer.bonusPoint == 1000, "VIP는 5% 포인트 적립으로 1,000포인트를 얻게 됨");
    }

    private static void expect(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
