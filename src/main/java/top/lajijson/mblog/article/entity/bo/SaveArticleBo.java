package top.lajijson.mblog.article.entity.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 保存文章bo
 *
 * @author liuwei
 */
@Data
public class SaveArticleBo {

    /**
     * 文章内容
     */
    @NotBlank
    private String content;

    /**
     * 文章id
     */
    @NotNull
    private Integer id;


}
