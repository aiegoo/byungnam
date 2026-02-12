package collection.arraylist;

import collection.Member;

public class MemberArrayListTest {
    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();

        Member memberYoon = new Member(1001, "윤해강");
        Member memberLee = new Member(1002, "이용태");
        Member memberHan = new Member(1003, "한세윤");
        Member memberSol = new Member(1004, "이한솔");
        Member memberPark = new Member(1005, "박성우");

        memberArrayList.addMember(memberYoon);
        memberArrayList.addMember(memberLee);
        memberArrayList.addMember(memberHan);
        memberArrayList.addMember(memberSol);

        memberArrayList.showAllMember();
        System.out.println("== index 1 위치에 박성우 회원 추가 ==");
        memberArrayList.insertMember(memberPark, 1);
        memberArrayList.showAllMember();

        memberArrayList.removeMember(memberYoon.getMemberId());
        memberArrayList.showAllMember();
    }
}
