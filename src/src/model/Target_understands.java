package model;

import java.io.Serializable;

public class Target_understands implements Serializable {
	//フィールド名
	private int id;
	private String target_id;
	private String item_id;
	private String user_id;
	private String day;
	private int target_understand;

	//コンストラクタ（引数あり）
	public Target_understands(int id, String target_id, String item_id, String user_id, String day, int target_understand) {
		this.setId(id);
		this.setTarget_id(target_id);
		this.setItem_id(item_id);
		this.setUser_id(user_id);
		this.setDay(day);
		this.setTarget_understand(target_understand);
	}

	//コンストラクタ（引数なし）
	public Target_understands() {
		this(0, "", "", "", "", 0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getTarget_understand() {
		return target_understand;
	}

	public void setTarget_understand(int target_understand) {
		this.target_understand = target_understand;
	}
}
