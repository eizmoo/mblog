package top.lajijson.mblog.common.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lajijson.mblog.common.entity.Result;

/**
 * 统一异常处理
 *
 * @author liuwei
 */
@ControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        log.error("抓到异常：\n{}", e);

        //返回 未知异常
        return Result.failResult();
    }

}
