package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Comments;



public class CommentsDAO  {
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Comments card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する☆
			String sql = "insert into Comments (  comment_id, user_id, content_bbs, time_id) values (  ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる☆

			if (card.getComment_id() != null && !card.getThread_id().equals("")) {
				pStmt.setString(1, card.getComment_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(2, card.getUser_id());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getContent_bbs() != null && !card.getContent_bbs().equals("")) {
				pStmt.setString(3, card.getContent_bbs());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getTime_id() != null && !card.getTime_id().equals("")) {
				pStmt.setString(4, card.getTime_id());
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
	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "delete from Comments where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, id);

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


