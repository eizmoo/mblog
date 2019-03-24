package top.lajijson.mblog.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * aop日志,打印出参
 *
 * @author liuwei
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {

    /**
     * 切入位置排除basecontroller执行打印日志
     */
    @Pointcut("within(top.lajijson.mblog.*.controller.*)")
    public void myPointcut() {
    }

    /**
     * 打印反参
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "myPointcut()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

//        log.info("接口返回结果 ==>  class:[" + className + "], method:[" + methodName + "], paramters:[" + jsonResult + "]");
        log.info("----返回结果{}", result);
    }
}
