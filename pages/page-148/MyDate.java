// ============================================================
// MyDate: 날짜를 표현하는 클래스
// ============================================================
// 목적:
// - 날짜 정보(년, 월, 일)를 저장하고 관리
// - 캡슐화: private 필드 + public getter/setter
// - 날짜 유효성 검증 기능 제공
// ============================================================

public class MyDate {
    // private 필드: 외부에서 직접 접근 불가
    // 오직 getter/setter 메서드를 통해서만 접근 가능
    private int day;      // 일 (1-31)
    private int month;    // 월 (1-12)
    private int year;     // 년 (1900-2026)
    
    // 생성자: MyDate 객체를 생성하고 초기화
    // 매개변수로 받은 값을 setter 메서드를 통해 설정
    // setter를 사용하는 이유: 나중에 setter에 유효성 검증 로직을 추가할 수 있음
    public MyDate(int day, int month, int year) {
        setYear(year);   // year 필드에 값 설정
        setMonth(month); // month 필드에 값 설정
        setDay(day);     // day 필드에 값 설정
    }
    
    // Getter: day 필드의 값을 반환
    // private 필드를 외부에서 읽을 수 있도록 하는 메서드
    public int getDay() {
        return day;
    }
    
    // Setter: day 필드에 값을 설정
    // private 필드를 외부에서 수정할 수 있도록 하는 메서드
    // this.day: 이 객체의 day 필드
    // day (매개변수): 메서드로 전달받은 값
    public void setDay(int day) {
        this.day = day;
    }
    
    // Getter: month 필드의 값을 반환
    public int getMonth() {
        return month;
    }
    
    // Setter: month 필드에 값을 설정
    public void setMonth(int month) {
        this.month = month;
    }
    
    // Getter: year 필드의 값을 반환
    public int getYear() {
        return year;
    }
    
    // Setter: year 필드에 값을 설정
    public void setYear(int year) {
        this.year = year;
    }
    
    // 날짜 유효성 검증 메서드
    // 반환값: Boolean - 유효하면 true, 무효하면 false
    public Boolean isValid() {
        // 1. 년도 검증: 1900년 ~ 2026년
        if (year < 1900 || year > 2026) {
            return false;
        }
        
        // 2. 월 검증: 1월 ~ 12월
        if (month < 1 || month > 12) {
            return false;
        }
        
        // 3. 일 검증: 1 ~ 해당 월의 최대 일수
        int maxDay = getMaxDayInMonth(year, month);
        if (day < 1 || day > maxDay) {
            return false;
        }
        
        // 모든 검증 통과
        return true;
    }
    
    // 특정 년도의 특정 월의 최대 일수를 반환하는 private 메서드
    // private: 클래스 내부에서만 사용되는 헬퍼 메서드
    private int getMaxDayInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                // 1, 3, 5, 7, 8, 10, 12월은 31일
                return 31;
            case 4: case 6: case 9: case 11:
                // 4, 6, 9, 11월은 30일
                return 30;
            case 2:
                // 2월은 윤년이면 29일, 평년이면 28일
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }
    
    // 윤년 판정 메서드
    // 윤년 규칙:
    // 1. 400으로 나누어떨어지면 윤년
    // 2. 100으로 나누어떨어지면 평년
    // 3. 4로 나누어떨어지면 윤년
    // 4. 그 외는 평년
    private boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;  // 2000년, 2400년 등
        }
        if (year % 100 == 0) {
            return false; // 1900년, 2100년 등
        }
        if (year % 4 == 0) {
            return true;  // 2004년, 2008년 등
        }
        return false;     // 일반 평년
    }
}
