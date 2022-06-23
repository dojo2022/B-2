package model;

import java.io.Serializable;
import java.util.List;

public class Bbs_thread implements Serializable {
	private String thread_bbs; // thread_bbs
	private List<String> comment_bbs; // List

	//引数ありコンストラクタ
	public Bbs_thread(String thread_bbs, String comment_bbs) {
		this.thread_bbs = thread_bbs;
		this.comment_bbs = comment_bbs;
	}

// 	引数なしコンストラクタ
	public Bbs_thread() {
		this.threads_bbs = "";
		this.comment_bbs = "";


	// ゲッタとセッタ
	public String getthread_bbs() {
		return thread_bbs;
	}

	public void setthread_bbs(String thread_bbs) {
		this.thread_bbs = thread_bbs;
	}

	public String getcomment_bbs() {
		return comment_bbs;
	}

	public void setcomment_bbs(String comment_bbs) {
		this.comment_bbs = comment_bbs;
	}

}
