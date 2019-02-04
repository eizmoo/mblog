package top.lajijson.mblog.article.service;

import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.article.entity.bo.AddArticleBo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.entity.bo.SaveArticleBo;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.user.entity.User;

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
    Result<List<ArticleInfo>> list(ListArticleBo listArticleBo);

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

    /**
     * 发布文章
     *
     * @param id
     */
    void publish(Integer id);

    /**
     * 根据类型展示文章
     *
     * @param typeId
     * @return
     */
    Result listByType(Integer typeId);

    /**
     * 获取指定文章id的html内容
     * @param id
     * @return
     */
    Result htmlContent(Integer id);

    /**
     * 获取指定文章id的origin内容
     *
     * @param id
     * @return
     */
    Result originContent(Integer id);
}
