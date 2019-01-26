package top.lajijson.mblog.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.enums.ResultEnum;
import top.lajijson.mblog.user.dao.UserMapper;
import top.lajijson.mblog.user.entity.User;
import top.lajijson.mblog.user.entity.bo.RegisterBo;
import top.lajijson.mblog.user.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户业务实现类
 *
 * @author liuwei
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     *
     * @param registerBo
     */
    @Override
    public Result register(RegisterBo registerBo) {
        //检查账户没有被注册
        if (checkRegister(registerBo.getAccount())) {
            //如果用户账号已注册
            return Result.failResult(ResultEnum.ACCOUT_ALREADY_IN_USE);
        }

        //初始化user对象
        //记录ip
        User user = new User().setAccount(registerBo.getAccount())
                .setIp(registerBo.getIp());
        //计算密码（二级盐：随机存入数据库+常量盐）

        //注册
        return Result.successResult();
    }

    /**
     * 检查账户的注册状态
     *
     * @param account
     * @return
     */
    private boolean checkRegister(String account) {
        Map<String, Object> param = new HashMap<>();
        param.put("account", account);
        return userMapper.queryCountByAccount(param) != 0;
    }
}
