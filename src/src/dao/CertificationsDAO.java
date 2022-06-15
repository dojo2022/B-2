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

				// SQL文を準備する（資格の検索）
				String sql = "SELECT CERTIFICATION_ID, certification, category from CERTIFICATIONS WHERE category LIKE ? ORDER BY CERTIFICATION_ID";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getCategory() != null) {
					pStmt.setString(1, "%" + param.getCategory() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Certifications card = new Certifications(
		//			rs.getString("id"),
		//			rs.getString("certification_id"),
		//			rs.getString("certification"),
		//			rs.getString("category")
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
				String sql = "insert into CERTIFICATION (id, certification_id, certification, category) values (?, ?, ?, ?)";
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
				String sql = "update Certifications set id=?, certification_id=?, certification=?, category=?";
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