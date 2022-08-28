package study.example.core1;

import study.example.core1.member.Grade;
import study.example.core1.member.Member;
import study.example.core1.member.MemberService;
import study.example.core1.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = "+ findMember.getName());


    }
}
