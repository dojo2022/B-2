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
			String sql = "SELECT Items.item_id as ID, CERTIFICATIONS .certification as DAY FROM Items,CERTIFICATIONS WHERE CERTIFICATIONS .certification_id= (SELECT certification_id FROM Certifications WHERE Certifications.certification = ?)";
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
			while (rs.next()) {
				Today_targets new_target = new Today_targets(
						rs.getString("ID"),
						rs.getString("DAY")
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


			// SQL文を準備する
			String sql = "insert into Today_targets (user_id, item_id) values (?, ?)";
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

			// 結果表をコレクションにコピーする
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
			//下行はupdateが完成し次第削除する
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
