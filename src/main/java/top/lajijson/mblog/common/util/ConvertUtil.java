package top.lajijson.mblog.common.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import top.lajijson.mblog.common.exception.ParamCheckException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * 类型转换类
 *
 * @author liuwei
 */
@Slf4j
public class ConvertUtil {

    /**
     * 使用hibernate注解进行验证
     */
    private static Validator validator = Validation.byProvider(HibernateValidator.class)
            .configure()
            .failFast(true)
            .buildValidatorFactory()
            .getValidator();

    /**
     * 将jsonstring转成对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T covert(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 校验对象
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> void validate(T t) {
        if (t == null) {
            throw new ParamCheckException("请求参数不得为空");
        }
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        if (constraintViolations.size() != 0) {
            StringBuilder field = new StringBuilder();
            constraintViolations.forEach(v -> field.append(v.getMessage()).append('&'));
            throw new ParamCheckException("参数有误：" + field.toString());
        }
    }

    /**
     * 转换、校验对象
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T covertAndValidate(String json, Class<T> clazz) {
        T t = covert(json, clazz);
        validate(t);
        log.info("入参为：{}，转换后的对象参数为：{}", json, t);
        return t;
    }

}
