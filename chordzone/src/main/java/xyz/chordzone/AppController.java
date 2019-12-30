package xyz.chordzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
	@Autowired
	private SongService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Song> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";
	}
	@RequestMapping("/new_product")
	public String showNewProductForm(Model model) {
		Song song = new Song();
		model.addAttribute("product", song);
		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Song song) {
		service.save(song);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Song song = service.get(id);
		mav.addObject("product", song);
		return mav;
	}

	@RequestMapping("/view/{id}")
	public ModelAndView showViewProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("view_song");
		Song song = service.get(id);
		if(song != null){
			song.increaseVisitCount();
		}
		mav.addObject("song", song);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
}
