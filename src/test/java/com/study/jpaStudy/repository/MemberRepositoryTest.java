package com.study.jpaStudy.repository;

import com.study.jpaStudy.domain.Member;
import com.study.jpaStudy.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("Hyoung");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test
    public void 중복_회원_조회() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("Hyoung");

        Member member2 = new Member();
        member2.setName("Hyoung");
        //when
        memberService.join(member1);
        try{
            memberService.join(member2);
        } catch (IllegalStateException e) {
            return;
        }
        //then
        fail("예외가 발생해야 한다.");
    }
}