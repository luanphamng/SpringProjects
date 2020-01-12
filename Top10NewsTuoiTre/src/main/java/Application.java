
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

public class Application {

    private HashSet<String> links;

    public Application() {
        links = new HashSet<String>();
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
                Elements linksSeperates = linksOnPage.select("li");
                System.out.println("============= Link seperate =============");
                for(Element e : linksSeperates){
                    System.out.println("Seperate: " + e);
                }
//                System.out.println(linksSeperates);
                System.out.println("============= End on link seperate =============");
                //5. For each extracted URL... go back to Step 4.
//                for (Element page : linksOnPage) {
////                    getPageLinks(page.attr("abs:href"));
////                }
                for (Element page : linksSeperates) {
                    getPageLinks(page.attr("abs:href"));
                }
//                for (Element headline : linksSeperates) {
//                    String t = headline.attr("src");
//                    System.out.print("Title: " + t);
////                    System.out.println("   Url: " + headline.attr("href"));
//                }
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
