package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Today_targets;

public class Today_targetsDAO {
	public List<Today_targets> select(Today_targets today_targets){
		Connection conn = null;
		List<Today_targets> resultList = new ArrayList<Today_targets>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "select * from Today_targets WHERE user_id LIKE ? AND item_id LIKE ? AND today_target LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (today_targets.getUser_id() != null && !today_targets.getUser_id().equals("")) {
				pStmt.setString(1, today_targets.getUser_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if (today_targets.getItem_id() != null && !today_targets.getItem_id().equals("")) {
				pStmt.setString(2, today_targets.getItem_id());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (today_targets.getToday_target() != null && !today_targets.getToday_target().equals("")) {
				pStmt.setString(3, today_targets.getToday_target());
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Today_targets new_target = new Today_targets(
					rs.getInt("id"),
					rs.getString("user_id"),
					rs.getString("item_id"),
					rs.getString("today_target")
					);
				resultList.add(new_target);
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

		return resultList;
	}

	//資格登録時item_id検索用
	public List<Today_targets> insert_select(Today_targets today_targets){
		Connection conn = null;
		List<Today_targets> resultList_tts = new ArrayList<Today_targets>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "SELECT item_id, certification_id FROM Items WHERE certification_id= (SELECT certification_id FROM Certifications WHERE Certifications.certification = ?) ORDER BY ID;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (today_targets.getCertification() != null && !today_targets.getCertification().equals("")) {
				pStmt.setString(1, today_targets.getCertification());
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			//certification_idに入れたいのに、certificationに入ってしまう...①
			while (rs.next()) {
				Today_targets new_target = new Today_targets(
						rs.getString("item_id"),
						rs.getString("certification_id")
						);
				resultList_tts.add(new_target);
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

		return resultList_tts;
	}

	public boolean insert(Today_targets today_targets){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する-の準備をする
			//user_id
			String selectuserSql = "SELECT user_id FROM Users WHERE username = ?";
			PreparedStatement selectuserStmt = conn.prepareStatement(selectuserSql);
			selectuserStmt.setString(1, today_targets.getUsername());
			// SQL文を実行し、結果表を取得する
			ResultSet rs = selectuserStmt.executeQuery();
			rs.next();
			//ユーザidを使えるように定義
			String user_id = rs.getString("user_id");

			//データの登録
				// SQL文を準備する
				String sql = "insert into Today_targets (user_id, item_id,certification_id) values (?, ?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (user_id != null && !user_id.equals("")) {
					pStmt.setString(1, user_id);
				}
				else {
					pStmt.setString(1, null);
				}
				if (today_targets.getItem_id() != null && !today_targets.getItem_id().equals("")) {
					pStmt.setString(2, today_targets.getItem_id());
				}
				else {
					pStmt.setString(2, null);
				}
				//insert_select①より、certificationに入っているcertification_idを登録する
				if (today_targets.getCertification() != null && !today_targets.getCertification().equals("")) {
					pStmt.setString(3, today_targets.getCertification());
				}
				else {
					pStmt.setString(3, null);
				}

			// 結果表をコレクションにコピーする
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

		return result;
	}

	//資格登録→更新時id検索用
	public List<Today_targets> insert_update_select(Today_targets today_targets){
		Connection conn = null;
		List<Today_targets> resultList_ttus = new ArrayList<Today_targets>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "SELECT id   FROM Today_targets WHERE user_id= (SELECT user_id FROM Users WHERE Users.username = ?)  ORDER BY ID LIMIT 2;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (today_targets.getUsername() != null && !today_targets.getUsername().equals("")) {
				pStmt.setString(1, today_targets.getUsername());
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Today_targets new_target = new Today_targets(
						rs.getInt("id")
						);
				resultList_ttus.add(new_target);
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

		return resultList_ttus;
	}

	public boolean insert_update(Today_targets today_targets){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");


			// SQL文を準備する
			String sql = "update Today_targets set Today_target ='1' where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (today_targets.getId() != 0) {
				pStmt.setString(1, Integer.toString(today_targets.getId()));
			}
			else {
				pStmt.setString(1, "%");
			}

			// 結果表をコレクションにコピーする
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

		return result;
	}


	public boolean update(Today_targets today_targets){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "update Today_targets set Today_target = ? WHERE item_id = ? AND user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, today_targets.getToday_target());//サーブレットで0,1,2以外の数値ははじく
			if (today_targets.getItem_id() != null && !today_targets.getItem_id().equals("")) {
				pStmt.setString(2, today_targets.getItem_id());
			}
			else {
				pStmt.setString(2, null);
			}
			if (today_targets.getUser_id() != null && !today_targets.getUser_id().equals("")) {
				pStmt.setString(3, today_targets.getUser_id());
			}
			else {
				pStmt.setString(3, null);
			}

			// 結果表をコレクションにコピーする
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

		return result;
	}
}
