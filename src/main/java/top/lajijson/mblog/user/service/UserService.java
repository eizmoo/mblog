package top.lajijson.mblog.user.service;

import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.user.entity.bo.RegisterBo;

/**
 * 用户业务接口
 * @author liuwei
 */
public interface UserService {
    /**
     * 注册
     * @param registerBo
     *
     */
    Result register(RegisterBo registerBo);
}
