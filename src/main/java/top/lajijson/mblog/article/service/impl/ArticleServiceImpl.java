package top.lajijson.mblog.article.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.lajijson.mblog.article.constant.ArticleEnum;
import top.lajijson.mblog.article.dao.ArticleContentMapper;
import top.lajijson.mblog.article.dao.ArticleInfoMapper;
import top.lajijson.mblog.article.entity.ArticleContentWithBLOBs;
import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.article.entity.bo.AddArticleBo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.entity.bo.SaveArticleBo;
import top.lajijson.mblog.article.service.ArticleService;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.util.DateUtil;

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
    public Result<List<ArticleInfo>> list(ListArticleBo listArticleBo) {


        return null;
    }

    /**
     * 新增文章
     *
     * @param addArticleBo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AddArticleBo addArticleBo) {
        ArticleInfo articleInfo = new ArticleInfo();

        articleInfo.setTitle(DateUtil.nowDateString());
        articleInfo.setArticleTypeId(addArticleBo.getType());
        //设置默认时间标题
        log.info("新增文章:{}", articleInfo);

        //新增文章
        articleInfoMapper.insertSelective(articleInfo);

        ArticleContentWithBLOBs articleContent = new ArticleContentWithBLOBs();
        articleContent.setArticleId(articleInfo.getId());

        //插入文章内容基本信息
        articleContentMapper.insertSelective(articleContent);
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

        //更新content
        articleContentMapper.updateByPrimaryKey(articleContentWithBLOBs);

        return Result.successResult();
    }

    /**
     * 发布
     *
     * @param id
     */
    @Override
    public void publish(Integer id) {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(id);
        //设为展示
        articleInfo.setStatus(ArticleEnum.Status.DISPLAY.getCode());

        //保存指定字段
        articleInfoMapper.updateByPrimaryKeySelective(articleInfo);
    }

    /**
     * 根据类型展示
     *
     * @param typeId
     * @return
     */
    @Override
    public Result listByType(Integer typeId) {
        return Result.successResult(articleInfoMapper.queryByType(typeId));
    }

    /**
     * 根据文章id获取文章html内容
     *
     * @param id
     * @return
     */
    @Override
    public Result htmlContent(Integer id) {
        return Result.successResult(articleContentMapper.queryHtml(id));
    }

    /**
     * 根据类型展示
     *
     * @param id
     * @return
     */
    @Override
    public Result originContent(Integer id) {
        return Result.successResult(articleContentMapper.queryOrigin(id));
    }

}
