package top.lajijson.mblog.article.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lajijson.mblog.article.dao.ArticleContentMapper;
import top.lajijson.mblog.article.dao.ArticleInfoMapper;
import top.lajijson.mblog.article.entity.ArticleContentWithBLOBs;
import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.article.entity.bo.AddArticleBoLogin;
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
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Autowired
    private ArticleContentMapper articleContentMapper;

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

    /**
     * 新增文章
     *
     * @param addArticleBo
     * @return
     */
    @Override
    public Result add(AddArticleBoLogin addArticleBo) {
        ArticleInfo articleInfo = new ArticleInfo();
        BeanUtils.copyProperties(addArticleBo, articleInfo);

        log.info("新增文章:{}", articleInfo);

        articleInfoMapper.insertSelective(articleInfo);

        return Result.successResult();
    }

    /**
     * 保存文章
     *
     * @param saveArticleBo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result save(SaveArticleBo saveArticleBo) {
        ArticleContentWithBLOBs articleContentWithBLOBs = new ArticleContentWithBLOBs();
        articleContentWithBLOBs.setOrigin(saveArticleBo.getContent());
        articleContentWithBLOBs.setId(saveArticleBo.getId());

        //更新content表
        articleContentMapper.updateByPrimaryKey(articleContentWithBLOBs);

        return Result.successResult();
    }
}
