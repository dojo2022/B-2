package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.My_certifications;

public class My_certificationsDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<My_certifications> select(My_certifications param) {
		Connection conn = null;
		List<My_certifications> My_certificationsList = new ArrayList<My_certifications>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM My_certifications WHERE id = ? AND user_id = ? AND certification_id = ? AND item_id = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getId() != null) {
				pStmt.setString(1, "%" + param.getId() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}
			if (param.getUser_id() != null) {
				pStmt.setString(2, "%" + param.getUser_id() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getCertification_id() != null) {
				pStmt.setString(3, "%" + param.getCertification_id() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}
			if (param.getItem_id() != null) {
				pStmt.setString(4, "%" + param.getItem_id() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				My_certifications new_My_certifications = new My_certifications(
				rs.getString("id"),
				rs.getString("user_id"),
				rs.getString("certification_id"),
				rs.getString("item_id")
				);
				My_certificationsList.add(new_My_certifications);
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
				return My_certificationsList;
			}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(My_certifications card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する 改造
//テーブルが確定するまで保留
				String sql = "INSERT INTO My_certifications (user_id, certification_id, testdays) values (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

//作業中　?に合わせる作業
				// SQL文を完成させる 改造
				if (card.getUser_id() != null && !card.getUser_id().equals("")) {
					pStmt.setString(1, card.getUser_id());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getCertification_id() != null && !card.getCertification_id().equals("")) {
					pStmt.setString(3, card.getCertification_id());
				}
				else {
					pStmt.setString(3, null);
				}
				if (card.getItem_id() != null && !card.getItem_id().equals("")) {
					pStmt.setString(4, card.getItem_id());
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
		public boolean update(My_certifications card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する idはいらない？
				String sql = "UPDATE My_certifications SET certification_id = ? AND item_id = ? WHERE user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getCertification_id() != null && !card.getCertification_id().equals("")) {
					pStmt.setString(1, card.getCertification_id());
				}
				else {
					pStmt.setString(1, "");
				}
				if (card.getItem_id() != null && !card.getItem_id().equals("")) {
					pStmt.setString(2, card.getItem_id());
				}
				else {
					pStmt.setString(2, "");
				}

					pStmt.setInt(11, Integer.parseInt(card.getUser_id()));

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

	// 引数certification_idで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(String certification_id) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "DELETE FROM My_certifications WHERE certification_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, certification_id);

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
