package model;
import java.io.Serializable;
public class Comments implements Serializable {
	private int id; //id
	private String thread_id; //スレッドid(外部キー)
	private String comment_id; //コメントid
	private String user_id; //ユーザid(外部キー)
	private String content_bbs; //コメント内容
	private String time_bbs; //投稿時間
//	引数ありコンストラクタ
	public Comments(int id, String thread_id, String comment_id, String user_id, String content_bbs, String time_bbs) {
		this.id = id;
		this.thread_id = thread_id;
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.content_bbs = content_bbs;
		this.time_bbs = time_bbs;
	}

// select用コンストラクタ
	public Comments( String user_id, String content_bbs, String time_bbs) {
		this.user_id = user_id;
		this.content_bbs = content_bbs;
		this.time_bbs = time_bbs;
	}
// 	引数なしコンストラクタ
	public Comments() {
		this.id = 0;
		this.thread_id = "";
		this.comment_id = "";
		this.user_id = "";
		this.content_bbs = "";
		this.time_bbs = "";
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
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent_bbs() {
		return content_bbs;
	}
	public void setContent_bbs(String content_bbs) {
		this.content_bbs = content_bbs;
	}
	public String getTime_bbs() {
		return time_bbs;
	}
	public void setTime_id(String time_bbs) {
		this.time_bbs = time_bbs;
	}
}