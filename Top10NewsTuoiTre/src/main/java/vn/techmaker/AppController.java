package vn.techmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Article> articles = new ArrayList<Article>();
        CrawlerEngine cr = new CrawlerEngine();
        cr.getPageLinks("http://tuoitre.vn/");
        articles = cr.topNewArticles;
        System.out.println(articles);
        model.addAttribute("articles", articles);
        return "index";
    }
}