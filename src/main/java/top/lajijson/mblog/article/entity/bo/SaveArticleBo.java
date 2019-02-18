package top.lajijson.mblog.article.entity.bo;

import lombok.Data;
import top.lajijson.mblog.user.entity.bo.LoginUserBo;

import javax.validation.constraints.NotBlank;

/**
 * 保存文章bo
 *
 * @author liuwei
 */
@Data
public class SaveArticleBo extends LoginUserBo {

    /**
     * 文章内容
     */
    @NotBlank
    private String content;

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String title;
}
