package top.lajijson.mblog.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 时间日期工具类
 *
 * @author liuwei
 */
public class DateUtil {


    /**
     * 根据当前时间的获取文章标题
     *
     * @return
     */
    public static String nowDateString() {
        return LocalDateTime.now().toString();
    }
}
