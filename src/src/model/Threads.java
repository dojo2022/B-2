package model;

import java.io.Serializable;

public class Threads implements Serializable {
	private int id;//ID
	private String thread_id;//スレッドID
	private String thread_bbs;//スレッド名
	private String category_bbs;//スレッドカテゴリー

//	引数ありコンストラクタ
	public Threads(int id, String thread_id, String thread_bbs, String category_bbs) {
		this.id = id;
		this.thread_id = thread_id;
		this.thread_bbs = thread_bbs;
		this.category_bbs = category_bbs;
	}

//	(必要かも)select用コンストラクタ
	public Threads(String thread_id, String thread_bbs, String category_bbs) {
		this.thread_id = thread_id;
		this.thread_bbs = thread_bbs;
		this.category_bbs = category_bbs;
	}

//	引数なしコンストラクタ
	public Threads() {
		this.id = 0;
		this.thread_id = "";
		this.thread_bbs = "";
		this.category_bbs = "";
	}

//	ゲッタとセッタ
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThread_id() {
		return thread_id;
	}

	public void setThread_id(String thread_id) {
		this.thread_id = thread_id;
	}

	public String getThread_bbs() {
		return thread_bbs;
	}

	public void setThread_bbs(String thread_bbs) {
		this.thread_bbs = thread_bbs;
	}

	public String getCategory_bbs() {
		return category_bbs;
	}

	public void setCategory_bbs(String category_bbs) {
		this.category_bbs = category_bbs;
	}

}

