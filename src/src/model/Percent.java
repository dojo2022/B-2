package model;

import java.io.Serializable;

public class Percent implements Serializable {
	private String percent;
	private String item;

	public Percent(String percent, String item) {
		setPercent(percent);
		setItem(item);
	}

	public Percent() {
		this(null, null);
	}

	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

}
