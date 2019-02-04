package top.lajijson.mblog.article.entity.bo;

import lombok.Data;
import lombok.experimental.Accessors;
import top.lajijson.mblog.user.entity.bo.LoginUserBo;
import top.lajijson.mblog.user.entity.bo.UserBo;

import javax.validation.constraints.NotBlank;

/**
 * 新增文章类型bo
 *
 * @author liuwei
 */
@Data
@Accessors(chain = true)
public class AddArticleTypeBo {

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
