package model;
import java.io.Serializable;

public class Test_days implements Serializable {
	//TABLE Test_days
	private String id;
	private String certification_id;
	private String certification;
	private String testdays;
	private String app_start;
	private String app_fin;

	//引数のあるコンストラクタ
	public Test_days(String id, String certification_id, String certification,String testdays, String app_start, String app_fin) {
		super();
		this.id = id;
		this.certification_id = certification_id;
		this.certification = certification;
		this.testdays = testdays;
		this.app_start = app_start;
		this.app_fin = app_fin;
	}
	//引数のあるコンストラクタ
	public Test_days(String id, String certification_id,String testdays, String app_start, String app_fin) {
		super();
		this.id = id;
		this.certification_id = certification_id;
		this.testdays = testdays;
		this.app_start = app_start;
		this.app_fin = app_fin;
	}
	//引数のあるコンストラクタ
	public Test_days(String certification) {
		super();
		this.certification = certification;
	}

	//引数のあるコンストラクタ
	public Test_days(String certification_id,String testdays) {
		super();
		this.certification_id = certification_id;
		this.testdays = testdays;
	}

	//引数のないコンストラクタ(デフォルトコンストラクタ)
	public Test_days() {
		super();
		this.id = "";
		this.certification_id ="";
		this.testdays = "";
		this.app_start ="";
		this.app_fin ="";
	}

	//ゲッタセッタ
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCertification_id() {
		return certification_id;
	}

	public void setCertification_id(String certification_id) {
		this.certification_id = certification_id;
	}

	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public String getTestdays() {
		return testdays;
	}

	public void setTestdays(String testdays) {
		this.testdays = testdays;
	}

	public String getApp_start() {
		return app_start;
	}

	public void setApp_start(String app_start) {
		this.app_start = app_start;
	}

	public String getApp_fin() {
		return app_fin;
	}

	public void setApp_fin(String app_fin) {
		this.app_fin = app_fin;
	}



}
