/**
 * Page No.69 - Assignment 2
 * Switch case 문을 이용하여 층별 시설 안내
 * 
 * 요구사항:
 * - 1층 약국, 2층 정형외과, 3층 피부과, 4층 치과, 5층 헬스 클럽
 * - 5층인 경우 "5층 헬스 클럽입니다."라고 출력되도록 구현
 * 
 * @author byungnam
 */
public class BuildingFloor {
    
    /**
     * 층 번호에 따른 시설 정보를 반환하는 메서드
     * @param floor 층 번호 (1-5)
     * @return 해당 층의 시설 안내 문구
     */
    public static String getFloorInfo(int floor) {
        String info;
        
        switch (floor) {
            case 1: // 1층 약국
                info = "1층 약국입니다.";
                break;
            case 2: // 2층 정형외과
                info = "2층 정형외과입니다.";
                break;
            case 3: // 3층 피부과
                info = "3층 피부과입니다.";
                break;
            case 4: // 4층 치과
                info = "4층 치과입니다.";
                break;
            case 5: // 5층 헬스 클럽 (요구사항)
                info = "5층 헬스 클럽입니다.";
                break;
            default: // 존재하지 않는 층
                info = "해당 층은 없습니다.";
                break;
        }
        
        return info;
    }
    
    public static void main(String[] args) {
        // 테스트: 모든 층 정보 출력
        for (int floor = 1; floor <= 6; floor++) {
            System.out.println(getFloorInfo(floor));
        }
    }
}
