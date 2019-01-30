package top.lajijson.mblog.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.util.ConvertUtil;
import top.lajijson.mblog.common.util.IpUtil;
import top.lajijson.mblog.common.util.RedissonUtil;
import top.lajijson.mblog.user.dao.UserMapper;
import top.lajijson.mblog.user.entity.bo.UserBo;
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

    /**
     * 注册
     *
     * @param json
     * @param request
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody String json, HttpServletRequest request) {
        UserBo userBo = ConvertUtil.covertAndValidate(json, UserBo.class);

        //设置ip
        userBo.setIp(IpUtil.getRealIp(request));

        return userService.register(userBo);
    }

    /**
     * 登录
     *
     * @param json
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody String json) {
        UserBo userBo = ConvertUtil.covertAndValidate(json, UserBo.class);

        return userService.login(userBo);
    }

}
