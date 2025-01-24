package com.himedia.spring0124.controller;

import com.himedia.spring0124.dto.HeartDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {

    @PostMapping("/product/heart")
    public String heart(@RequestBody HeartDto dto) {
        System.out.println("restController heart메서드");
        System.out.println(dto);

        if("like".equals(dto.getAction())){

        }else{

        }
        // 변경된 하트 카운트를 자바스크립트로 넘긴다.

        // 실제 값을 변경할 때는 save(값)
        //  만약 데이터베이스에 값이 있다면 수정이 읽어나고
        //  만약 데이터베이스에 값이 없다면 추가를 한다.

        return "";
    }
}
