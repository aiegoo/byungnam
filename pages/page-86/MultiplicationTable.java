public class MultiplicationTable {
    
    public static void printFullTable() {
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println("=== " + dan + "단 ===");
            for (int num = 1; num <= 9; num++) {
                System.out.println(dan + " × " + num + " = " + (dan * num));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("*** 구구단 (2단 ~ 9단) ***\n");
        printFullTable();
    }
}
