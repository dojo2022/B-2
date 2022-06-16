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
			String sql = "select * from Today_targets WHERE id = ? AND user_id = ? AND item_id = ? AND today_target = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (today_targets.getId() != -1) {
				pStmt.setString(1, Integer.toString(today_targets.getId()));
			}
			else {
				pStmt.setString(1, "%");
			}
			if (today_targets.getUser_id() != null && !today_targets.getUser_id().equals("")) {
				pStmt.setString(2, today_targets.getUser_id());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (today_targets.getItem_id() != null && !today_targets.getItem_id().equals("")) {
				pStmt.setString(3, today_targets.getItem_id());
			}
			else {
				pStmt.setString(3, "%");
			}
			if (today_targets.getToday_target() != -1) {
				pStmt.setString(4, Integer.toString(today_targets.getToday_target()));
			}
			else {
				pStmt.setString(4, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Today_targets new_target = new Today_targets(
					rs.getInt("id"),
					rs.getString("user_id"),
					rs.getString("item_id"),
					rs.getInt("today_target")
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
}
