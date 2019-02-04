package top.lajijson.mblog.article.dao;

import org.springframework.stereotype.Component;
import top.lajijson.mblog.article.entity.ArticleTag;

@Component
public interface ArticleTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    ArticleTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);
}