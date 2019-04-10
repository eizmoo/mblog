package top.lajijson.mblog.common.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * 返回参数基本控制层
 *
 * @param <T>
 * @author liuwei
 */
@Component
public class BaseControllerResult<T> {

    /**
     * 200 请求成功
     *
     * @param result
     * @return
     */
    public ResponseEntity<T> ok(T result) {
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * 204 请求成功无返回值
     *
     * @return
     */
    public ResponseEntity<T> noContent() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 201 创建成功
     *
     * @return
     */
    public ResponseEntity<T> created() {
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<T> error(T result) {
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<T> error() {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
