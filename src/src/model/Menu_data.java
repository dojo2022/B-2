package model;

import java.io.Serializable;
import java.util.List;

public class Menu_data implements Serializable {
	private String certification;
	private String testday;
	private List<String> itemList;

	//コンストラクタ（引数あり）
	public Menu_data(String certification, String testday, List<String> itemList) {
		this.setCertification(certification);
		this.setTestday(testday);
		this.setItemList(itemList);
	}
	//コンストラクタ（引数なし）
	public Menu_data() {
		this(null, null, null);
	}

	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getTestday() {
		return testday;
	}
	public void setTestday(String testday) {
		this.testday = testday;
	}

	public List<String> getItemList() {
		return itemList;
	}
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
}
