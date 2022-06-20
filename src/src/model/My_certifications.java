package model;
import java.io.Serializable;

public class My_certifications implements Serializable{
	//TABLE My_certifications
	private String id;
	private String user_id;
	private String certification_id;
	//private String item_id;
	private String testdays;
	private String username;
	private String certification;


	//引数のあるコンストラクタ
	public My_certifications(String id, String user_id, String certification_id, String testdays) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.certification_id = certification_id;
		this.testdays = testdays;
	}

	//引数のあるコンストラクタ
	public My_certifications(String username, String certification, String testdays) {
		super();
		this.username = username;
		this.certification = certification;
		this.testdays = testdays;
	}


	//引数のないコンストラクタ(デフォルトコンストラクタ)
	public My_certifications() {
			super();
			this.id = "";
			this.user_id = "";
			this.certification_id = "";
			this.testdays = "";
			this.username = "";
			this.certification = "";
	}

	//ゲッタセッタ
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCertification_id() {
		return certification_id;
	}

	public void setCertification_id(String certification_id) {
		this.certification_id = certification_id;
	}

	/*
	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	*/

	public String getTestdays() {
		return testdays;
	}

	public void setTestdays(String testdays) {
		this.testdays = testdays;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

}