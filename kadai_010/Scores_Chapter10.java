package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;

public class Scores_Chapter10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		 Connection con = null;
	        Statement statement = null;

	        try {
	            // データベースに接続
	            con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/challenge_java",
	                "root",
	                "02Maru21-21"
	            );

	            System.out.println("データベース接続成功");

	            // SQLクエリを準備
	            statement = con.createStatement();
	            String sql = "UPDATE scores SET score_math = 95, score_english = 80 WHERE id = 5;";

	            // SQLクエリを実行（DBMSに送信）
	            System.out.println("レコード更新:" + statement.toString() );
	            int rowCnt = statement.executeUpdate(sql);
	            System.out.println( rowCnt + "件のレコードが更新されました");
	        } catch(SQLException e) {
	            System.out.println("エラー発生：" + e.getMessage());
	        } finally {
	            // 使用したオブジェクトを解放
	            if( statement != null ) {
	                try { statement.close(); } catch(SQLException ignore) {}
	            }
	            if( con != null ) {
	                try { con.close(); } catch(SQLException ignore) {}
	            }
	        }
	        
	        Connection con1 = null;
	        Statement statement1 = null;

	        try {
	        	
		        

	            // データベースに接続
	            con1 = DriverManager.getConnection(
	                "jdbc:mysql://localhost/challenge_java",
	                "root",
	                "02Maru21-21"
	            );

	            System.out.println("データベース接続成功");

	            // SQLクエリを準備
	            statement1 = con1.createStatement();
	            String sql = "SELECT id, name, score_math, score_english  FROM scores ORDER BY score_math DESC, score_english DESC";


	            // SQLクエリを実行（DBMSに送信）
	            System.out.println("数学・英語の点数が高い順に並べ替えました");
	            ResultSet result = statement1.executeQuery(sql);

	            // SQLクエリの実行結果を抽出
	            while(result.next()) {
	                int id = result.getInt("id");
	                String name = result.getString("name");
	                int math = result.getInt("score_math");
	                int english = result.getInt("score_english");
	                System.out.println(result.getRow() + "件目：id=" + id
	                                   + "／name=" + name + "／score_math=" + math + "／score_english=" + english );
	            }
	        } catch(InputMismatchException e) {
	            System.out.println("入力が正しくありません");
	        } catch(SQLException e) {
	            System.out.println("エラー発生：" + e.getMessage());
	        } finally {
	            // 使用したオブジェクトを解放
	            if( statement1 != null ) {
	                try { statement1.close(); } catch(SQLException ignore) {}
	            }
	            if( con != null ) {
	                try { con.close(); } catch(SQLException ignore) {}
	            }
	        }
	        
	    }
	}


