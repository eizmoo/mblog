package top.lajijson.mblog.article.dao;

import org.springframework.stereotype.Component;
import top.lajijson.mblog.article.entity.ArticleType;
import top.lajijson.mblog.common.entity.Result;

import java.util.List;

@Component
public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);

    /**
     * 根据name查询type数量
     *
     * @param name
     * @return
     */
    int queryCountByName(String name);

    /**
     * 查找全部
     *
     * @return
     */
    List<ArticleType> queryAll();
}