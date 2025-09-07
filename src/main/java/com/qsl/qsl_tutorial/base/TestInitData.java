package com.qsl.qsl_tutorial.base;

import com.qsl.qsl_tutorial.boundedContext.user.entity.SiteUser;
import com.qsl.qsl_tutorial.boundedContext.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;


//@Profile({"dev","test"}) // 개발환경과 테스트 환경에서만 실행되도록
// 이 클래스 안에 정의된 Bean들은 test 모드에서만 실행
//TestInitData : 테스트 데이터를 초기화 할 때 사용한다.
@Configuration
@Profile("test")
public class TestInitData {
    // CommandLineRunner : 앱 실행 직후 초기 데이터 세팅 및 초기화
    @Bean
    CommandLineRunner init(UserRepository userRepository){
        return args -> {
            //이 부분은 스프링부트 앱이 실행되고, 본격적으로 작동하기 전에 실행된다.
            SiteUser u1 = SiteUser.builder()
                    .username("user1")
                    .password("{noop}1234")
                    .email("user1@test.com")
                    .build();

            SiteUser u2 = SiteUser.builder()
                    .username("user2")
                    .password("{noop}1234")
                    .email("user2@test.com")
                    .build();

            List<SiteUser> siteUserList = userRepository.saveAll(Arrays.asList(u1, u2));

        };
    }
}
