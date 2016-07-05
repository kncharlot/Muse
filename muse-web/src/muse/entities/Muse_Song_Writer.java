package muse.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Muse_Song_Writer implements Serializable {

	private int song_writer_id;
	private String name;
	private String email_address;
	private String bio;

	private int getSong_writer_id() {
		return song_writer_id;
	}

	private void setSong_writer_id(int song_writer_id) {
		this.song_writer_id = song_writer_id;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private String getEmail_address() {
		return email_address;
	}

	private void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	private String getBio() {
		return bio;
	}

	private void setBio(String bio) {
		this.bio = bio;
	}

	public static Muse_Song_Writer create_Muse_Song_Writer(String name, String email_address, String bio) {
		Muse_Song_Writer new_Song_Writer = new Muse_Song_Writer();
		//remember to create an id for the song_writer
		new_Song_Writer.setBio(bio);
		new_Song_Writer.setEmail_address(email_address);
		new_Song_Writer.setName(name);
		return new_Song_Writer;
	}

	public static Map<String, String> getMuse_Song_Writer_Details(Muse_Song_Writer muse_song_writer) {
		Map<String, String> song_writer_Details = new HashMap<String, String>();
		song_writer_Details.put("bio", muse_song_writer.getBio());
		song_writer_Details.put("name", muse_song_writer.getName());
		song_writer_Details.put("email_address", muse_song_writer.getEmail_address());
		return song_writer_Details;
	}

}
