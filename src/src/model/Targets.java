package model;

import java.io.Serializable;

public class Targets implements Serializable {
	//フィールド
	private int id;
	private String target_id;
	private String item_id;
	private String target;

	//コンストラクタ（引数あり）
	public Targets(int id, String target_id, String item_id, String target) {
		this.setId(id);
		this.setTarget_id(target_id);
		this.setItem_id(item_id);
		this.setTarget(target);
	}

	//コンストラクタ（引数あり）
	public Targets() {
		this(0, "", "", "");
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

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

}
