public class EvenDanOnly {
    
    public static void printEvenDanTable() {
        for (int dan = 2; dan <= 9; dan++) {
            if (dan % 2 == 0) {
                System.out.println("=== " + dan + "단 ===");
                for (int num = 1; num <= 9; num++) {
                    System.out.println(dan + " × " + num + " = " + (dan * num));
                }
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("*** 구구단 (짝수단만) ***\n");
        printEvenDanTable();
    }
}
