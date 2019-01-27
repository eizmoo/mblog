package top.lajijson.mblog.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import top.lajijson.mblog.common.constant.CommonConstant;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.enums.ResultEnum;
import top.lajijson.mblog.common.util.UUIDGenerateUtil;
import top.lajijson.mblog.user.dao.UserMapper;
import top.lajijson.mblog.user.entity.User;
import top.lajijson.mblog.user.entity.bo.UserBo;
import top.lajijson.mblog.user.service.UserService;

import javax.validation.constraints.NotBlank;
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
     * @param userBo
     */
    @Override
    public Result register(UserBo userBo) {
        //检查账户没有被注册
        if (checkRegister(userBo.getAccount())) {
            //如果用户账号已注册
            return Result.failResult(ResultEnum.ACCOUNT_ALREADY_IN_USE);
        }

        //此次注册的盐
        String salt = UUIDGenerateUtil.genCharacter();

        //初始化user对象
        User user = new User().setAccount(userBo.getAccount())
                //记录ip
                .setIp(userBo.getIp())
                //保存salt
                .setSalt(salt)
                //计算密码（二级盐：常量+随机）
                .setPassword(calculatePassword(userBo.getPassword(), salt))
                //设置默认昵称
                .setNickName(genNickName());

        userMapper.insertSelective(user);

        //注册
        return Result.successResult();
    }

    /**
     * 登录
     *
     * @param userBo
     * @return
     */
    @Override
    public Result login(UserBo userBo) {
        //根据account获取用户记录
        Map<String, Object> param = new HashMap<>(2);
        param.put("account", userBo.getAccount());
        User user = userMapper.queryByAccount(param);

        //如果存在该account，计算此account的密码与记录比较
        if (user != null) {
            String password = calculatePassword(userBo.getPassword(), user.getSalt());
            if (password.equalsIgnoreCase(user.getPassword())) {
                //登录成功
                String key = UUIDGenerateUtil.genUUID();
                //TODO 保存信息到redis中，uuid为key，用户信息为value
                return Result.successResult(key);
            }
        }

        //不存在该账户或者密码不正确
        return Result.failResult(ResultEnum.ACC_OR_PWD_ERROR);
    }

    /**
     * 根据盐计算密码
     *
     * @param password
     * @param salt
     * @return
     */
    private String calculatePassword(@NotBlank String password, String salt) {
        //一次加密，密码+系统内常量定义salt
        String once = DigestUtils.md5DigestAsHex((password + CommonConstant.REGISTER_SALT).getBytes());
        //二次加密，一次加密结果+随机salt
        String twice = DigestUtils.md5DigestAsHex((once + salt).getBytes());
        return twice;
    }

    /**
     * 默认昵称
     *
     * @return
     */
    private String genNickName() {
        return "u_" + UUIDGenerateUtil.genCharacter(10);
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
