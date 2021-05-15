package com.jh.cavycms.controller;

import com.jh.cavycms.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/user")
@Controller
public class SysUserController {
    @GetMapping(value = {"/toList"})
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        SysUser sysUser = new SysUser();
        mv.addObject("SysUser", sysUser);
        mv.setViewName("user/list");
        return mv;
    }

}
