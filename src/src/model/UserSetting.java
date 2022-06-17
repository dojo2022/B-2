package model;

import java.io.Serializable;

public class UserSetting implements Serializable {
	private String username;	// ログイン時のユーザ名
	private String user_id;		// ログインユーザーのユーザーID

	//引数ありコンストラクタ
	public UserSetting(String username, String user_id) {
		this.username = username;
		this.user_id = user_id;
	}
	//引数なしコンストラクタ
	public UserSetting() {
		this.username = "";
		this.user_id = "";
	}
	//ゲッタとセッタ
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public static void add(UserSetting id) {
		// TODO 自動生成されたメソッド・スタブ

	}
}

