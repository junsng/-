package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  /*  @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello";
    }*/

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";

    }
//문자가 그대로 클라이언트에 전달된다. @ResponseBody를 사용하면 뷰 리졸버를 사용하지 않음.
    //대신에 HTTP의 BODY에 문자 내용을 직접 반환(HTML BODY TAG가 아님)
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

//api방식으로 @ResponseBody를 사용하고, 객체를 보내면 JSON 으로 변환해줌
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }


}
