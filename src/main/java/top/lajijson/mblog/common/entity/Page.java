package top.lajijson.mblog.common.entity;

import javax.validation.constraints.NotNull;

/**
 * 分页基本参数，可用于继承
 *
 * @author liuwei
 */
public class Page {

    /**
     * 页数
     */
    @NotNull
    private int page;
    /**
     * 页大小
     */
    @NotNull
    private int size;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

