package top.lajijson.mblog.article.service;

import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;

import java.util.List;

/**
 * 文章业务处理接口
 */
public interface ArticleService {

    /**
     * 列表展示
     *
     * @param listArticleBo
     * @return
     */
    List<ArticleInfo> list(ListArticleBo listArticleBo);
}
