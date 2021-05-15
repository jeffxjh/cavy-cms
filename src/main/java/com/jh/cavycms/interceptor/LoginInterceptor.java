package com.jh.cavycms.interceptor;

import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截之前调用（进入Controller之前）
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("UserInfo")) {
                    if (StrUtil.isNotBlank(cookie.getValue())) {
                        //表示已登录、不再拦截
                        //验证信息是否合法，还可以存入redis
                        log.info("已登录,已放行");
                        return true;
                    }
                }
            }
        }
        request.setAttribute("msg", "尚未进行登录");
        log.info("未登录、已拦截");
        response.sendRedirect("/cavy/login");
        return false;

    }

    /**
     * 调用方法之后，视图渲染之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 完成拦截之后，用于清理资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
