package top.lajijson.mblog.article.entity.bo;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * 新增文章Bo
 *
 * @author liuwei
 */
@Data
public class AddArticleBo {
    @NotNull
    private Integer type;
}
