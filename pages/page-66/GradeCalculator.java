public class GradeCalculator {
    
    public static String calculateGrade(int score) {
        if (score >= 95) return "A+";
        if (score >= 90) return "A";
        if (score >= 85) return "B+";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }
    
    public static void main(String[] args) {
        int[] scores = {98, 92, 87, 82, 75, 65, 55};
        System.out.println("=== 성적 학점 계산기 ===");
        for (int score : scores) {
            System.out.println("점수: " + score + " → 학점: " + calculateGrade(score));
        }
    }
}
