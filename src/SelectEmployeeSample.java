import java.sql.Connection;		// DBMSへの接続の準備を行う
import java.sql.DriverManager;	// DBMSへの接続や切断を行う
import java.sql.PreparedStatement;	// SQLの送信を行う
import java.sql.ResultSet;		// DBMSから検索結果を受け取る
import java.sql.SQLException;	// DBに関するエラー情報を提供する

public class SelectEmployeeSample {
	public static void main (String[] args) {
		Connection conn = null;

		try {
			// JDBCドライバを読み込み
			Class.forName("org.h2.Driver");

			// データベースへ接続
			conn = DriverManager.getConnection(" jdbc:h2:tcp://localhost/~/example", "sa", "");

			// SELECT文を準備
			String sql = "SELECT ID, NAME, AGE, FROM EMPLOYEE";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SELECTを実行し、結果表(ResultSet)を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコード内容を表示
			while(rs.next()) {

				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				// 取得したデータを出力
				System.out.println("ID:" + id);
				System.out.println("NAME:" + name);
				System.out.println("AGE:" + age + "¥n");

			}
		} catch (SQLException e) {
			e.printStackTrace();	// 接続やSQL処理の失敗時の処理
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	// JDBCドライバが見つからないときの処理
		} finally {
			// データベースの切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();    // 切断失敗時の処理
				}
			}
		}
	}
}
