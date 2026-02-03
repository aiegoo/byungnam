// Page 57-2: 4과목 평균 계산기
// 수학, 국어, 영어, 프로그래밍 점수의 평균을 구함
public class AverageCalculator {
    
    // 4과목의 평균을 계산하여 반환하는 메서드
    // 매개변수들: 각 과목의 점수를 int 타입으로 받음
    //   - math: 수학 점수 (정수)
    //   - korean: 국어 점수 (정수)
    //   - english: 영어 점수 (정수)
    //   - programming: 프로그래밍 점수 (정수)
    // 반환값: 4과목의 평균 (double 타입, 소수점 포함)
    // 4.0으로 나누는 이유: int / int는 정수 나눗셈이므로 소수점 버림 발생
    //   예: 87 / 4 = 21 (잘못됨), 87 / 4.0 = 21.75 (올바름)
    public static double calculateAverage(int math, int korean, int english, int programming) {
        // 연산 과정:
        // 1. math + korean + english + programming: 4개 int 더하기 → int 결과
        // 2. (int 합계) / 4.0: int를 double로 자동 형변환 후 나눗셈 → double 결과
        // 예: (85 + 90 + 78 + 95) / 4.0 = 348 / 4.0 = 87.0
        return (math + korean + english + programming) / 4.0;
    }
    
    // 메인 메서드: 프로그램 진입점
    // args: 명령줄 인자 배열 (여기서는 사용하지 않음)
    public static void main(String[] args) {
        // 각 과목의 점수를 int 변수에 저장
        // int: 정수 타입, -2,147,483,648 ~ 2,147,483,647 범위
        int math = 85;           // math 변수에 85 할당
        int korean = 90;         // korean 변수에 90 할당
        int english = 78;        // english 변수에 78 할당
        int programming = 95;    // programming 변수에 95 할당
        
        // 제목 출력: println은 문자열 출력 후 자동 줄바꿈
        System.out.println("=== 성적 평균 계산기 ===");
        
        // 각 과목의 점수 출력
        // + 연산자: 문자열 연결(concatenation) 수행
        // "수학: " + math + "점" → "수학: " + "85" + "점" → "수학: 85점"
        System.out.println("수학: " + math + "점");
        System.out.println("국어: " + korean + "점");
        System.out.println("영어: " + english + "점");
        System.out.println("프로그래밍: " + programming + "점");
        
        // 구분선 출력: 점수와 평균 결과를 시각적으로 구분
        System.out.println("---------------------");
        
        // calculateAverage 메서드 호출: 4개의 int 인자를 전달
        // 메서드가 반환하는 double 값을 average 변수에 저장
        // average는 double 타입으로 선언되어 소수점 값 저장 가능
        double average = calculateAverage(math, korean, english, programming);
        
        // printf: 형식화된 출력 메서드
        // "평균: %.2f점%n": 형식 문자열 (format string)
        //   - %.2f: 소수점 둘째자리까지 표시하는 부동소수점 형식 지정자
        //           f는 float/double을 의미, .2는 소수점 이하 2자리
        //   - %n: 플랫폼 독립적인 줄바꿈 문자 (\n과 유사하지만 OS에 따라 자동 조정)
        // average 값이 형식 지정자 %.2f 위치에 들어감
        // 출력 예: "평균: 87.00점"
        System.out.printf("평균: %.2f점%n", average);
    }
}
