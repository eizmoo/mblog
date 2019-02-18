package top.lajijson.mblog.common.config;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import top.lajijson.mblog.common.annotation.LoginUser;
import top.lajijson.mblog.common.util.RedissonUtil;
import top.lajijson.mblog.user.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 注入用户信息
 *
 * @author liuwei
 */
public class LoginUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        if (methodParameter.getParameterType().equals(User.class)) {
            //获取header中的token
            String token = nativeWebRequest.getNativeRequest(HttpServletRequest.class).getHeader("Authorization");
            //如果token为空，返回null
            if (StringUtils.isEmpty(token) || StringUtils.isEmpty(token.trim())) {
                return null;
            } else {
                //返回用户信息
                String user = RedissonUtil.getString(token);
                return JSON.parseObject(user, User.class);
            }

        }
        return null;
    }
}
