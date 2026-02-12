package collection.arraylist;

import collection.Member;
import java.util.ArrayList;

/**
 * ArrayList 기반 회원 관리 클래스.
 */
public class MemberArrayList {
    private final ArrayList<Member> arrayList;

    public MemberArrayList() {
        arrayList = new ArrayList<>();
    }

    // 회원 추가
    public void addMember(Member member) {
        arrayList.add(member);
    }

    // 특정 위치에 회원 추가
    public void insertMember(Member member, int index) {
        if (index < 0 || index > arrayList.size()) {
            System.out.println("유효하지 않은 위치입니다: " + index);
            return;
        }
        arrayList.add(index, member);
    }

    // 회원 삭제 (아이디 기준)
    public boolean removeMember(int memberId) {
        for (int i = 0; i < arrayList.size(); i++) {
            Member member = arrayList.get(i);
            if (member.getMemberId() == memberId) {
                arrayList.remove(i);
                return true;
            }
        }
        System.out.println(memberId + "가 존재하지 않습니다");
        return false;
    }

    // 전체 회원 출력
    public void showAllMember() {
        for (Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println();
    }

    // 테스트를 위한 현재 인원 수 확인 메서드
    public int size() {
        return arrayList.size();
    }
}
