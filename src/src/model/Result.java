package model;

import java.io.Serializable;


public class Result implements Serializable {
	private String title;//タイトル
	private String message; //メッセージ
//引数なしコンストラクタ
    public Result() {
        this(null,null);
    }
//    引数ありコンストラクタ
	public Result(String title, String message) {
		this.title = title;
		this.message = message;
	}

//	ゲッタとセッタ
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}

