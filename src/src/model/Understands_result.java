package model;

import java.io.Serializable;
import java.util.List;

public class Understands_result implements Serializable {
	private String certification;
	private List<Percent> percents;

	public Understands_result(String certification, List<Percent> percents) {
		setCertification(certification);
		setPercent(percents);
	}

	public Understands_result() {

	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public List<Percent> getPercent() {
		return percents;
	}

	public void setPercent(List<Percent> percents) {
		this.percents = percents;
	}


}
