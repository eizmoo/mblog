package top.lajijson.mblog.article.dao;

import top.lajijson.mblog.article.entity.ArticleInfo;

public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);
}