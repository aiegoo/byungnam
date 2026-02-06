// ============================================================
// DateValidator: 날짜 유효성 검증 유틸리티 클래스
// ============================================================
// 목적: 생년월일 형식 및 논리적 유효성 검증
// ============================================================

public class DateValidator {
    
    // 날짜 유효성 검증 메인 메서드
    // 년, 월, 일을 받아 유효한 날짜인지 확인
    public static boolean isValidDate(int year, int month, int day) {
        // 년도 검증: 1900년 ~ 현재년도
        if (year < 1900 || year > 2026) {
            return false;
        }
        
        // 월 검증: 1 ~ 12
        if (month < 1 || month > 12) {
            return false;
        }
        
        // 일 검증: 1 ~ 해당 월의 최대 일수
        int maxDay = getMaxDayInMonth(year, month);
        if (day < 1 || day > maxDay) {
            return false;
        }
        
        return true;
    }
    
    // 특정 년도, 월의 최대 일수 반환
    private static int getMaxDayInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                // 2월은 윤년 여부에 따라 28일 또는 29일
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0;
        }
    }
    
    // 윤년 판정
    // 1. 4로 나누어떨어지는 해는 윤년
    // 2. 단, 100으로 나누어떨어지는 해는 평년
    // 3. 단, 400으로 나누어떨어지는 해는 윤년
    private static boolean isLeapYear(int year) {
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
    
    // 생년월일로부터 나이 계산
    // 간단한 계산: 현재년도 - 출생년도 (실제로는 월/일 고려 필요)
    public static int calculateAge(int birthYear, int birthMonth, int birthDay) {
        int currentYear = 2026;
        int currentMonth = 2;
        int currentDay = 6;
        
        int age = currentYear - birthYear;
        
        // 생일이 아직 지나지 않았으면 나이에서 1을 뺌
        if (currentMonth < birthMonth || 
            (currentMonth == birthMonth && currentDay < birthDay)) {
            age--;
        }
        
        return age;
    }
    
    // 날짜 문자열 파싱 (형식: YYYY-MM-DD)
    public static boolean isValidDateString(String dateString) {
        try {
            String[] parts = dateString.split("-");
            if (parts.length != 3) {
                return false;
            }
            
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            
            return isValidDate(year, month, day);
        } catch (Exception e) {
            return false;
        }
    }
}
