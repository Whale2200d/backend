package code2;

import java.util.List;

public class MemberService {
    /**
     * 회원 가입
     * @param member 회원정보
     * @return 성공여부
     */
    public boolean register(Member member) {
         return true;
    }

    /**
     * 회원 탈퇴
     * @param member 회원정보
     * @return 성공여부
     */
    public boolean withdraw(Member member) {
        return true;
    }

    /**
     * 회원 정보 목록 조회
     * @return 회원정보 목록
     */
    public List<Member> getList() {
        return null;
    }
}
