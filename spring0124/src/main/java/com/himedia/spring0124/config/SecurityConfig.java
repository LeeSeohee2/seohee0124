package com.himedia.spring0124.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //시큐리티 설정을 하는 클래스로 spring컨테이너에서
                // 관리한다.
public class SecurityConfig {

    // 회원가입하는 사람들은 비밀번호를 무조건 암호화해야된다.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // 시큐리티 필터 체인을 설정
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
                                         throws Exception {
        // 모든 포트에서 들어오는 요청을 허용한다!
        // 정적파일인 static폴더 안에 경로도 모두 막아버린다.
        // 그래서 이미지가 안 올란다.
        // 정적파일들의 경로도 다~ 허용하도록 설정
        // /images 현재폴더만 허용
        // /images/폴더들이 있을 경우 /images/** 해야
        // 하위 폴더들도 포함이 된다.
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers("/",
                                      "/css/**",
                                      "/images/**",
                                        "/product/**",
                                        "/js/**").permitAll()
                        .anyRequest().denyAll()
                );

        return http.build();
    }

}

// / 경로만 실행 들어갈 수 있도록 허용을 해서
//   정적파일들의 경로도 다 막혔다!