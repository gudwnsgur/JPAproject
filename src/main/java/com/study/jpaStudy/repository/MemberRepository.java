package com.study.jpaStudy.repository;

import com.study.jpaStudy.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // 자동으로 Spring bean으로 관리
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    private void save(Member member) {
        em.persist(member);
    }

    private Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    private List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class).
                getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("SELECT m FROM Member m WHERE m.name = :name", Member.class).
                setParameter("name", name).getResultList();
    }



}
