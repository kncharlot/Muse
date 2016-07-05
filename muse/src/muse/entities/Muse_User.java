package muse.entities;

import java.util.HashMap;
import java.util.Map;

public class Muse_User {

	private int user_id;
	private String name;
	private String email_address;

	private int getUser_id() {
		return user_id;
	}

	private void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public static Muse_User create_User_Info(String name, String email_address) {
		Muse_User new_muse_user = new Muse_User();
		//remember to create an id for the user
		new_muse_user.setEmail_address(email_address);
		new_muse_user.setName(name);
		return new_muse_user;
	}

	public static Map<String, String> getMuse_User_Details(Muse_User muse_user) {
		Map<String, String> muse_user_Details = new HashMap<String, String>();
		muse_user_Details.put("name", muse_user.getName());
		muse_user_Details.put("email_address", muse_user.getEmail_address());
		return muse_user_Details;
	}
}
