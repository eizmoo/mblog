package top.lajijson.mblog.article.constant;

import lombok.Getter;

/**
 * 文章枚举
 *
 * @author liuwei
 */
public class ArticleEnum {

    /**
     * 状态枚举
     */
    @Getter
    public enum Status {
        EDIT(0, "编辑中"),
        DISPLAY(1, "展示"),
        CONCEAL(2, "隐藏"),
        RECYCLE(3, "回收");

        private int code;
        private String desc;

        Status(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }


}
