package com.study.rest.repository;

import com.study.rest.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    //insert , update , delete 리턴타입 무조건 int
    int save(Product product);
}
