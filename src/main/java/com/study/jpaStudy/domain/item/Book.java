package com.study.jpaStudy.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 싱글테이블에서 저장할때 구분하기 위해(기본 : Book)
@Getter @Setter
public class Book extends Item{

    private String author;
    private String isbn;
}
