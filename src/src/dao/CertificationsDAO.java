package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Certifications;
    public class CertificationsDAO {
        // 引数paramで検索項目を指定し、検索結果のリストを返す
        public List<Certifications> select(Certifications param) {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT id, CERTIFICATION_ID, certification, category from CERTIFICATIONS WHERE category LIKE ? ORDER BY CERTIFICATION_ID";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                // SQL文を完成させる
                if (param.getCategory() != null) {
                    pStmt.setString(1, "%" + param.getCategory() + "%");
                }
                else {
                    pStmt.setString(1, "%");
                }
                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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

        // テキスト検索
        public List<Certifications> select_certification(String certification,String category) {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");

                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

                // SQL文を準備する（資格の検索）
                String sql = "SELECT certification,category from CERTIFICATIONS WHERE certification LIKE ? and category LIKE ?";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を完成させる
                if (certification != null) {
                    pStmt.setString(1, "%" + certification + "%");
                }
                else {
                    pStmt.setString(1, "%");
                }
                if (category != null) {
                    pStmt.setString(2, "%" + category + "%");
                }
                else {
                    pStmt.setString(2, "%");
                }

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();

                // 結果表をコレクションにコピーする
                while (rs.next()) {
                	Certifications certifications = new Certifications(
                	rs.getString("certification"),
                	rs.getString("category"),
                	null);
                    cardList.add(certifications);
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


        public List<Certifications> select_category(String category) {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT certification, category,level from CERTIFICATIONS WHERE category LIKE ?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                // SQL文を完成させる
                if (category != null) {
                    pStmt.setString(1, "%" + category + "%");
                }
                else {
                    pStmt.setString(1, "%");
                }
                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("certification"),
                    rs.getString("category"),
                    rs.getString("level")
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
        public List<Certifications> select_level(Certifications param) {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT certification, category, level from CERTIFICATIONS WHERE category LIKE ? AND level LIKE ?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                // SQL文を完成させる
                if (param.getCategory() != null) {
                    pStmt.setString(1, "%" + param.getCategory() + "%");
                }
                else {
                    pStmt.setString(1, "%");
                }
                if (param.getLevel() != null) {
                    pStmt.setString(2, "%" + param.getLevel() + "%");
                }
                else {
                    pStmt.setString(2, "%");
                }
                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("certification"),
                    rs.getString("category"),
                    rs.getString("level")
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
        public List<Certifications> select_all() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");

                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();

                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_allit() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");

                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications WHERE category = 'IT知識全般'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();

                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_gengo() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications WHERE category = 'IT言語'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_data() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications WHERE category = 'データベース'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_sec() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications WHERE category = 'セキュリティ'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_net() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certification WHERE category = 'ネットワーク'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_mana() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications WHERE category = 'マネジメント'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_jimu() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications WHERE category = '事務作業'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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
        public List<Certifications> select_des() {
            Connection conn = null;
            List<Certifications> cardList = new ArrayList<Certifications>();
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する（資格の検索）
                String sql = "SELECT * from certifications WHERE category = 'デザイン'";
                PreparedStatement pStmt = conn.prepareStatement(sql);

                // SQL文を実行し、結果表を取得する
                ResultSet rs = pStmt.executeQuery();
                // 結果表をコレクションにコピーする
                while (rs.next()) {
                    Certifications card = new Certifications(
                    rs.getString("id"),
                    rs.getString("certification_id"),
                    rs.getString("certification"),
                    rs.getString("category")
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


        // 引数idで指定されたレコードを削除し、成功したらtrueを返す
        public boolean delete(String id) {
            Connection conn = null;
            boolean result = false;
            try {
                // JDBCドライバを読み込む
                Class.forName("org.h2.Driver");
                // データベースに接続する
                conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
                // SQL文を準備する
                String sql = "delete from Certifications where id=?";
                PreparedStatement pStmt = conn.prepareStatement(sql);
                // SQL文を完成させる
                pStmt.setString(1, id);
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

        public String getCertification(String certification_id) {
        	Connection conn = null;
    		String result = null;

    		try {
    			// JDBCドライバを読み込む
    			Class.forName("org.h2.Driver");

    			// データベースに接続する
    			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

    			// SQL文を準備する
    			String sql = "SELECT certification from certifications WHERE certification_id = ?";
    			PreparedStatement pStmt = conn.prepareStatement(sql);

    			// SQL文を完成させる
				pStmt.setString(1, certification_id);


    			// SQL文を実行し、結果表を取得する
    			ResultSet rs = pStmt.executeQuery();

    			// 結果表をコレクションにコピーする
    			while (rs.next()) {
    				result = rs.getString("certification");
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
