package top.lajijson.mblog.article.entity;

public class ArticleContentWithBLOBs extends ArticleContent {
    private String html;

    private String origin;

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }
}