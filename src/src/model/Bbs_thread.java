package model;

import java.io.Serializable;
import java.util.List;

public class Bbs_thread implements Serializable {
	private String thread_bbs; // thread_bbs
	private String thread_id; // thread_id
	private List<Comments> comment_bbs; // List

	//引数ありコンストラクタ
	public Bbs_thread(String thread_bbs,String thread_id, List<Comments> comment_bbs) {
		this.thread_bbs = thread_bbs;
		this.thread_id = thread_id;
		this.comment_bbs = comment_bbs;

	}

// 	引数なしコンストラクタ
	public Bbs_thread() {
		this.thread_bbs = "";
		this.thread_id = "";
		this.comment_bbs = null;
	}



	public String getThread_id() {
		return thread_id;
	}

	public void setThread_id(String thread_id) {
		this.thread_id = thread_id;
	}

	// ゲッタとセッタ
	public String getthread_bbs() {
		return thread_bbs;
	}

	public void setthread_bbs(String thread_bbs) {
		this.thread_bbs = thread_bbs;
	}

	public List<Comments> getcomment_bbs() {
		return comment_bbs;
	}

	public void setcomment_bbs(List<Comments> comment_bbs) {
		this.comment_bbs = comment_bbs;
	}

}
