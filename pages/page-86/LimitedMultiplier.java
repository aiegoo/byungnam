public class LimitedMultiplier {
    
    public static void printLimitedTable() {
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("=== " + dan + "단 ===");
            for (int num = 1; num <= dan; num++) {
                System.out.println(dan + " × " + num + " = " + (dan * num));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("*** 구구단 (곱하는 수 ≤ 단수) ***\n");
        printLimitedTable();
    }
}
