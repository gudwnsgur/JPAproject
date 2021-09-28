package com.study.jpaStudy.repository;

import com.study.jpaStudy.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName; // 회원명
    private OrderStatus orderStatus; // 주문 상태 [ORDER, CANCEL]


}
