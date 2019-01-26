package top.lajijson.mblog.common.entity;

import top.lajijson.mblog.common.enums.ResultEnum;

/**
 * 接口统一返回类
 *
 * @param <T> 返回数据类型
 * @author liuwei
 */

public class Result<T> {

    /**
     * 请求成功状态
     */
    private boolean success;
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回消息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    private Result() {
    }

    /**
     * 无data构造参数
     *
     * @param resultEnum
     * @param success
     */
    private Result(ResultEnum resultEnum, boolean success) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
        this.success = success;
    }

    /**
     * 有data构造参数
     *
     * @param resultEnum
     * @param success
     * @param data
     */
    private Result(ResultEnum resultEnum, boolean success, T data) {
        this(resultEnum, success);
        this.data = data;
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
        return new Result<>(resultEnum, true, data);
    }

    /**
     * 成功，无返回结果，自定义code和msg
     *
     * @param resultEnum
     * @return
     */
    public static Result successResult(ResultEnum resultEnum) {
        return new Result(resultEnum, true);
    }


    /**
     * 成功，无结果，返回默认code和msg
     *
     * @return
     */
    public static Result successResult() {
        return new Result(ResultEnum.SUCCESS, true);
    }

    /**
     * 成功，有结果，默认返回code和参数
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result successResult(T data) {
        return new Result<>(ResultEnum.SUCCESS, true, data);
    }

    /**
     * 失败
     *
     * @param resultEnum
     * @return
     */
    public static Result failResult(ResultEnum resultEnum) {
        return new Result(resultEnum, false);
    }

    /**
     * 失败，默认返回值
     *
     * @return
     */
    public static Result failResult() {
        return new Result(ResultEnum.FAIL, false);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
