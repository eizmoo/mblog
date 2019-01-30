package top.lajijson.mblog.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.lajijson.mblog.article.entity.bo.AddArticleBo;
import top.lajijson.mblog.article.entity.bo.SaveArticleBo;
import top.lajijson.mblog.article.entity.bo.ListArticleBo;
import top.lajijson.mblog.article.service.ArticleService;
import top.lajijson.mblog.common.annotation.LoginUser;
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
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 请求文章列表
     *
     * @param listArticleBo
     * @return
     */
    @GetMapping("")
    public Result list(ListArticleBo listArticleBo) {
        ConvertUtil.validate(listArticleBo);

        return Result.successResult(articleService.list(listArticleBo));
    }

    /**
     * 新增文章
     *
     * @param json
     * @return
     */
    @PutMapping("")
    public Result add(@RequestBody String json, @LoginUser User user) {
        AddArticleBo addArticleBo = ConvertUtil.covertAndValidate(json, AddArticleBo.class);

        //设置当前登录的用户id
        addArticleBo.setUserId(user.getId());

        return articleService.add(addArticleBo);
    }

    /**
     * 保存文章
     * <p>
     * 编辑时，每次操作都会触发此接口
     * 该接口将进行两步操作：
     * 1、更新数据库article_info表记录
     * 2、更新article_content记录
     *
     * @param json
     * @return
     */
    @PostMapping("/{id}/")
    public Result save(@RequestBody String json, @LoginUser User user) {
        SaveArticleBo saveArticleBo = ConvertUtil.covertAndValidate(json, SaveArticleBo.class);

        return articleService.save(saveArticleBo);
    }


    /**
     * 发布项目
     *
     * @param json
     * @return
     */
    @PostMapping("/{id}/publish")
    public void publish(@RequestBody String json, @LoginUser User user) {
//        return articleService.publish();
    }


}
