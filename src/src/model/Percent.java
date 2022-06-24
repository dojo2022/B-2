package model;

import java.io.Serializable;

public class Percent implements Serializable {
	private Double percent;
	private String item;

	public Percent(Double percent, String item) {
		setPercent(percent);
		setItem(item);
	}

	public Percent() {
		this(null, null);
	}

	public Double getPercent() {
		return percent;
	}
	public void setPercent(Double percent) {
		this.percent = percent;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

}
