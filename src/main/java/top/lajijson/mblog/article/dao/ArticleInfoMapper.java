package top.lajijson.mblog.article.dao;

import org.springframework.stereotype.Component;
import top.lajijson.mblog.article.entity.ArticleInfo;
import top.lajijson.mblog.common.enums.ResultEnum;

import java.util.List;

@Component
public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);

    /**
     * 根据类型id返回文章list
     *
     * @param typeId
     * @return
     */
    List<ArticleInfo> queryByType(Integer typeId);
}