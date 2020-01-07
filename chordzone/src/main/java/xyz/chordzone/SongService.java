package xyz.chordzone;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	public List<Song> retrieveByTitle(String singer){
		return repo.retrieveByTitle(singer);
	}

	public List<Song> get10Result(int startRow, int numOfRow){
		return repo.get10Results(startRow, numOfRow);
	}

	public Long getTotalRows(){
		return repo.getTotalRows();
	}

	public List<Song> getTop10(){return repo.getTop10();}
}
