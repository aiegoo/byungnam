// Page 66: 성적에 따라 학점 계산
// 학점 기준: A+ (95+), A (90+), B+ (85+), B (80+), C (70+), D (60+), F (60 미만)
public class GradeCalculator {
    
    // 점수를 입력받아 학점을 반환하는 메서드
    // if문 체인을 사용하여 점수 범위를 체크
    // 높은 점수부터 낮은 점수 순으로 비교해야 정확한 학점 판정 가능
    public static String calculateGrade(int score) {
        if (score >= 95) return "A+";  // 95점 이상이면 A+ 학점
        if (score >= 90) return "A";   // 90점 이상이면 A 학점
        if (score >= 85) return "B+";  // 85점 이상이면 B+ 학점
        if (score >= 80) return "B";   // 80점 이상이면 B 학점
        if (score >= 70) return "C";   // 70점 이상이면 C 학점
        if (score >= 60) return "D";   // 60점 이상이면 D 학점
        return "F";                     // 나머지 모두 F 학점
    }
    
    // 메인 메서드: 여러 점수에 대한 학점 계산 테스트
    public static void main(String[] args) {
        // 테스트용 점수 배열 - 각 학점 범위를 대표하는 점수들
        int[] scores = {98, 92, 87, 82, 75, 65, 55};
        
        System.out.println("=== 성적 학점 계산기 ===");
        // 향상된 for문으로 배열의 각 점수를 순회하며 학점 출력
        for (int score : scores) {
            System.out.println("점수: " + score + " → 학점: " + calculateGrade(score));
        }
    }
}
