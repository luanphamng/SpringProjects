package xyz.chordzone;

import javax.persistence.*;
import java.util.Comparator;
import java.util.Date;

@Entity
public class Song implements Comparable<Song>{
	private Long id;
	private String title;
	private String artist;
	private String lyric;
	private Long visitcount;
	// The main key of music like Bm, Am or C, ...
	private String gam;
	private String singer;
	private String category;

	// String format for date time in the DB is 2011-03-13 02:53:50
	@Temporal(value= TemporalType.TIMESTAMP)
	private Date postdate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public Long getVisitcount() {
		return visitcount;
	}

	public void setVisitcount(Long visitcount) {
		this.visitcount = visitcount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLyric() {
		return lyric;
	}

	public void setLyric(String lyric) {
		this.lyric = lyric;
	}

	public String getGam() {
		return gam;
	}

	public void setGam(String gam) {
		this.gam = gam;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void increaseVisitCount() {
		this.visitcount++;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public Song() {
		this.visitcount = 0L;
	}

	public Song(Long visitcount) {
		this.visitcount = 0L;
	}

	// Additional functions

	@Override
	public int compareTo(Song s) {
		return getPostdate().compareTo(s.getPostdate());
	}

}
