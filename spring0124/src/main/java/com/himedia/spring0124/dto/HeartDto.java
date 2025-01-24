package com.himedia.spring0124.dto;


import lombok.Data;

//  하트의 개수를 업데이트할 수있는 데이터를
//  저장하는 클래스
@Data
public class HeartDto {
    private Long productId;
    private String action;
}
