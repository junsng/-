package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**
     * mapping을 했기때문에 기존에 만들었던 index.html은 무시
     * 먼저 요청이 오면  컨테이너 안에 관련 Controller를 먼저 찾고
     * 이후에 우선순위가 낮은 static은 나중에 호출함.(무시됨)
     * @return
     */
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
