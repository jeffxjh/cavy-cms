package com.jh.cavycms.controller;

import com.github.pagehelper.PageInfo;
import com.jh.cavycms.common.RequestParams;
import com.jh.cavycms.domain.SysUser;
import com.jh.cavycms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping(value = {"/toList"})
    public ModelAndView list(RequestParams requestParams) {
        ModelAndView mv = new ModelAndView();
        PageInfo<SysUser> pageInfo = sysUserService.listByPage(requestParams);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("user/list");
        return mv;
    }

    @GetMapping(value = {"/toAdd"})
    public ModelAndView toAdd() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/add");
        return mv;
    }

    @PostMapping(value = {"/add"})
    public String add(@ModelAttribute SysUser sysUser) {
        sysUserService.insert(sysUser);
        return "redirect:/user/toList";
    }

}
