package top.lajijson.mblog.article.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.lajijson.mblog.article.dao.ArticleTypeMapper;
import top.lajijson.mblog.article.entity.ArticleType;
import top.lajijson.mblog.article.entity.bo.AddArticleTypeBo;
import top.lajijson.mblog.article.service.ArticleTypeService;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.enums.ResultEnum;

import java.util.List;

/**
 * 文章类型服务实现类
 *
 * @author liuwei
 */
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {
    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    /**
     * 新增
     *
     * @param addArticleTypeBo
     * @return
     */
    @Override
    public Result add(AddArticleTypeBo addArticleTypeBo) {
        /**
         * 如果已存在同名类型
         */
        if (articleTypeMapper.queryCountByName(addArticleTypeBo.getName()) > 0) {
            return Result.failResult(ResultEnum.SAME_NAME_TYPE);
        }

        ArticleType articleType = new ArticleType();
        BeanUtils.copyProperties(addArticleTypeBo, articleType);

        articleTypeMapper.insertSelective(articleType);

        return Result.successResult();
    }

    /**
     * 查找全部
     *
     * @return
     */
    @Override
    public Result list() {
        return Result.successResult(articleTypeMapper.queryAll());
    }
}
