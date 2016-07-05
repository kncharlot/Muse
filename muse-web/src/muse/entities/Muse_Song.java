package muse.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;



@Entity
@Table(name = "muse_song")
@NamedQueries({ @NamedQuery(name = "Muse_Song.findAll", query = "SELECT ms FROM Muse_Song ms"),
	@NamedQuery(name = "Muse_Song.findbySong_ID", query = "SELECT ms FROM Muse_Song ms WHERE ms.song_id = :song_id"),
		@NamedQuery(name = "Muse_Song.findBySong_Title", query = "SELECT ms FROM Muse_Song ms WHERE ms.song_title = :song_title")})

public class Muse_Song implements Serializable {
	
//	Long count = (Long) entityManager.createNamedQuery("ConfigEditorFile.checkExistenceOfFileRecord").setParameter("filePath", filePath).getSingleResult();
//	if(count>0){
//		originalSaved=true;
//		action="Update";//since original already exist, change action to update instead of insert
//	}
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
//	/**
//	 * Default constructor.
//	 */
//	public ConfigEditorFileEntitySessionBean() {
//		logger = Logger.getLogger(this.getClass().getName());
//	}

//	static Logger logger;
	
	
	//logs a debug message
//		if(logger.isDebugEnabled()){
//		    logger.debug("This is debug");
//		}
//		
//		//logs an error message with parameter
//		logger.error("This is error : " + parameter);
//		
//		//logs an exception thrown from somewhere
//		logger.error("This is error", exception);
	
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	final static Logger logger = Logger.getLogger(Muse_Song.class);
//	 
//    public static void main(String[] args)
//    {
//        //Configure logger
//        BasicConfigurator.configure();
//        logger.debug("Hello World!");
//    }
	
	@Id 
	@GeneratedValue
	private Long song_id;
	
	@Column(name="song_title")
	private String song_title;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "song_writer_id")
	private Muse_Song_Writer song_writer;
	@Column(name="song_lyrics")
	private String song_lyrics;
	@Column(name="song_audio_link")
	private String song_audio_link;
	
	

	/**
	 * @param song_id
	 * @param song_title
	 * @param song_writer
	 * @param song_lyrics
	 * @param song_audio_link
	 */
	public Muse_Song() {
//		public Muse_Song(Long song_id, String song_title, Muse_Song_Writer song_writer, String song_lyrics,
//				String song_audio_link) {
//		if(logger.isInfoEnabled()){
//			logger.info("Creating a new instance of  : " + Muse_Song.class.getName());
//		}
//		this.song_id = song_id;
//		this.song_title = song_title;
//		this.song_writer = song_writer;
//		this.song_lyrics = song_lyrics;
//		this.song_audio_link = song_audio_link;
		
	}

	public Long getSong_id() {
		return song_id;
	}

	public void setSong_id(Long song_id) {
		this.song_id = song_id;
	}

	public String getSong_title() {
		return song_title;
	}

	public void setSong_title(String song_title) {
		this.song_title = song_title;
	}

	public Muse_Song_Writer getSong_writer() {
		return song_writer;
	}

	public void setSong_writer(Muse_Song_Writer song_writer) {
		this.song_writer = song_writer;
	}

	public String getSong_lyrics() {
		return song_lyrics;
	}

	public void setSong_lyrics(String song_lyrics) {
		this.song_lyrics = song_lyrics;
	}

	public String getSong_audio_link() {
		return song_audio_link;
	}

	public void setSong_audio_link(String song_audio_link) {
		this.song_audio_link = song_audio_link;
	}

	public static Muse_Song create_Muse_Song(String song_title, Muse_Song_Writer song_writer, String song_lyrics, String song_audio_link) {
		Muse_Song new_Song = new Muse_Song();
		//remember to create an id for the song
		new_Song.setSong_lyrics(song_lyrics);
		new_Song.setSong_title(song_title);
		new_Song.setSong_writer(song_writer);
		new_Song.setSong_audio_link(song_audio_link);
		return new_Song;
	}

	public static Map<String, String> getMuse_Song_Details(Muse_Song muse_song) {
		Map<String, String> song_Details = new HashMap<String, String>();
		song_Details.put("song_title", muse_song.getSong_title());
		song_Details.put("song_writer", Muse_Song_Writer.getMuse_Song_Writer_Details(muse_song.getSong_writer()).get("name"));
		song_Details.put("song_lyrics", muse_song.getSong_lyrics());
		song_Details.put("audio_link", muse_song.getSong_audio_link());
		return song_Details;
	}

}
