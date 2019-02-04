package top.lajijson.mblog.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.lajijson.mblog.article.entity.bo.AddArticleTypeBo;
import top.lajijson.mblog.article.service.ArticleTypeService;
import top.lajijson.mblog.common.annotation.LoginUser;
import top.lajijson.mblog.common.base.BaseControllerResult;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.util.ConvertUtil;
import top.lajijson.mblog.user.entity.User;

/**
 * 文章类型
 *
 * @author liuwei
 */
@RestController
@RequestMapping("/articles-type")
public class ArticleTypeController extends BaseControllerResult<Result> {

    @Autowired
    private ArticleTypeService articleTypeService;

    /**
     * 展示所有type
     *
     * @return 200
     */
    @GetMapping()
    public ResponseEntity<Result> list() {
        return ok(articleTypeService.list());
    }

    /**
     * 新增
     *
     * @return 204
     */
    @PostMapping
    public ResponseEntity<Result> add(@RequestBody String json) {
        AddArticleTypeBo addArticleTypeBo = ConvertUtil.covertAndValidate(json, AddArticleTypeBo.class);
        //新增类型
        return ok(articleTypeService.add(addArticleTypeBo));
    }


}
