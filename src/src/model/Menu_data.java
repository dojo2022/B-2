package model;

import java.io.Serializable;
import java.util.List;

public class Menu_data implements Serializable {
	private String certification;//試験名
	private String remainingDays;//残り日数
	private String testday;//試験日
	private List<String> itemList;//項目リスト

	//コンストラクタ（引数あり）
	public Menu_data(String certification, String remainingDays, String testday, List<String> itemList) {
		this.setCertification(certification);
		this.setRemainingDays(remainingDays);
		this.setTestDay(testday);
		this.setItemList(itemList);
	}
	//コンストラクタ（引数なし）
	public Menu_data() {
		this(null, null, null, null);
	}

	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getRemainingDays() {
		return remainingDays;
	}
	public void setRemainingDays(String remainingDays) {
		this.remainingDays = remainingDays;
	}

	public List<String> getItemList() {
		return itemList;
	}
	public void setItemList(List<String> itemList) {
		this.itemList = itemList;
	}
	public String getTestDay() {
		return testday;
	}
	public void setTestDay(String testday) {
		this.testday = testday;
	}
}
