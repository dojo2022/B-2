package model;

import java.io.Serializable;
import java.util.List;

public class Bbs_thread implements Serializable {
	private String thread_bbs; // thread_bbs
	private List<Comments> comment_bbs; // List
	private String username;

	//引数ありコンストラクタ
	public Bbs_thread(String thread_bbs, List<Comments> comment_bbs/*,String username*/) {
		this.thread_bbs = thread_bbs;
		this.comment_bbs = comment_bbs;
		/*this.username = username;*/
	}

// 	引数なしコンストラクタ
	public Bbs_thread() {
		this.thread_bbs = "";
		this.comment_bbs = null;
		this.username = "";
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
