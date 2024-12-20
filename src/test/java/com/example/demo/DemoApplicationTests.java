package com.example.demo;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.demo.entity.Item;
import com.example.demo.entity.User;
import com.example.demo.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @DisplayName("encode 테스트")
    @Test()
    void passwordEncodeTest(){
        String pw = "pjy@@22";
        String encodedPw = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, pw.toCharArray());
        System.out.println("인코딩된 패스워드 : "+ encodedPw);
    }

    @DisplayName("password matches 테스트")
    @Test
    void passwordMatchTest(){
        String pw = "pjy@@22";
        String encodedPw = BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, pw.toCharArray());
        BCrypt.Result matchedPw = BCrypt.verifyer().verify(pw.toCharArray(), encodedPw);
        System.out.println("매치 결과는 : " + matchedPw.verified);
    }


}
