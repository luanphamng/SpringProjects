package vn.techmaker;

import java.util.ArrayList;

public class Article {

    private String url;
    private String title;
    private String img;

    public Article(String url, String img, String title){
        this.url = url;
        this.img = img;
        this.title = title;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
