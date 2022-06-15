package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Test_days;


/**
 * Servlet implementation class Test_daysDAO
 */
public class Test_daysDAO  {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	//SQL文で「？」に穴埋めして検索したいのは資格名のため、List<Certifications>にしてみる
	public List<Test_days> select(Test_days param) {
		Connection conn = null;
		List<Test_days> Test_daysList = new ArrayList<Test_days>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "SELECT TEST_DAYS .certification_id as ID, TEST_DAYS .testdays as DAY FROM CERTIFICATIONS ,Test_days WHERE  Certifications .certification_id =Test_days .certification_id AND CERTIFICATIONS .CERTIFICATION LIKE ? ORDER BY testdays;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getCertification() != null) {
				pStmt.setString(1, "%" + param.getCertification() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Test_days days = new Test_days(
				rs.getString("ID"),
				rs.getString("DAY")
				);
				Test_daysList.add(days);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			Test_daysList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			Test_daysList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					Test_daysList = null;
				}
			}
		}

		// 結果を返す
		return Test_daysList;
	}



	//以下、My資格DAOに移動する

//	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
//	// cardより適切な単語はあるが、なるべくデフォルトで進めることにする
//	public boolean insert(Test_days card) {
//		Connection conn = null;
//		boolean result = false;
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
//
//			// SQL文を準備する
////テーブルをどうするか決めてからやらないと、後々大幅調整が必要そう
//			String sql = "insert into BC (NAME, DEP,PHONE,EMAIL,CO) values (?, ?,?, ?,?)";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			// SQL文を完成させる
//
////			if (card.getName() != null && !card.getName().equals("")) {
////				pStmt.setString(1, card.getName());
////			}
////			else {
////				pStmt.setString(1, null);
////			}
//
//
//
//			// SQL文を実行する
//			if (pStmt.executeUpdate() == 1) {
//				result = true;
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		// 結果を返す
//		return result;
//	}


}
