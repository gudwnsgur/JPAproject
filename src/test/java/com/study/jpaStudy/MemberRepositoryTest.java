package com.study.jpaStudy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MemberRepositoryTest
{
    // test는 마지막에 Rollback 실행
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
	@Rollback(false)	// 테스트 종료 후 데이터를 롤백하지 않고 그대로 남겨두는 옵션
    public void testMember() throws Exception
    {
        //given
        Member member = new Member();
        member.setUserName("HyoungJoonHyuck");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        assertEquals(findMember.getId(), member.getId());
        assertEquals(findMember.getUserName(), member.getUserName());
        assertEquals(findMember, member);
    }
}