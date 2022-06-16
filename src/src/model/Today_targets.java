package model;

import java.io.Serializable;

public class Today_targets implements Serializable {
	private int id;
	private String user_id;
	private String item_id;
	private int today_target;

	//コンストラクタ（引数あり）
	public Today_targets(int id, String user_id, String item_id, int today_target) {
		this.setId(id);
		this.setUser_id(user_id);
		this.setItem_id(item_id);
		this.setToday_target(today_target);
	}

	//コンストラクタ（引数無し）
	public Today_targets() {
		this(0, null, null, 0);
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

	public int getToday_target() {
		return today_target;
	}

	public void setToday_target(int today_target) {
		this.today_target = today_target;
	}

}
