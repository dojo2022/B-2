package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Certifications;

	public class CertificationsDAO {
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Certifications> select(Certifications param) {
			Connection conn = null;
			List<Certifications> cardList = new ArrayList<Certifications>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                                                                                                            // from以降はいる・・？
				// SQL文を準備する（資格の検索）
				String sql = "SELECT id, certification_id, certification, category, book_name, book_image from BC WHERE name LIKE ? AND company LIKE ? order by CAST(number as INT)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getId() != null) {
					pStmt.setString(1, "%" + param.getId() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getCertification_id() != null) {
					pStmt.setString(2, "%" + param.getCertification_id() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.getCertification() != null) {
					pStmt.setString(3, "%" + param.getCertification() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}if (param.getCategory() != null) {
					pStmt.setString(4, "%" + param.getCategory() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}if (param.getBook_name() != null) {
					pStmt.setString(5, "%" + param.getBook_name() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}if (param.getBook_image() != null) {
					pStmt.setString(6, "%" + param.getBook_image() + "%");
				}
				else {
					pStmt.setString(6, "%");
				}


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Certifications card = new Certifications(
					rs.getString("id"),
					rs.getString("certification_id"),
					rs.getString("certification"),
					rs.getString("category"),
					rs.getString("book_name"),
					rs.getString("book_image")
					);
					cardList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}


		// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Certifications card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "insert into BC (id, certification_id, certification, category, book_name, book_image) values (?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる（登録）
				if (card.getId() != null && !card.getId().equals("")) {
					pStmt.setString(1, card.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getCertification_id() != null && !card.getCertification_id().equals("")) {
					pStmt.setString(2, card.getCertification_id());
				}
				else {
					pStmt.setString(2, null);
				}
				if (card.getCertification() != null && !card.getCertification().equals("")) {
					pStmt.setString(3, card.getCertification());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getCategory() != null && !card.getCategory().equals("")) {
					pStmt.setString(4, card.getCategory());
				}
				else {
					pStmt.setString(4, null);
				}
				if (card.getBook_name() != null && !card.getBook_name().equals("")) {
					pStmt.setString(5, card.getBook_name());
				}
				else {
					pStmt.setString(5, null);
				}if (card.getBook_image() != null && !card.getBook_image().equals("")) {
					pStmt.setString(6, card.getBook_image());
				}
				else {
					pStmt.setString(6, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

		// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Certifications card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "update BC set id=?, certification_id=?, certification=?, category=?, book_name=?, book_image=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる(改造）
				if (card.getId() != null && !card.getId().equals("")) {
					pStmt.setString(1, card.getId());
				}
				else {
					pStmt.setString(1, null);
				}

				if (card.getCertification_id() != null && !card.getCertification_id().equals("")) {
					pStmt.setString(2, card.getCertification_id());
				}
				else {
					pStmt.setString(2, null);
				}if (card.getCertification() != null && !card.getCertification().equals("")) {
					pStmt.setString(3, card.getCertification());
				}
				else {
					pStmt.setString(3, null);
				}if (card.getCategory() != null && !card.getCategory().equals("")) {
					pStmt.setString(4, card.getCategory());
				}
				else {
					pStmt.setString(4, null);
				}if (card.getBook_name() != null && !card.getBook_name().equals("")) {
					pStmt.setString(5, card.getBook_name());
				}
				else {
					pStmt.setString(5, null);
				}if (card.getBook_image() != null && !card.getBook_image().equals("")) {
					pStmt.setString(6, card.getBook_image());
				}
				else {
					pStmt.setString(6, null);
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

		// 引数idで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(String id) {


			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "delete from Certifications where id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, id);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}


			// 結果を返す
			return result;
		}


	}