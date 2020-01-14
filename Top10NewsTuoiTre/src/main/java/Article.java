import java.util.ArrayList;

public class Article {

    public Article(String url, String img){
        this.url = url;
        this.img = img;
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

    private String url;
    private String img;

}
