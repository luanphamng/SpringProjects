
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Application {

    private HashSet<String> links;
    private List<Article> topNewArticles;

    public Application() {
        links = new HashSet<String>();
        topNewArticles = new ArrayList<Article>();
    }

    public void getPageLinks(String URL) {
        //4. Check if you have already crawled the URLs
        //(we are intentionally not checking for duplicate content in this example)
        if (!links.contains(URL)) {
            try {
                //4. (i) If not add it to the index
                if (links.add(URL)) {
                    System.out.println(URL);
                }

                //2. Fetch the HTML code
                Document document = Jsoup.connect(URL).get();
                //3. Parse the HTML to extract links to other URLs
                Elements linksOnPage = document.select("div.box-mostview");
                System.out.println("============= Link On Page =============");
                System.out.println(linksOnPage);
                System.out.println("============= End on Page =============");
                Elements linksArticle = linksOnPage.select("li");
                Elements linksImage = linksOnPage.select("img");

                List<String> sStr = new ArrayList<String>();
                for (Element page : linksArticle) {
                    if (page.childNodes().size() > 1) {
                        for (Node node : page.childNodes()) {
                            String nodeAttr = node.attr("href");
                            if (nodeAttr != "") {
                                System.out.println("https://tuoitre.vn" + nodeAttr);
                                sStr.add("https://tuoitre.vn" + nodeAttr);
                                break;
                            }
                        }
                    }
                }
                List<String> sStr2 = new ArrayList<String>();
                for (Element page : linksImage) {
                    String nodeAttr = page.attr("src");
                    sStr2.add(nodeAttr);
                    if (nodeAttr != "") {
                        System.out.println(nodeAttr);
                    }
                }
                for (int i = 0; i < sStr.size(); i++){
                    topNewArticles.add(new Article(sStr.get(i), sStr2.get(i)));
                }
                System.out.println(topNewArticles);
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        //1. Pick a URL from the frontier
        new Application().getPageLinks("http://tuoitre.vn/");
    }

}
