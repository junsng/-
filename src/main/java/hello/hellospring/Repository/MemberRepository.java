package hello.hellospring.Repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long  id); //Optional : findById가 있는데, null처리 방식이 있음
    Optional<Member> findByName(String name);
    List<Member> findAll();

}

