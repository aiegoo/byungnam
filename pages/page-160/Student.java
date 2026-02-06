// ============================================================
// Student: 학생 클래스
// ============================================================
// 목적: 학생이 대중교통(버스, 지하철)을 이용하는 것을 객체지향으로 표현
// 협력 관계: Bus, Subway 객체와 상호작용
// ============================================================

public class Student {
    // public 필드: 외부에서 직접 접근 가능
    // 실무에서는 보통 private + getter/setter 사용 권장
    public String studentName;  // 학생 이름
    public int grade;           // 학년
    public int money;           // 학생이 가지고 있는 돈
    
    // 생성자: 학생 이름과 소지금을 받아 초기화
    // this: 현재 객체를 가리키는 키워드
    // this.studentName: 이 객체의 studentName 필드
    // studentName(매개변수): 메서드로 전달받은 값
    public Student(String studentName, int money) {
        this.studentName = studentName;
        this.money = money;
    }
    
    // 버스 탑승 메서드
    // 협력: Bus 객체의 take() 메서드를 호출하여 상호작용
    // 1. 버스에 요금(1000원)을 지불
    // 2. 학생의 소지금에서 요금을 차감
    public void takeBus(Bus bus) {
        bus.take(1000);      // 버스 객체에 요금 전달
        this.money -= 1000;  // 학생 소지금 차감
    }
    
    // 지하철 탑승 메서드
    // 협력: Subway 객체의 take() 메서드를 호출하여 상호작용
    // 1. 지하철에 요금(1500원)을 지불
    // 2. 학생의 소지금에서 요금을 차감
    public void takeSubway(Subway subway) {
        subway.take(1500);   // 지하철 객체에 요금 전달
        this.money -= 1500;  // 학생 소지금 차감
    }
    
    // 택시 탑승 메서드
    // 협력: Taxi 객체의 take() 메서드를 호출하여 상호작용
    // 1. 택시에 요금(10000원)을 지불
    // 2. 학생의 소지금에서 요금을 차감
    public void takeTaxi(Taxi taxi) {
        taxi.take(10000);    // 택시 객체에 요금 전달
        this.money -= 10000; // 학생 소지금 차감
    }
    
    // 학생 정보 출력 메서드
    // 학생 이름과 남은 소지금을 출력
    public void showInfo() {
        System.out.println(studentName + "님의 남은 돈은 " + money + "입니다.");
    }
}
