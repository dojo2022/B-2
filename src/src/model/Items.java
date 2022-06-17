package model;

import java.io.Serializable;

public class Items implements Serializable {
	private String certification_id;//資格ID
	private String item_id;//項目ID
	private String item;//項目名
	private int item_page;//項目ページ数
//	引数ありコンストラクタ
	public Items(String certification_id, String item_id, String item, int item_page) {
		this.certification_id = certification_id;
		this.item_id = item_id;
		this.item = item;
		this.item_page = item_page;
	}
//	引数なしコンストラクタ
	public Items() {
		this.certification_id = "";
		this.item_id = "";
		this.item = "";
		this.item_page = 0;
	}

//	ゲッタとセッタ
	public String getCertification_id() {
		return certification_id;
	}
	public void setCertification_id(String certification_id) {
		this.certification_id = certification_id;
	}
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getItem_page() {
		return item_page;
	}
	public void setItem_page(int item_page) {
		this.item_page = item_page;
	}

}
