package top.lajijson.mblog.article.entity;

import java.util.Date;

public class ArticleInfo {
    private Integer id;

    private String title;

    private Integer articleTypeId;

    private Integer readVolume;

    private Integer commentVolume;

    private String synopsis;

    private String coverImg;

    private Integer status;

    private Integer sort;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public Integer getReadVolume() {
        return readVolume;
    }

    public void setReadVolume(Integer readVolume) {
        this.readVolume = readVolume;
    }

    public Integer getCommentVolume() {
        return commentVolume;
    }

    public void setCommentVolume(Integer commentVolume) {
        this.commentVolume = commentVolume;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis == null ? null : synopsis.trim();
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg == null ? null : coverImg.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}