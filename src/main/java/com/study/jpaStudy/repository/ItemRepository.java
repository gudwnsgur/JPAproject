package com.study.jpaStudy.repository;


import com.study.jpaStudy.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) em.persist(item);

        /**
         * 주의 : 모든 속성이 변경된다.
         * 병합시 값이 없으면 null로 없데이트한다.
         * 따라서 merger보다 변경 감지를 사용해야한다.
         */
        else {
            Item merge = em.merge(item);// 유사 update
            // merge : 영속석 상태
            // item : 준영속 상태
        }
        // 준영속 상태를 영속 컨테스트로 변경해준다
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("SELECT i FROM Item i", Item.class).
                getResultList();
    }

}
