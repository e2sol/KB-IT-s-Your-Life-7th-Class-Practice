package org.scoula.ex03.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.ex03.dto.SampleDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Log4j2
@RequestMapping("/sample") // 공통 url을 /sample로 설정
public class SampleController {

    // /sample 경로에 대한 모든 요청 메서드에 대해 호출되는 basic() 메서드 작성
    @RequestMapping("") // @RequestMapping : 가장 기본이 되는 맵핑 어노테이션
    public void basic() {
        log.info("basic.......................");
    }

    // /sample/basic 경로의 GET, POST 요청에 호출되는 basicGet() 메서드 작성
    @RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
    public void basicGet() {
        log.info("basic get...................");
    }

    // /sample/basicOnlyGet 경로의 GET 요청에 호출되는 basicGet2() 메서드 작성
    @GetMapping("/basicOnlyGet")
    public void basicGet2() {
        log.info("basic get only get..........");
    }

    @RequestMapping("/ex04")
    public String ex04(SampleDTO dto, int page, Model model){
        log.info("dto : " + dto);
        log.info("page : " + page);

        // jsp에서 page에 접근하기 위해 model에 추가
        model.addAttribute("page", page);

        return "sample/ex04";
    }

    @GetMapping("/ex05")
    public void ex05() {
        log.info("/ex05......................");
    }
}
