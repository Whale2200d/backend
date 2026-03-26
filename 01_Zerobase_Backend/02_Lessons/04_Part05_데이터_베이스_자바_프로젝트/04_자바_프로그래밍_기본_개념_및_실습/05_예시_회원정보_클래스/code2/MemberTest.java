package code2;

import java.util.List;

public class MemberTest {
    public static void main(String[] args) {
        Member member = new Member();
        member.setUserId("abc");
        System.out.println("Id: " + member.getUserId());

        MemberService memberService = new MemberService();
        boolean result = memberService.register(member);
        boolean result2 = memberService.withdraw(member);
        List<Member> memberList = memberService.getList();
    }
}
