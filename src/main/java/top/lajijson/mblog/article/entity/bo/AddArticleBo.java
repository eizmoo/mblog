package top.lajijson.mblog.article.entity.bo;

import lombok.Data;
import top.lajijson.mblog.user.entity.bo.UserBo;
import top.lajijson.mblog.user.entity.bo.UserIdBo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 新增文章Bo
 *
 * @author liuwei
 */
@Data
public class AddArticleBo extends UserIdBo {

    @NotBlank
    private String title;

    @NotNull
    private Integer type;
}
