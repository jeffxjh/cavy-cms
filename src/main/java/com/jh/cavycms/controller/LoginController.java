package com.jh.cavycms.controller;

import cn.hutool.captcha.CircleCaptcha;
import com.jh.cavycms.common.ResponseResult;
import com.jh.cavycms.common.StateCodeEnum;
import com.jh.cavycms.domain.SysUser;
import com.jh.cavycms.service.SysMenuService;
import com.jh.cavycms.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RequestMapping
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private CircleCaptcha captcha;

    @GetMapping(value = {"/toLogin"})
    public ModelAndView toLogin() {
        ModelAndView mv = new ModelAndView();
        SysUser sysUser = new SysUser();
        mv.addObject("SysUser", sysUser);
        mv.setViewName("login");
        return mv;
    }

    @GetMapping("/logout")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("UserInfo", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:toLogin";
    }

    @RequestMapping(value = {"/toIndex"})
    public ModelAndView toIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("menus", sysMenuService.queryList());
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping(value = {"/toDashboard"})
    public ModelAndView toDashboard(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dashboard");
        return mv;
    }

    // ???????????????
    @RequestMapping("/getVerifyCode")
    public void getKaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        captcha.createCode();
        //?????????????????????????????????????????????????????????????????????
        String text = captcha.getCode();
        //??????????????????????????????????????????boolean???
        logger.info("????????????????????????" + text);
        request.getSession().setAttribute("KAPTCHA", text);
        // ??????????????????
        // ??????????????????????????????==????????????????????????????????????
        OutputStream outputStream = response.getOutputStream();
        captcha.write(outputStream);
        outputStream.close();
    }


    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestBody UserVO entity, HttpServletRequest request, HttpServletResponse response) {
        ResponseResult result = null;
        try {
            // ???????????????
            if(!captcha.verify(entity.getVcode())) {
                result = ResponseResult.Factory.newInstance(Boolean.FALSE,
                        StateCodeEnum.USER_CODE_ERROR.getCode(), null,
                        StateCodeEnum.USER_CODE_ERROR.getDescription());
                return result;
            }





            Cookie cookie = new Cookie("UserInfo", entity.getName());
            cookie.setMaxAge(1 * 24 * 60 * 60); // 1?????????
            //?????????js?????????Cookie??????????????????????????????XSS?????????
            cookie.setHttpOnly(true);
            response.addCookie(cookie);

            boolean rememberMe = entity.isRememberMe();
            result = ResponseResult.Factory.newInstance(Boolean.TRUE,
                    StateCodeEnum.HTTP_SUCCESS.getCode(), entity,
                    StateCodeEnum.HTTP_SUCCESS.getDescription());
        }  catch (Exception e) {
            e.printStackTrace();
            // ?????????????????????
            result = ResponseResult.Factory.newInstance(Boolean.FALSE,
                    StateCodeEnum.USER_PASSWORD_ERROR.getCode(), null,
                    StateCodeEnum.USER_PASSWORD_ERROR.getDescription());
        }
        return result;
    }
}
