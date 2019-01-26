package top.lajijson.mblog.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.service.ArticleService;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.util.ConvertUtil;

/**
 * 文章控制器
 *
 * @author liuwei
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 请求文章列表
     *
     * @param json
     * @return
     */
    @GetMapping("")
    public Result list(@RequestBody String json) {
        ListArticleBo listArticleBo = ConvertUtil.covertAndValidate(json, ListArticleBo.class);

        return Result.successResult(articleService.list(listArticleBo));
    }

    /**
     * 新增
     *
     * @return
     */
    @PutMapping("")
    public Result addArticle() {
        return Result.successResult();
    }


}
