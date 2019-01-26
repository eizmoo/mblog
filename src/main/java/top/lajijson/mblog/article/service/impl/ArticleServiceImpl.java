package top.lajijson.mblog.article.service.impl;

import org.springframework.stereotype.Service;
import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.service.ArticleService;

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
}
