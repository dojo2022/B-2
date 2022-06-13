package model;
import java.io.Serializable;

public class Users implements Serializable {
	private String username;	// ID
	private String password;	// PW
	private String mail; //メールアドレス

//引数ありコンストラクタ
	public Users(String username, String password, String mail) {
		super();
		this.username = username;
		this.password = password;
		this.mail= mail;
	}
//ログイン時オーバライド用コンストラクタ
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
//引数なしコンストラクタ
	public Users() {
		super();
		this.username = "";
		this.password = "";
		this.mail= "";
	}
//ゲッタとセッタ
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPasswordw(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
