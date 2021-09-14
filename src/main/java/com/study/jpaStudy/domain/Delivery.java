package com.study.jpaStudy.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded   // 내장 타입
    private Address address;

//    @Enumerated(EnumType.ORDINAL) // 1, 2, 3, 4
    @Enumerated(EnumType.STRING) // READY, COMP
    private DeliveryStatus status;
}
