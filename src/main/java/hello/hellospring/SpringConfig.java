package hello.hellospring;

import hello.hellospring.Repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

//2. 자바코드로 직접 스프링 빈을 등록하는 방법.
@Configuration
public class SpringConfig {

    //@PersistenceContext
    private EntityManager em;
//    private DataSource dataSource;
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    //Contoller - Service - Repository로 필요로 하기때문에 Autowired로 ComponentScan으로 사용가능하지만,
    //직접 빈을 생성하여 주입가능하다
    //MemberService에서 Repository가 필요하기때문에 생성해주고, 서비스에서 호출하도록 함
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }

}
