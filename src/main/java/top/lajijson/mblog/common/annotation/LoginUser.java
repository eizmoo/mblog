package top.lajijson.mblog.common.annotation;

import java.lang.annotation.*;

/**
 * 登录用户注解
 *
 * @author liuwei
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginUser {
}
