package top.lajijson.mblog.article.service;

import top.lajijson.mblog.article.entity.bo.AddArticleTypeBo;
import top.lajijson.mblog.common.entity.Result;

/**
 * 文章类型服务接口
 */
public interface ArticleTypeService {


    /**
     * 新增
     *
     * @param addArticleTypeBo
     * @return
     */
    Result add(AddArticleTypeBo addArticleTypeBo);

    /**
     * 获取type列表
     *
     * @return
     */
    Result list();
}
