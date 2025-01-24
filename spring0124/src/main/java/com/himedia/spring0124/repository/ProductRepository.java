package com.himedia.spring0124.repository;

import com.himedia.spring0124.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository
         extends JpaRepository<Product, Long> {

    // 상위 4개를 가져오기
    // primary key 기준으로 정렬

    List<Product> findTop4By();

}
