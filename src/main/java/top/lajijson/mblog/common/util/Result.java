package top.lajijson.mblog.common.util;

import lombok.Data;
import lombok.experimental.Accessors;
import top.lajijson.mblog.common.constant.enums.ResultEnum;

/**
 * 接口统一返回类
 *
 * @param <T> 返回数据类型
 * @author liuwei
 */

@Data
@Accessors(chain = true)
public class Result<T> {

    /**
     * 请求成功状态
     */
    boolean success;
    /**
     * 返回码
     */
    int code;
    /**
     * 返回消息
     */
    String message;
    /**
     * 数据
     */
    T data;

    private Result() {
    }

    private static Result enumResult(ResultEnum resultEnum) {
        return new Result()
                .setCode(resultEnum.getCode())
                .setMessage(resultEnum.getMsg());
    }

    /**
     * 成功，无返回结果
     *
     * @param resultEnum
     * @return
     */
    public static Result successResult(ResultEnum resultEnum) {
        return enumResult(resultEnum);
    }

    /**
     * 成功，有返回结果
     *
     * @param resultEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result successResult(ResultEnum resultEnum, T data) {
        return new Result<T>()
                .setCode(resultEnum.getCode())
                .setMessage(resultEnum.getMsg())
                .setData(data);
    }

    /**
     * 成功，有结果，默认返回code和参数
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result successResult(T data) {
        return successResult(ResultEnum.SUCCESS, data);
    }

    /**
     * 失败
     *
     * @param resultEnum
     * @return
     */
    public static Result failResult(ResultEnum resultEnum) {
        return enumResult(resultEnum);
    }

    /**
     * 失败，默认返回值
     *
     * @return
     */
    public static Result failResult() {
        return failResult(ResultEnum.FAIL);
    }
}
