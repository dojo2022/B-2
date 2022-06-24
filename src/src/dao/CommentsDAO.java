package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Comments;



public class CommentsDAO  {
	public List<Comments> to_thread(String thread_id) {
		Connection conn = null;
		List<Comments> cardList = new ArrayList<Comments>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select user_id, content_bbs, time_bbs  from Comments WHERE thread_id LIKE ? ORDER BY time_bbs";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (thread_id != null) {
				pStmt.setString(1,   thread_id );
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Comments card = new Comments(
				rs.getString("user_id"),
				rs.getString("content_bbs"),
				rs.getString("time_bbs")
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
	public boolean insert(Comments card) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する☆
			String sql = "insert into Comments (  comment_id, user_id, content_bbs, time_bbs) values (  ?, ?, ?, ?)";
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
			if (card.getTime_bbs() != null && !card.getTime_bbs().equals("")) {
				pStmt.setString(4, card.getTime_bbs());
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
	public boolean insert_update() {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "UPDATE Comments SET comment_id=(SELECT CONCAT('y',id) FROM Comments WHERE comment_id IS NULL) WHERE comment_id IS NULL;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

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
