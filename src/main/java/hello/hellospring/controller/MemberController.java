package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MemberController {

    /**
     * 1. 생성자주입 :의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.
     * 이렇게 사용하면 매번 객체를 생성할 필요가 없다.
     * 스프링 컨테이너에 등록을 하면 하나만 등록이 됨
     */
    //private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
/**
 * 2. 필드주입으로 바로 가능함. 하지만, 생성하고 나서, 중간에 수정이 불가하기도 함.
 */
    //@Autowired private MemberService memberService;

/**
 * 3. setter 주입
 *
 */
    //@Autowired
    //public void setMemberService(MemberService memberService){
    //    this.memberService = memberService
    //}


    @GetMapping("/members/new")
    public String createFrom(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model ){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
    return "members/memberList";
    }

}
