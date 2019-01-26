package top.lajijson.mblog.user.controller;

import ch.qos.logback.core.pattern.ConverterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.util.ConvertUtil;
import top.lajijson.mblog.common.util.IpUtil;
import top.lajijson.mblog.user.entity.bo.RegisterBo;
import top.lajijson.mblog.user.service.UserService;

import javax.servlet.http.HttpServletRequest;


/**
 * 用户控制类
 *
 * @author liuwei
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public Result register(@RequestBody String json, HttpServletRequest request) {
        RegisterBo registerBo = ConvertUtil.covertAndValidate(json, RegisterBo.class);

        //设置ip
        registerBo.setIp(IpUtil.getRealIp(request));

        return userService.register(registerBo);
    }

    @RequestMapping("/login")
    public Result login() {
        return Result.successResult();
    }

}
