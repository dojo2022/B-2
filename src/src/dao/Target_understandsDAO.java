package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import model.Target_understands;


@WebServlet("/Target_understandsDAO")
public class Target_understandsDAO {
	public List<Target_understands> select(Target_understands target_understands){
		Connection conn = null;
		List<Target_understands> resultList = new ArrayList<Target_understands>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "select * from Target_understands WHERE id = ? AND target_id = ? AND item_id = ? AND user_id = ? AND day = ? AND target_understand = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (target_understands.getId() != 0) {
				pStmt.setString(1, Integer.toString(target_understands.getId()));
			}
			else {
				pStmt.setString(1, "%");
			}
			if (target_understands.getTarget_id() != null && !target_understands.getTarget_id().equals("")) {
				pStmt.setString(2, target_understands.getTarget_id());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (target_understands.getItem_id() != null && !target_understands.getItem_id().equals("")) {
				pStmt.setString(3, target_understands.getItem_id());
			}
			else {
				pStmt.setString(3, "%");
			}
			if (target_understands.getUser_id() != null && !target_understands.getUser_id().equals("")) {
				pStmt.setString(4, "%" + target_understands.getUser_id() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}
			if (target_understands.getDay() != null && !target_understands.getDay().equals("")) {
				pStmt.setString(5, "%" + target_understands.getDay() + "%");
			}
			else {
				pStmt.setString(5, "%");
			}
			if (target_understands.getTarget_understand() != 0) {
				pStmt.setString(6, "%" + Integer.toString(target_understands.getTarget_understand()) + "%");
			}
			else {
				pStmt.setString(6, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Target_understands new_target = new Target_understands(
					rs.getInt("id"),
					rs.getString("target_id"),
					rs.getString("item_id"),
					rs.getString("user_id"),
					rs.getDate("day"),
					rs.getInt("target_understand")
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

	//現在時刻はサーブレット側で取得してJavaBeansに格納しておく
	public boolean insert(Target_understands target_understands){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "insert into Target_understands (id, target_id, item_id, user_id, day, target_understand) values (?, ?, ? ,? ,? ,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (target_understands.getId() != 0) {
				pStmt.setString(1, Integer.toString(target_understands.getId()));
			}
			else {
				pStmt.setString(1, null);
			}
			if (target_understands.getTarget_id() != null && !target_understands.getTarget_id().equals("")) {
				pStmt.setString(2, target_understands.getTarget_id());
			}
			else {
				pStmt.setString(2, null);
			}
			if (target_understands.getItem_id() != null && !target_understands.getItem_id().equals("")) {
				pStmt.setString(3, target_understands.getItem_id());
			}
			else {
				pStmt.setString(3, null);
			}
			if (target_understands.getUser_id() != null && !target_understands.getUser_id().equals("")) {
				pStmt.setString(4, "%" + target_understands.getUser_id() + "%");
			}
			else {
				pStmt.setString(4, null);
			}
			if (target_understands.getDay() != null) {
				pStmt.setString(5, "%" + target_understands.getDay() + "%");
			}
			else {
				pStmt.setString(5, null);
			}
			if (target_understands.getTarget_understand() != 0) {
				pStmt.setString(6, "%" + Integer.toString(target_understands.getTarget_understand()) + "%");
			}
			else {
				pStmt.setString(6, null);
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
