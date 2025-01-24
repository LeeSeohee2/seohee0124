package com.himedia.spring0124.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본 키

    //상품1에 댓글을 가지고 오기!
    @JoinColumn(name="product_id")
    @ManyToOne
    private Product product;

    private String content;  //댓글 내용
    private String author;   //작성자 id
    private LocalDateTime createdAt = LocalDateTime.now(); //댓글 작성시간
}
