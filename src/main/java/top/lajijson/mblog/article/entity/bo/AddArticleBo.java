package top.lajijson.mblog.article.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;
import top.lajijson.mblog.user.entity.bo.LoginUserBo;

import javax.validation.constraints.NotBlank;
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
