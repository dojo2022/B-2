package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String username;	// ログイン時のユーザ名

//引数ありコンストラクタ
	public LoginUser(String username) {
		this.username = username;
	}
//引数なしコンストラクタ
	public LoginUser() {
		this.username = "";
	}
//ゲッタとセッタ
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}


}
