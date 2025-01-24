package com.himedia.spring0124.controller;

import com.himedia.spring0124.dto.Product;
import com.himedia.spring0124.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class FrontController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index(Model model) {
        System.out.println("main페이지실행!");

        // 서버가 실행되서 main페이지가 열릴 때
        // 디비에서 데이터가 4개 혹은 전체 가져와서
        // 4개만 main.html 로 보내서 카드4개 생성하기

//        List<Product> products = productRepository
//                                    .findTop4By();
//        //반복문! for~each 문
//        // products 가지고 있는 개수만큼 자동으로 반복
//        for(Product item : products){
//            System.out.println(item.getName());
//        }

        // 전체를 가지고 가기
        List<Product> products = productRepository.findAll();


        model.addAttribute("products",
                                            products);

        return "main";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id,
                          Model model) {
        System.out.println("넘어온 id: " + id);
        // 상세페이지로 이동하기 전에!
        // 디비에서 현재 넘어온 아이디값을 이용해서
        // 상품을 detail한테 넘겨준다.

        Product product = productRepository
                            .findById(id)
                            .orElse(null);
        System.out.println("댓글들:" + product.getComments());

        // 결과값이 null이 나올 수 있다!
        model.addAttribute("product"
                            , product);

        return "detail";
    }




}

/*
git
 - 분산 버전 관리 시스템
 - 프로그램 개발을 하다보면은 코드작성하고 문서들을 변경
   할 수있도록 특정 시점으로 되돌리는 작업을 해준다.

 - git init  : 저장소 초기화
       add   : 변경된 파일 추가
       commit: 영구 저장
       push  : 변경된 파일을 내용을을 깃허브로
               보내기(업로드)
       pull  : 변경된 내용 가져오기 (다운로드)

 - 컴퓨터에서 파일을 관리하는 것 처럼 인터넷에서 관리할
   수 있도록 해주는 도구!

gitHub
 - 인터넷에서 여러 사람들하고 공유를 할 수 있도록 도와주는
   클라우드 기반 플랫폼

소스트리
 - git이나 github를 연결해서 그래픽으로 쉽게 사용할 수
   있도록 만들어진 프로그램!

 - 소스트리의 특징
   새폴더를 생성해서 git도구를 자동으로 받아오기
   init 까지는 된것 이다!

 - 깃허브에 올릴 때 apikey,app key
   중요한 key는 안올라갈 수 있도록 설정
   파일




 */