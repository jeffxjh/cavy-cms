//package com.jh.cavycms.config;
//
//import cn.hutool.captcha.CaptchaUtil;
//import cn.hutool.captcha.CircleCaptcha;
//import cn.hutool.captcha.generator.MathGenerator;
//import com.jh.cavycms.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.servlet.config.annotation.*;
//

////会导致默认mvc规则失效
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//    /**
//     * 配置静态访问资源
//     *
//     * @param registry
//     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
//    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("").setViewName("forward:/toIndex");
//        registry.addViewController("/").setViewName("forward:/toLogin"); //访问路径时/时，跳转到登录页面
//        registry.addViewController("/index").setViewName("forward:/toIndex");  //访问路径是/index时，跳转到index首页
//        registry.addViewController("/error").setViewName("error");  //访问路径是/error时，跳转到error首页
//
//        registry.addViewController("/favicon.ico").setViewName("forward:static/resource/icon/favicon.ico");
//
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowCredentials(true)
//                .allowedMethods("GET", "POST", "DELETE", "PUT")
//                .maxAge(3600);
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login", "/toLogin", "/logout", "/getVerifyCode", "/static/**");
//    }
//
//    @Bean("captcha")
//    @Scope("singleton")
//    public CircleCaptcha captcha() {
//        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
//        // 自定义验证码内容为四则运算方式
//        captcha.setGenerator(new MathGenerator(1));
//        return captcha;
//    }
//}