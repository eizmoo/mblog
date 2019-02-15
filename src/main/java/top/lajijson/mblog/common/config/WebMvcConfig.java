package top.lajijson.mblog.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * webmvc配置
 *
 * @author liuwei
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private SpringMvcWebInterceptor springMvcWebInterceptor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userResolver());
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(springMvcWebInterceptor)
                .addPathPatterns("/**");
    }

    @Bean
    public LoginUserResolver userResolver() {
        return new LoginUserResolver();
    }
}




