package com.study.jpaStudy.service;

import com.study.jpaStudy.domain.Member;
import com.study.jpaStudy.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // JPA의 데이터 변경은 되도록 Transaction 안에서 실행되어야 한다.
@RequiredArgsConstructor
public class MemberService {
//    @Autowired
//    private MemberRepository memberRepository;

//    private MemberRepository memberRepository;
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    private final MemberRepository memberRepository;

    // 회원 가입
    @Transactional  // 데이터 변경은 (readOnly = false)
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // EXCEPTION
        List<Member> members = memberRepository.findByName(member.getName());
        // 동시에 같은 이름이 insert 되면 동시에 함수가 넘어가 질 수 있다.
        // 최후의 방어 : DB의 member 의 name 을 unique 로
        if(!members.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 조회
//    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 한건 조회
//    @Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
