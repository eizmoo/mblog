package top.lajijson.mblog.article.dao;

import org.springframework.stereotype.Component;
import top.lajijson.mblog.article.entity.ArticleContent;
import top.lajijson.mblog.article.entity.ArticleContentWithBLOBs;

@Component
public interface ArticleContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleContentWithBLOBs record);

    int insertSelective(ArticleContentWithBLOBs record);

    ArticleContentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleContentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticleContentWithBLOBs record);

    int updateByPrimaryKey(ArticleContent record);
}