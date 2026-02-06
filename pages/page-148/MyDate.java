public class MyDate {
    private int day;
    private int month;
    private int year;
    
    public MyDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }
    
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public Boolean isValid() {
        if (year < 1900 || year > 2026) {
            return false;
        }
        
        if (month < 1 || month > 12) {
            return false;
        }
        
        int maxDay = getMaxDayInMonth(year, month);
        if (day < 1 || day > maxDay) {
            return false;
        }
        
        return true;
    }
    
    private int getMaxDayInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }
    
    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }
}
