package top.lajijson.mblog.user.service;

import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.user.entity.bo.UserBo;

/**
 * 用户业务接口
 *
 * @author liuwei
 */
public interface UserService {
    /**
     * 注册
     *
     * @param userBo
     * @return
     */
    Result register(UserBo userBo);

    /**
     * 登录
     *
     * @param userBo
     * @return
     */
    Result login(UserBo userBo);
}
