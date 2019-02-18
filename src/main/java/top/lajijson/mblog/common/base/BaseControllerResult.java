package top.lajijson.mblog.common.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 返回参数基本控制层
 *
 * @param <T>
 * @author liuwei
 */
public class BaseControllerResult<T> {

    /**
     * 200 请求成功
     *
     * @param result
     * @return
     */
    protected ResponseEntity<T> ok(T result) {
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 204 请求成功无返回值
     *
     * @return
     */
    protected ResponseEntity<T> noContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 201 创建成功
     *
     * @return
     */
    protected ResponseEntity<T> created() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
