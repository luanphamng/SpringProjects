package xyz.chordzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Controller
public class AppController {
	@Autowired
	private SongService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Song> listSongs = service.listAll();
		model.addAttribute("listSongs", listSongs);
		return "index";
	}
	@RequestMapping("/new_song")
	public String showNewSongForm(Model model) {
		Song song = new Song();
		model.addAttribute("song", song);
		return "new_song";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSong(@ModelAttribute("product") Song song) {
		service.save(song);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditSongForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");
		
		Song song = service.get(id);
		mav.addObject("product", song);
		return mav;
	}

	@RequestMapping("/view/{id}")
	public ModelAndView showViewSongForm(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("view_song");
		Song song = service.get(id);
		if(song != null){
			song.increaseVisitCount();
			service.save(song);
		}
		Song modelSong = new Song();
		modelSong = song;
		String fullLyric = song.getLyric();
		modelSong.setLyric(fullLyric.substring(0, 200));
		mav.addObject("song", modelSong);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteSong(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
}
