package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import model.Users;
/**
 * Servlet implementation class UsersDAO
 */
@WebServlet("/UsersDAO")
public class UsersDAO  {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users Users) {
		Connection conn = null;
		boolean loginResult = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SELECT文を準備する
			String sql = "select count(*) from Users where USERNAME = ? and PASSWORD = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, Users.getUsername());
			pStmt.setString(2,Users.getPassword());
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//テーブルのような形で受け取る
			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			//テーブルの一行目(count(*))に焦点を当てる
			//rs.next();
			//テーブルの二行目に焦点を当てる
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}
		// 結果を返す
		return loginResult;
	}
	// 引数regisyで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Users regist) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "insert into Users (username, password,mail) values (?,?,?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (regist.getUsername() != null && !regist.getUsername().equals("")) {
				pStmt.setString(1,regist.getUsername());
			}
			else {
				pStmt.setString(1, null);
			}
			if (regist.getPassword() != null && !regist.getPassword().equals("")) {
				pStmt.setString(2, regist.getPassword());
			}
			else {
				pStmt.setString(2, null);
			}
			if (regist.getMail() != null && !regist.getMail().equals("")) {
				pStmt.setString(3, regist.getMail());
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

	public boolean insert_update() {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "UPDATE Users SET  user_id=(SELECT CONCAT('u',id) FROM Users WHERE user_id IS NULL) WHERE user_id IS NULL";
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



//ユーザ設定で使用するDAO
	//old_usernameからold_mail,old_pw(ログインユーザーのメールアドレスとパスワード)を取得する
	//ユーザ設定で入力なしの場合に現状のものを再設定するため
	 public List<Users> select(Users param) {
		Connection conn = null;
		List<Users> cardList = new ArrayList<Users>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
			// SQL文を準備する
			String sql = "SELECT address, password from Users WHERE username LIKE ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (param.getOld_username() != null) {
				pStmt.setString(1,   param.getOld_username() );
			}
			else {
				pStmt.setString(1, "%" + param.getOld_username() + "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Users card = new Users(
				rs.getString("address"),
				rs.getString("password")
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
	// 引数Usersで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Users users) {
			Connection conn = null;
			boolean result = false;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
				// SQL文を準備する
				String sql = "update Users set USERNAME=?, PASSWORD=?, MAIL=?  where USERNAME=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				if (users.getUsername() != null && !users.getUsername().equals("")) {
					pStmt.setString(1, users.getUsername());
				}
				else {
					pStmt.setString(1, "");
				}
				if (users.getPassword() != null && !users.getPassword().equals("")) {
					pStmt.setString(2, users.getPassword());
				}
				else {
					pStmt.setString(2, "");
				}
				if (users.getMail() != null && !users.getMail().equals("")) {
					pStmt.setString(3, users.getMail());
				}
				else {
					pStmt.setString(3, "");
				}
				if (users.getOld_username() != null && !users.getOld_username().equals("")) {
					pStmt.setString(4, users.getOld_username());
				}
				else {
					pStmt.setString(4, "");
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
		public String getUser_id(String username) {
        	Connection conn = null;
    		String result = null;
    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");
    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
    			// SQL文を準備する
    			String sql = "SELECT user_id from Users WHERE username = ?";
    			PreparedStatement pStmt = conn.prepareStatement(sql);
    			// SQL文を完成させる
				pStmt.setString(1, username);
    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();
    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				result = rs.getString("user_id");
    			}
    		}
    		catch (SQLException e) {
    			e.printStackTrace();
    			result = null;
    		}
    		catch (ClassNotFoundException e) {
    			e.printStackTrace();
    			result = null;
    		}
    		finally {
    			// データベースを切断
    			if (conn != null) {
    				try {
    					conn.close();
    				}
    				catch (SQLException e) {
    					e.printStackTrace();
    					result = null;
    				}
    			}
    		}
    		// 結果を返す
    		return result;
        }
}