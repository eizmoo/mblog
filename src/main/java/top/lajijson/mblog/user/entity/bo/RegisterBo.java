package top.lajijson.mblog.user.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;
import top.lajijson.mblog.common.entity.IpBo;

import javax.validation.constraints.NotBlank;

/**
 * 注册入参
 *
 * @author liuwei
 */
@Data
@Accessors(chain = true)
public class RegisterBo extends IpBo {

    /**
     * 账户
     */
    @NotBlank
    private String account;

    /**
     * 密码
     */
    @NotBlank
    private String password;
}
