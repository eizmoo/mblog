package top.lajijson.mblog.common.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import top.lajijson.mblog.access.dao.AccessLogMapper;
import top.lajijson.mblog.access.entity.AccessLog;
import top.lajijson.mblog.common.annotation.Auth;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.enums.ResultEnum;
import top.lajijson.mblog.common.util.IpUtil;
import top.lajijson.mblog.common.util.RedissonUtil;
import top.lajijson.mblog.common.util.ResponseUtil;
import top.lajijson.mblog.user.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器配置
 *
 * @author liuwei
 */
@Slf4j
@Component
public class SpringMvcWebInterceptor implements HandlerInterceptor {

    @Autowired
    private AccessLogMapper accessLogMapper;

    /**
     * 处理请求之前调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 访问的uri
        String uri = request.getRequestURI();
        // 访问的ip
        String ip = IpUtil.getRealIp(request);

        log.info("----访问页面{} {}----访问ip{}", uri, request.getMethod(), ip);

        //记录访问ip
        AccessLog accessLog = new AccessLog();
        accessLog.setIp(ip);

        Auth auth;
        //判断方法是否需要鉴权
        if (handler instanceof HandlerMethod) {
            auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
        } else {
            return true;
        }

        //如果存在auth注解，说明方法需要鉴权
        if (auth == null) {
            return true;
        }

        //鉴权
        String token = request.getHeader("token");
        //token为空，返回登录失效
        if (StringUtils.isBlank(token)) {
            ResponseUtil.returnJson(response, Result.failResult(ResultEnum.LOGIN_STATUS_INVALID));
            log.info("登录鉴权失败:: uri:{} ip:{} ", uri, ip);
            return false;
        } else {
            //获取redis中的user信息
            String user = RedissonUtil.getString(token);
            if (StringUtils.isBlank(user)) {
                ResponseUtil.returnJson(response, Result.failResult(ResultEnum.LOGIN_STATUS_INVALID));
                log.info("登录鉴权失败:: token:{} uri:{} ip:{} ", token, uri, ip);
                return false;
            }
            //记录当前登录的用户id
            accessLog.setId(JSON.parseObject(user, User.class).getId());
        }

        //插入访问记录
        // TODO 一天记录一次访问记录
//        accessLogMapper.insertSelective(accessLog);

        return true;
    }

}
