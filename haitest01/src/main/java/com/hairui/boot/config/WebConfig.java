package com.hairui.boot.config;
import com.hairui.boot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * 注册登录页的拦截器
     * 实现WebMvcConfigurer中的增加拦截器的方法
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //拦截所有资源
                //配置/*可以放行静态资源
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui/index.html")
                //放行登录页和静态资源，放行静态资源要以/xx/**的格式
                .excludePathPatterns("/","/admin/login","/css/**","/font/**","/images/**",
                        "/js/**","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"
                ,"/error","/swagger-ui/**");
    }
}
