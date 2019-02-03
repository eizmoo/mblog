package top.lajijson.mblog.article.entity.bo;

import lombok.Data;
import top.lajijson.mblog.user.entity.bo.LoginUserBo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 新增文章Bo
 *
 * @author liuwei
 */
@Data
public class AddArticleBoLogin extends LoginUserBo {

    @NotBlank
    private String title;

    @NotNull
    private Integer type;
}
