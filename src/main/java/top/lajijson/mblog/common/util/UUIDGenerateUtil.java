package top.lajijson.mblog.common.util;

import java.util.Random;

/**
 * 随机字符生成工具类
 *
 * @author liuwei
 */
public class UUIDGenerateUtil {

    /**
     * 生成源
     */
    private static final String origin = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";

    /**
     * 生成指定长度的随机字符
     *
     * @param length
     * @return
     */
    public static String uuidGen(Integer length) {
        StringBuffer builder = new StringBuffer();

        Random random = new Random();

        for (int i = 0; i < length; i++) {
            builder.append(origin.charAt(random.nextInt(63)));
        }
        return builder.toString();
    }

    /**
     * 生产8位
     * @return
     */
    public static String uuidGen() {
        return uuidGen(8);
    }


}
