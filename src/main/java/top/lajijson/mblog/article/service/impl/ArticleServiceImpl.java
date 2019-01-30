package top.lajijson.mblog.article.service.impl;

import org.springframework.stereotype.Service;
import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.article.entity.bo.AddArticleBo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.entity.bo.SaveArticleBo;
import top.lajijson.mblog.article.service.ArticleService;
import top.lajijson.mblog.common.entity.Result;

import java.util.List;

/**
 * 文章业务实现类
 *
 * @author liuwei
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    /**
     * 列表展示
     *
     * @param listArticleBo
     * @return
     */
    @Override
    public List<ArticleInfo> list(ListArticleBo listArticleBo) {


        return null;
    }

    @Override
    public Result add(AddArticleBo addArticleBo) {
        return null;
    }

    /**
     * 保存文章
     *
     * @param saveArticleBo
     * @return
     */
    @Override
    public Result save(SaveArticleBo saveArticleBo) {

        //更新info表
        //更新content表

        return null;
    }
}
