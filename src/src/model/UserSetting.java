package model;

import java.io.Serializable;

public class UserSetting implements Serializable {
	private String user_id;		// ログインユーザーのユーザーID

	//引数ありコンストラクタ
	public UserSetting(String user_id) {
		this.user_id = user_id;
	}
	//引数なしコンストラクタ
	public UserSetting() {
		this.user_id = "";
	}
	//ゲッタとセッタ
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}

