package com.study.jpaStudy.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
// @Inheritance(strategy = InheritanceType.JOINED) // 가장 정규화된 스타일
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 전략 설정 : 한 테이블에 전부 때려박는 타입
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;


    private String name;
    private int price;
    private int stockQuantity;
}
