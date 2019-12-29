package xyz.chordzone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
	@Autowired
	private SongRepository repo;
	
	public List<Song> listAll() {
		return repo.findAll();
	}

	public void save(Song song) {
		repo.save(song);
	}
	
	public Song get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
}
