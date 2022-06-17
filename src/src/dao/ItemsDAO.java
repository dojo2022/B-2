package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Items;




public class ItemsDAO {
	 public List<Items> select(Items param) {
		Connection conn = null;
		List<Items> cardList = new ArrayList<Items>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT certification_id, item_id,item, item_page from Items WHERE certification_id LIKE ? AND item_id LIKE ? item LIKE ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getCertification_id() != null) {
				pStmt.setString(1,   param.getCertification_id() );
			}
			else {
				pStmt.setString(1, "%" + param.getCertification_id() + "%");
			}
			if (param.getItem_id() != null) {
				pStmt.setString(2, "%" + param.getItem_id() + "%");
			}
			else {
				pStmt.setString(2, "%");
			}
			if (param.getItem() != null) {
				pStmt.setString(3, "%" + param.getItem() + "%");
			}
			else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Items card = new Items(
				rs.getString("certification_id"),
				rs.getString("item_id"),
				rs.getString("item"),
				rs.getInt("item_page")
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

	 public String getItem(String item_id) {
     	Connection conn = null;
 		String result = null;

 		try {
 			// JDBCドライバを読み込む
 			Class.forName("org.h2.Driver");

 			// データベースに接続する
 			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

 			// SQL文を準備する
 			String sql = "SELECT item from items WHERE item_id = ?";
 			PreparedStatement pStmt = conn.prepareStatement(sql);

 			// SQL文を完成させる
				pStmt.setString(1, item_id);


 			// SQL文を実行し、結果表を取得する
 			ResultSet rs = pStmt.executeQuery();

 			// 結果表をコレクションにコピーする
 			while (rs.next()) {
 				result = rs.getString("item");
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
