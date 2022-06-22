package model;

import java.io.Serializable;
import java.util.List;

public class Understands implements Serializable {
	private String certification;
	private List<Target_understands> tuList;
	private List<Target_understands> ttList;

	//コンストラクタ(引数あり)
	public Understands(String certification, List<Target_understands> tuList, List<Target_understands> ttList) {
		this.setCertification(certification);
		this.setTuList(tuList);
		this.setTtList(ttList);
	}

	//コンストラクタ(引数なし)
	public Understands() {
		this(null, null, null);
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public List<Target_understands> getTuList() {
		return tuList;
	}

	public void setTuList(List<Target_understands> tuList) {
		this.tuList = tuList;
	}

	public List<Target_understands> getTtList() {
		return ttList;
	}

	public void setTtList(List<Target_understands> ttList) {
		this.ttList = ttList;
	}
}
