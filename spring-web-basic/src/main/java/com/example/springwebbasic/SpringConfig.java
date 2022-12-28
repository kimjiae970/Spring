package com.example.springwebbasic;

import com.example.springwebbasic.repository.JdbcMemberRepository;
import com.example.springwebbasic.repository.MemberRepository;
import com.example.springwebbasic.repository.MemoryMemberRepository;
import com.example.springwebbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//자바 코드로 직접 스프링 빈 등록하는 방법
@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
