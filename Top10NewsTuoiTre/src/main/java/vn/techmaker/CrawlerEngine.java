package vn.techmaker;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class CrawlerEngine {

    private HashSet<String> links;
    protected List<Article> topNewArticles;

    public CrawlerEngine() {
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
                Elements linksUrl = linksOnPage.select("li");
                Elements linksImage = linksOnPage.select("img");
                Elements linksTitle = linksOnPage.select("title");
                System.out.println("============= Titles On Page =============");
                System.out.println(linksTitle);
                List<String> sStr = new ArrayList<String>();
                List<String> sStrTitle = new ArrayList<String>();
                for (Element page : linksUrl) {
                    if (page.childNodes().size() > 1) {
                        for (Node node : page.childNodes()) {
                            String nodeAttrHref = node.attr("href");
                            String nodeAttrTitle = node.attr("title");
                            if (nodeAttrHref != "") {
                                System.out.println("https://tuoitre.vn" + nodeAttrHref);
                                System.out.println("Title: " + nodeAttrTitle);
                                sStr.add("https://tuoitre.vn" + nodeAttrHref);
                                sStrTitle.add(nodeAttrTitle);
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
                    topNewArticles.add(new Article(sStr.get(i), sStr2.get(i), sStrTitle.get(i)));
                }
                System.out.println(topNewArticles);
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }
}
