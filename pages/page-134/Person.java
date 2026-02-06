public class Person {
    private int age;
    private String name;
    private boolean isMarried;
    private int numberOfChildren;
    
    public Person(int age, String name, boolean isMarried, int numberOfChildren) {
        this.age = age;
        this.name = name;
        this.isMarried = isMarried;
        this.numberOfChildren = numberOfChildren;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isMarried() {
        return isMarried;
    }
    
    public int getNumberOfChildren() {
        return numberOfChildren;
    }
    
    public void printInfo() {
        System.out.println("이 사람의 나이는 " + age + "살입니다.");
        System.out.println("이 사람의 이름은 " + name + "입니다.");
        System.out.println("이 사람의 결혼 여부는 " + isMarried + "입니다.");
        System.out.println("이 사람의 자녀 수는 " + numberOfChildren + "명입니다.");
    }
}
