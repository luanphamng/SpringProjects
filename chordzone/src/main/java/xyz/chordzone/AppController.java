package xyz.chordzone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class AppController {
	@Autowired
	private SongService service;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Song> listSongs = service.listAll();
		Collections.sort(listSongs);
		List<Song> listTruncate = new LinkedList<Song>();
		Iterator<Song> it = listSongs.iterator();
		while (it.hasNext()) {
			Song modelSong = new Song();
			modelSong = it.next();
			String fullLyric = modelSong.getLyric();
			if (modelSong.getLyric().length() >= 200) {
				modelSong.setLyric(fullLyric.substring(0, 200) + "...");
			} else {
			}
			listTruncate.add(modelSong);
		}
		model.addAttribute("listSongs", listTruncate);
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

		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date getCurrentTime = new Date();
		song.setPostdate(new Date());
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
		if (song != null) {
			song.increaseVisitCount();
			service.save(song);
		}
		mav.addObject("song", song);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteSong(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public String get10(Model model) {
		List<Song> s = service.retrieveByTitle("AMEE & ViruSs");
		model.addAttribute("listSongs", s);
		return "search";
	}

	@RequestMapping("/get10Latest")
	public String get10Latest(Model model){
		List<Song> s = service.get10Result(3, 2);
		model.addAttribute("listSongs", s);
		return "index";
	}

	@RequestMapping("/viewmore/{p}")
	public ModelAndView showViewSongForm(@PathVariable(name = "p") int p) {
		Long total_chords = service.getTotalRows();

		ModelAndView mav = new ModelAndView("view_more");
		List<Song> s = service.get10Result((p - 1) * 10, 10);

		Collections.sort(s);
		List<Song> listTruncate = new LinkedList<Song>();
		Iterator<Song> it = s.iterator();
		while (it.hasNext()) {
			Song modelSong = new Song();
			modelSong = it.next();
			String fullLyric = modelSong.getLyric();
			if (modelSong.getLyric().length() >= 200) {
				modelSong.setLyric(fullLyric.substring(0, 200) + "...");
			} else {
			}
			listTruncate.add(modelSong);
		}
		mav.addObject("numOfPagination", total_chords / 10 + 1);
		mav.addObject("pageToHighlight", p);
		mav.addObject("listSongs", listTruncate);
		return mav;
	}
}
