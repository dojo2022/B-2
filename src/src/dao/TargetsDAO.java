package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import model.Targets;

/**
 * Servlet implementation class TargetsDAO
 */
@WebServlet("/TargetsDAO")
public class TargetsDAO {
	public List<Targets> select(Targets targets) {
		Connection conn = null;
		List<Targets> targetsList = new ArrayList<Targets>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "select * from Targets WHERE id = ? AND target_id = ? AND item_id = ? AND target LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (targets.getId() != 0) {
				pStmt.setString(1, Integer.toString(targets.getId()));
			}
			else {
				pStmt.setString(1, "%");
			}
			if (targets.getTarget_id() != null && !targets.getTarget_id().equals("")) {
				pStmt.setString(2, targets.getTarget_id());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (targets.getItem_id() != null && !targets.getItem_id().equals("")) {
				pStmt.setString(3, targets.getItem_id());
			}
			else {
				pStmt.setString(3, "%");
			}
			if (targets.getTarget() != null && !targets.getTarget().equals("")) {
				pStmt.setString(4, "%" + targets.getTarget() + "%");
			}
			else {
				pStmt.setString(4, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Targets new_target = new Targets(
					Integer.parseInt(rs.getString("id")),
					rs.getString("target_id"),
					rs.getString("item_id"),
					rs.getString("target")
					);
				targetsList.add(new_target);
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
		return targetsList;
	}
}
