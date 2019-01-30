package top.lajijson.mblog.article.service;

import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.article.entity.bo.AddArticleBo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.entity.bo.SaveArticleBo;
import top.lajijson.mblog.common.entity.Result;

import java.util.List;

/**
 * 文章业务处理接口
 *
 * @author liuwei
 */
public interface ArticleService {

    /**
     * 列表展示
     *
     * @param listArticleBo
     * @return
     */
    List<ArticleInfo> list(ListArticleBo listArticleBo);

    /**
     * 新增文章
     *
     * @param addArticleBo
     * @return
     */
    Result add(AddArticleBo addArticleBo);

    /**
     * 保存文章
     *
     * @param saveArticleBo
     * @return
     */
    Result save(SaveArticleBo saveArticleBo);

}
