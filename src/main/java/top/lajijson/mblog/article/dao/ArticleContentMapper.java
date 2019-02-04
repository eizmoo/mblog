package top.lajijson.mblog.article.dao;

import org.springframework.stereotype.Component;
import top.lajijson.mblog.article.entity.ArticleContent;
import top.lajijson.mblog.article.entity.ArticleContentWithBLOBs;
import top.lajijson.mblog.common.enums.ResultEnum;

import java.util.List;

@Component
public interface ArticleContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContentWithBLOBs record);

    int insertSelective(ArticleContentWithBLOBs record);

    ArticleContentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleContentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleContentWithBLOBs record);

    int updateByPrimaryKey(ArticleContent record);

    /**
     * 查询制定文章的html
     * @param id
     * @return
     */
    List<ArticleContentWithBLOBs> queryHtml(Integer id);

    /**
     * 查询制定文章的origin
     * @param id
     * @return
     */
    List<ArticleContentWithBLOBs> queryOrigin(Integer id);
}