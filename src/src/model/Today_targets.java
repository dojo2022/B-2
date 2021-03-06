package model;

import java.io.Serializable;

public class Today_targets implements Serializable {
	private int id;
	private String user_id;
	private String item_id;
	private String today_target;
	private String certification;
	private String username;
	private String certification_id;


	//コンストラクタ（引数あり）
	public Today_targets(int id, String user_id, String item_id, String certification_id, String today_target) {
		this.setId(id);
		this.setUser_id(user_id);
		this.setItem_id(item_id);
		this.setCertification_id(certification_id);
		this.setToday_target(today_target);
	}

	public Today_targets(String user_id, String item_id, String certification_id, String today_target) {
		this.setUser_id(user_id);
		this.setItem_id(item_id);
		this.setCertification_id(certification_id);
		this.setToday_target(today_target);
	}

	//コンストラクタ（引数あり）
	//資格登録時用その4
	public Today_targets(int id) {
		this.setId(id);

	}
	//資格登録時用その3
	public Today_targets(int id, String username,String certification) {
		this.setId(id);
		this.setUsername(username);
		this.setCertification(certification);

	}
	//資格登録時用その２
	public Today_targets(String item_id, String certification_id) {
		this.setItem_id(item_id);
		this.setCertification(certification_id);
	}

	//コンストラクタ（引数あり）
	//資格登録時用その１
	public Today_targets(String certification) {
		super();
		this.certification = certification;
	}

	//コンストラクタ（引数無し）
	public Today_targets() {
		this(0, null, null, null, null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getToday_target() {
		return today_target;
	}

	public void setToday_target(String today_target) {
		this.today_target = today_target;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCertification_id() {
		return certification_id;
	}

	public void setCertification_id(String certification_id) {
		this.certification_id = certification_id;
	}

}
