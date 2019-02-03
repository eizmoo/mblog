package top.lajijson.mblog.common.enums;

/**
 * 返回结果枚举类
 *
 * @author liuwei
 */
public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "访问成功"),

    /**
     * 未知异常
     */
    FAIL(500, "未知异常"),

    /**
     * 账号已注册
     */
    ACCOUNT_ALREADY_IN_USE(100001, "账号已注册"),

    /**
     * 账号或密码错误
     */
    ACC_OR_PWD_ERROR(100002, "账号或密码错误"),

    /**
     * 未登录或登录失效
     */
    LOGIN_STATUS_INVALID(100003, "未登录或登录失效"),

    ;

    int code;
    String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
