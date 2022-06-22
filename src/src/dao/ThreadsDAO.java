package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Threads;



public class ThreadsDAO  {
	 public List<Threads> select_threads(Threads param) {
		Connection conn = null;
		List<Threads> cardList = new ArrayList<Threads>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select thread_id, thread_bbs, category_bbs  from Threads WHERE category LIKE=? ORDER BY NUMBER";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getCategory_bbs() != null) {
				pStmt.setString(1,   param.getCategory_bbs() );
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Threads card = new Threads(
				rs.getString("thread_id"),
				rs.getString("thread_bbs"),
				rs.getString("category_bbs")
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
//	commentsテーブルと外部結合して取り出すselect文

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Threads card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する☆
			String sql = "insert into Threads ( id, thread_id, thread_bbs, category_bbs) values ( ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる☆

			if (card.getThread_id() != null && !card.getThread_id().equals("")) {
				pStmt.setString(1, card.getThread_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getThread_bbs() != null && !card.getThread_bbs().equals("")) {
				pStmt.setString(2, card.getThread_bbs());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getCategory_bbs() != null && !card.getCategory_bbs().equals("")) {
				pStmt.setString(3, card.getCategory_bbs());
			}
			else {
				pStmt.setString(3, null);
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
}
