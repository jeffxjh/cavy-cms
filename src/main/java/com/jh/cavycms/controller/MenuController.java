package com.jh.cavycms.controller;

import com.jh.cavycms.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/menu")
@Controller
public class MenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @GetMapping(value = {"/toList"})
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("menus", sysMenuService.queryList());
        mv.setViewName("user/list");
        return mv;
    }

}
