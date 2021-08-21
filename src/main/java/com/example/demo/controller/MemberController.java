package com.example.demo.controller;

import com.example.demo.dto.MemberDto;
import com.example.demo.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@AllArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/user/signup")
    public String dispSignup(){
        return "member/signup";
    }

    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto){
        memberService.joinUser(memberDto);
        return "redirect:/user/login";
    }

    @GetMapping("/user/login")
    public String displogin(){
        return "member/login";
    }

    @GetMapping("/user/login/result")
    public String dispLoginResult(){
        return "member/loginSuccess";
    }

    @GetMapping("/user/logout/result")
    public String dispLogoutResult(){
        return "member/logoutSuccess";
    }


}