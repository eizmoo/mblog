package top.lajijson.mblog.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.lajijson.mblog.article.entity.bo.AddArticleBo;
import top.lajijson.mblog.article.entity.bo.SaveArticleBo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.service.ArticleService;
import top.lajijson.mblog.common.annotation.LoginUser;
import top.lajijson.mblog.common.base.BaseControllerResult;
import top.lajijson.mblog.common.entity.Result;
import top.lajijson.mblog.common.util.ConvertUtil;
import top.lajijson.mblog.user.entity.User;

/**
 * 文章控制器
 *
 * @author liuwei
 */
@RestController
@RequestMapping("/articles")
public class ArticleController extends BaseControllerResult<Result> {

    @Autowired
    private ArticleService articleService;

    /**
     * 请求文章列表
     *
     * @param listArticleBo
     * @return
     */
    @GetMapping("")
    public ResponseEntity<Result> list(ListArticleBo listArticleBo) {
        ConvertUtil.validate(listArticleBo);

        return ok(articleService.list(listArticleBo));
    }

    /**
     * 新增文章
     *
     * @param json
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Result> add(@RequestBody String json) {
        AddArticleBo addArticleBo = ConvertUtil.covertAndValidate(json, AddArticleBo.class);
        articleService.add(addArticleBo);
        return created();
    }

    /**
     * 保存文章
     * <p>
     * 编辑时，每次操作都会触发此接口
     * 更新article_content记录
     *
     * @param json
     * @return 200
     */
    @PutMapping("/{id}/")
    public ResponseEntity<Result> save(@RequestBody String json, @PathVariable Integer id) {
        SaveArticleBo saveArticleBo = ConvertUtil.covertAndValidate(json, SaveArticleBo.class);

        //设置当前登录的用户id
        saveArticleBo.setId(id);

        return ok(articleService.save(saveArticleBo));
    }


    /**
     * 发布项目
     *
     * @param id 文章id
     * @return 204
     */
    @PostMapping("/{id}/publish")
    public ResponseEntity<Result> publish(@PathVariable Integer id) {
        articleService.publish(id);
        return noContent();
    }


    /**
     * 展示指定类型下的文章
     *
     * @return
     */
    @GetMapping("/type/{id}")
    public ResponseEntity<Result> listByType(@PathVariable Integer id) {
        return ok(articleService.listByType(id));
    }

    /**
     * 指定文章html内容
     *
     * @return
     */
    @GetMapping("/{id}/html")
    public ResponseEntity<Result> htmlContent(@PathVariable Integer id) {
        return ok(articleService.htmlContent(id));
    }

    /**
     * 指定文章origin内容
     *
     * @return
     */
    @GetMapping("/{id}/origin")
    public ResponseEntity<Result> originContent(@PathVariable Integer id) {
        return ok(articleService.originContent(id));
    }

}
