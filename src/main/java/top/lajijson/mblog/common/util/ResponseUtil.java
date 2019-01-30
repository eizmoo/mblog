package top.lajijson.mblog.common.util;

import com.alibaba.fastjson.JSON;
import top.lajijson.mblog.common.entity.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 响应工具类
 *
 * @author liuwei
 */
public class ResponseUtil {

    /**
     * response输出流写出数据
     */
    public static void returnJson(HttpServletResponse response, Result result) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Charset", "UTF-8");
        //解决HTML5+js跨域无法访问问题
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(JSON.toJSONString(result));
        response.getWriter().flush();
        response.getWriter().close();
    }

}
