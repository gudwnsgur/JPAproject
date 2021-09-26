package com.study.jpaStudy.domain.item;

import com.study.jpaStudy.domain.Category;
import com.study.jpaStudy.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // == 비즈니스 로직 == //

    // Setter를 통한 변경이 아닌 로직을 통해서 변경시켜라!
    /**
     * stock 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;

    }

    /**
     * stock 감소
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0 ) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
