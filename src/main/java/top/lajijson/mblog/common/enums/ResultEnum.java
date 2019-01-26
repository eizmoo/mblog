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
    FAIL(500,"未知异常"),

    /**
     * 账号已注册
     */
    ACCOUT_ALREADY_IN_USE(100001, "账号已注册"),

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
