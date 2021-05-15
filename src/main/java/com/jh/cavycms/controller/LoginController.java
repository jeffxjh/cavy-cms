package com.jh.cavycms.controller;

import com.jh.cavycms.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping
@Controller
public class LoginController {
    @GetMapping(value = {"/login", "/"})
    public ModelAndView tologin() {
        ModelAndView mv = new ModelAndView();
        SysUser sysUser = new SysUser();
        mv.addObject("SysUser", sysUser);
        mv.setViewName("login");
        return mv;
    }

    @GetMapping("/loginOut")
    public String  loginOut(HttpServletRequest request,HttpServletResponse response) {
        Cookie cookie = new Cookie("UserInfo",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:login";
    }

    @PostMapping(value = {"/toIndex"})
    public String toIndex(@ModelAttribute SysUser user, HttpServletRequest request, HttpServletResponse response) {
        Cookie userInfo = new Cookie("UserInfo", user.getName());
        response.addCookie(userInfo);
        return "redirect:index";
    }
}
