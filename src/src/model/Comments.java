package model;
import java.io.Serializable;
public class Comments implements Serializable {
	private int id; //id
	private String thread_id; //スレッドid(外部キー)
	private String comment_id; //コメントid
	private String user_id; //ユーザid(外部キー)
	private String content_bbs; //コメント内容
	private String time_id; //投稿時間
	private String username;
//	引数ありコンストラクタ
	public Comments(int id, String thread_id, String comment_id, String user_id, String content_bbs, String time_id, String username) {
		this.id = id;
		this.thread_id = thread_id;
		this.comment_id = comment_id;
		this.user_id = user_id;
		this.content_bbs = content_bbs;
		this.time_id = time_id;
		this.username = username;
	}

// select用コンストラクタ
	public Comments( String user_id, String content_bbs, String time_id) {
		this.user_id = user_id;
		this.content_bbs = content_bbs;
		this.time_id = time_id;
	}

	public Comments( String user_id,String username, String content_bbs, String time_id) {
		this.user_id = user_id;
		this.username = username;
		this.content_bbs = content_bbs;
		this.time_id = time_id;
	}
// 	引数なしコンストラクタ
	public Comments() {
		this.id = 0;
		this.thread_id = "";
		this.comment_id = "";
		this.user_id = "";
		this.content_bbs = "";
		this.time_id = "";
		this.username = "";
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
	public String getTime_id() {
		return time_id;
	}
	public void setTime_id(String time_id) {
		this.time_id = time_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}