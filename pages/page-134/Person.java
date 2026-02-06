// ============================================================
// Person 클래스: 사람의 기본 정보를 저장하는 클래스
// ============================================================
// 목적: 클래스 정의, 필드 선언, 생성자, getter 메서드 학습
// Page 134 예제: 나이, 이름, 결혼 여부, 자녀 수를 갖는 Person 객체
// ============================================================

public class Person {
    // private 필드: 외부에서 직접 접근 불가, getter로만 접근
    // age: 사람의 나이를 저장하는 정수형 변수
    private int age;
    // name: 사람의 이름을 저장하는 문자열 변수
    private String name;
    // isMarried: 결혼 여부를 저장하는 boolean 변수 (true: 기혼, false: 미혼)
    private boolean isMarried;
    // numberOfChildren: 자녀 수를 저장하는 정수형 변수
    private int numberOfChildren;
    
    // 생성자 (Constructor): Person 객체를 생성할 때 초기값 설정
    // 매개변수로 받은 값들을 필드에 할당하여 객체 초기화
    // this.필드명: 현재 객체의 필드를 가리킴 (매개변수와 필드명이 같을 때 구분용)
    public Person(int age, String name, boolean isMarried, int numberOfChildren) {
        this.age = age;                           // 나이 설정
        this.name = name;                         // 이름 설정
        this.isMarried = isMarried;               // 결혼 여부 설정
        this.numberOfChildren = numberOfChildren; // 자녀 수 설정
    }
    
    // Getter 메서드: private 필드의 값을 외부로 반환
    // getAge(): 나이 필드의 값을 반환
    public int getAge() {
        return age;
    }
    
    // getName(): 이름 필드의 값을 반환
    public String getName() {
        return name;
    }
    
    // isMarried(): 결혼 여부 필드의 값을 반환
    // boolean 타입의 getter는 관례적으로 is로 시작
    public boolean isMarried() {
        return isMarried;
    }
    
    // getNumberOfChildren(): 자녀 수 필드의 값을 반환
    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    
    // printInfo(): Person 객체의 모든 정보를 출력하는 메서드
    // void: 반환값이 없는 메서드
    // 문자열 연결(+)을 사용하여 필드 값을 포함한 문장 출력
    public void printInfo() {
        System.out.println("이 사람의 나이는 " + age + "살입니다.");
        System.out.println("이 사람의 이름은 " + name + "입니다.");
        System.out.println("이 사람의 결혼 여부는 " + isMarried + "입니다.");
        System.out.println("이 사람의 자녀 수는 " + numberOfChildren + "명입니다.");
    }
}
