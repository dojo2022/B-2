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
			String sql = "select * from Target_understands WHERE target_id LIKE ? AND item_id LIKE ? AND user_id LIKE ? AND day LIKE ? AND target_understand LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (target_understands.getTarget_id() != null && !target_understands.getTarget_id().equals("")) {
				pStmt.setString(1, target_understands.getTarget_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if (target_understands.getItem_id() != null && !target_understands.getItem_id().equals("")) {
				pStmt.setString(2, target_understands.getItem_id());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (target_understands.getUser_id() != null && !target_understands.getUser_id().equals("")) {
				pStmt.setString(3, target_understands.getUser_id());
			}
			else {
				pStmt.setString(3, "%");
			}
			if (target_understands.getDay() != null && !target_understands.getDay().equals("")) {
				pStmt.setString(4, target_understands.getDay());
			}
			else {
				pStmt.setString(4, "%");
			}
			if (target_understands.getTarget_understand() != null && !target_understands.getTarget_understand().equals("")) {
				pStmt.setString(5, target_understands.getTarget_understand());
			}
			else {
				pStmt.setString(5, "%");
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
					rs.getString("day"),
					rs.getString("target_understand")
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

	//資格登録時item_id,target_id検索用
	public List<Target_understands> insert_select(Target_understands target_understands){
		Connection conn = null;
		List<Target_understands> resultList = new ArrayList<Target_understands>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "SELECT Targets.item_id as ID,Targets.target_id as DAY FROM Targets,CERTIFICATIONS WHERE CERTIFICATIONS .certification_id= (SELECT certification_id FROM Certifications WHERE Certifications.certification = ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (target_understands.getCertification() != null && !target_understands.getCertification().equals("")) {
				pStmt.setString(1, target_understands.getCertification());
			}
			else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Target_understands days = new Target_understands(
				rs.getString("ID"),
				rs.getString("DAY")
				);
				resultList.add(days);
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
			// SQL文を準備する-の準備をする
				//user_id
				String selectuserSql = "SELECT user_id FROM Users WHERE username = ?";
				PreparedStatement selectuserStmt = conn.prepareStatement(selectuserSql);
				selectuserStmt.setString(1,target_understands.getUsername() );
				// SQL文を実行し、結果表を取得する
				ResultSet rs = selectuserStmt.executeQuery();
				rs.next();
				//ユーザidを使えるように定義
				String user_id = rs.getString("user_id");

			// SQL文を準備する
			String sql = "insert into Target_understands (target_id, item_id, user_id) values (? ,? ,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1,target_understands.getTarget_id());
			pStmt.setString(2,target_understands.getItem_id());
			pStmt.setString(3,user_id);

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

	//item_id, user_idの場所のdayとtarget_understandを更新
	public boolean update(Target_understands target_understands){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "update Target_understands set day = ?, target_understand = ? WHERE item_id LIKE ? AND user_id LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (target_understands.getDay() != null) {
				pStmt.setString(1, target_understands.getDay());
			}
			else {
				pStmt.setString(1, null);
			}
			if (target_understands.getTarget_understand() != null) {
				pStmt.setString(2, target_understands.getTarget_understand());
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
				pStmt.setString(4, target_understands.getUser_id());
			}
			else {
				pStmt.setString(4, null);
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

	//item_id, user_idの場所のdayとtarget_understandを更新
	public boolean delete(Target_understands target_understands){
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "delete from Target_understands WHERE item_id = ? AND user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (target_understands.getItem_id() != null && !target_understands.getItem_id().equals("")) {
				pStmt.setString(1, target_understands.getItem_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (target_understands.getUser_id() != null && !target_understands.getUser_id().equals("")) {
				pStmt.setString(2, "%" + target_understands.getUser_id() + "%");
			}
			else {
				pStmt.setString(2, null);
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

	public int getCount(Target_understands target_understands){
		Connection conn = null;
		int count = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "SELECT count(*) FROM Target_understands WHERE item_id LIKE ? AND user_id LIKE ? AND target_understand LIKE ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (target_understands.getItem_id() != null && !target_understands.getItem_id().equals("")) {
				pStmt.setString(1, target_understands.getItem_id());
			}
			else {
				pStmt.setString(1, "%");
			}
			if (target_understands.getUser_id() != null && !target_understands.getUser_id().equals("")) {
				pStmt.setString(2, target_understands.getUser_id());
			}
			else {
				pStmt.setString(2, "%");
			}
			if (target_understands.getTarget_understand() != null && !target_understands.getTarget_understand().equals("")) {
				pStmt.setString(3, target_understands.getTarget_understand());
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				count = rs.getInt("count(*)");
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

		return count;
	}
}
