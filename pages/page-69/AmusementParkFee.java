/**
 * Page No.69 - Assignment 1
 * 놀이공원 입장료를 계산해보세요. (if ~ else if ~ else)
 * 
 * 요구사항:
 * - 취학 전 아동 (8살 미만) 은 1,000원
 * - 초등학생(14살 미만)은 2,000원
 * - 중고등학생(20살 미만)은 2,500원
 * - 그 이상은 3,000원
 * - 60세 이상은 0원
 * 
 * @author byungnam
 */
public class AmusementParkFee {
    
    /**
     * 나이에 따른 입장료를 계산하는 메서드
     * @param age 입장객의 나이
     * @return 입장료 금액
     */
    public static int calculateFee(int age) {
        int fee;
        
        if (age < 8) { // 취학 전 아동 (8살 미만)
            fee = 1000;
        } else if (age < 14) { // 초등학생 (14살 미만)
            fee = 2000;
        } else if (age < 20) { // 중고등학생 (20살 미만)
            fee = 2500;
        } else if (age < 60) { // 성인 (60살 미만)
            fee = 3000;
        } else { // 60세 이상 경로 우대
            fee = 0;
        }
        
        return fee;
    }
    
    public static void main(String[] args) {
        // 테스트 케이스들
        int[] testAges = {5, 10, 15, 25, 65};
        
        for (int age : testAges) {
            int fee = calculateFee(age);
            String category = getAgeCategory(age);
            System.out.println(category + " (" + age + "세): " + fee + "원");
        }
    }
    
    /**
     * 나이 범주를 반환하는 헬퍼 메서드
     */
    private static String getAgeCategory(int age) {
        if (age < 8) return "취학 전 아동";
        if (age < 14) return "초등학생";
        if (age < 20) return "중고등학생";
        if (age < 60) return "성인";
        return "경로 우대";
    }
}
