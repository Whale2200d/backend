package code;

import java.util.Scanner;

public class DbTestMain {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
//        dbTest.dbSelect();
//        dbTest.dbInsert();
//        dbTest.dbUpdate();
//        dbTest.dbDelete();

        Scanner scanner = new Scanner(System.in);

        String memberTypeValue = "email";
        System.out.println("삭제할 이메일 아이디를 입력하세요.");
        System.out.println("아이디 입력: ====");
        String userIdValue = scanner.next();
//        System.out.println("비밀번호 입력: ====");
//        String passwordValue = scanner.next();
//        System.out.println("이름 입력: ====");
//        String nameValue = scanner.next();

        Member member = new Member();
        member.setMemberType(memberTypeValue);
        member.setUserId(userIdValue);
//        member.setPassword(passwordValue);
//        member.setName(nameValue);

//        memberService.register(member);
        memberService.withdraw(member);
    }
}
