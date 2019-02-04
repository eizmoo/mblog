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
     * 200
     *
     * @param result
     * @return
     */
    protected ResponseEntity<T> ok(T result) {
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 204
     *
     * @return
     */
    protected ResponseEntity<T> noContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
