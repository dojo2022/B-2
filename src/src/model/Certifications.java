package model;
import java.io.Serializable;

public class Certifications implements Serializable {
	//TABLE Certifications
	private String id;
	private String certification_id;
	private String certification;
	private String category;
	private String book_name;
	private String book_image;
	private String level;

	//引数のあるコンストラクタ
	public Certifications(String id, String certification_id, String certification, String category, String book_name,
			String book_image, String level) {
		super();
		this.id = id;
		this.certification_id = certification_id;
		this.certification = certification;
		this.category = category;
		this.book_name = book_name;
		this.book_image = book_image;
		this.level=level;
	}

	//資格の検索表示用コンストラクタ
		public Certifications(String id, String certification_id, String certification, String category) {
			super();
			this.id = id;
			this.certification_id = certification_id;
			this.certification = certification;
			this.category = category;

		}

		// カテゴリの表示用コンストラクタ
				public Certifications(String certification) {
				this.certification = certification;
				}

		//マッチング時オーバライド用コンストラクタ
		public Certifications( String certification, String category, String level) {
			this.certification = certification;
			this.category = category;
			this.level= level;
		}
		//マッチングオーバライド用コンストラクタ
		public Certifications( String category, String level) {
			this.category = category;
			this.level= level;
		}

	//引数のないコンストラクタ(デフォルトコンストラクタ)
	public Certifications() {
		super();
		this.id = "";
		this.certification_id = "";
		this.certification = "";
		this.category = "";
		this.book_name = "";
		this.book_image = "";
		this.level = "";
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}


