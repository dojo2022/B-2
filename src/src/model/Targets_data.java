package model;

import java.io.Serializable;
import java.util.List;

public class Targets_data implements Serializable {
	private String certification;//資格名
	private List<Today_targets> ttList;

	public Targets_data(String certification, List<Today_targets> ttList) {
		this.setCertification(certification);
		this.setTtList(ttList);
	}

	public Targets_data() {
		this(null, null);
	}

	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public List<Today_targets> getTtList() {
		return ttList;
	}
	public void setTtList(List<Today_targets> ttList) {
		this.ttList = ttList;
	}

}
