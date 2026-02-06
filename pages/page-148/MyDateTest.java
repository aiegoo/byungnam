public class MyDateTest {
    public static void main(String[] args) {
        MyDate date1 = new MyDate(7, 2, 1976);
        System.out.println("날짜: " + date1.getYear() + "년 " + 
                          date1.getMonth() + "월 " + date1.getDay() + "일");
        System.out.println("유효한 날짜인가요? " + date1.isValid());
        System.out.println();
        
        MyDate date2 = new MyDate(30, 2, 2024);
        System.out.println("날짜: " + date2.getYear() + "년 " + 
                          date2.getMonth() + "월 " + date2.getDay() + "일");
        System.out.println("유효한 날짜인가요? " + date2.isValid());
        System.out.println();
        
        MyDate date3 = new MyDate(29, 2, 2024);
        System.out.println("날짜: " + date3.getYear() + "년 " + 
                          date3.getMonth() + "월 " + date3.getDay() + "일");
        System.out.println("유효한 날짜인가요? " + date3.isValid());
        System.out.println();
        
        MyDate date4 = new MyDate(31, 4, 2020);
        System.out.println("날짜: " + date4.getYear() + "년 " + 
                          date4.getMonth() + "월 " + date4.getDay() + "일");
        System.out.println("유효한 날짜인가요? " + date4.isValid());
    }
}
