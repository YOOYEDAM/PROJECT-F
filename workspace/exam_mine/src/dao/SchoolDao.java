package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.School;

public class SchoolDao extends Dao {
		/**
	     * filterメソッド 学校、在学フラグを指定して学生の一覧を取得する
	     *
	     * @param school:School
	     *            学校
	     * @param isAttend:boolean
	     *            在学フラグ
	     * @return 学生のリスト:List<Student> 存在しない場合は0件のリスト
	     * @throws Exception
	     */
	    public School get(String cd) throws Exception {
	        // リストを初期化
	        School school = new School();
	        // コネクションを確立
	        Connection connection = getConnection();
	        // プリペアードステートメント
	        PreparedStatement statement = null;

	        try {
	            // プリペアードステートメントにSQL文をセット
	            statement = connection.prepareStatement("select * from school where cd=?");
	            // プリペアードステートメントに学校コードをバインド
	            statement.setString(1, cd);
	            // プリペアードステートメントを実行
	            ResultSet rSet = statement.executeQuery();

	            if (rSet.next()) {
					// リザルトセットが存在する場合
					// 学校インスタンスに学校コードと学校名をセット
					school.setCd(rSet.getString("cd"));
					school.setName(rSet.getString("name"));
				} else {
					// 存在しない場合
					// 学校インスタンスにnullをセット
					school = null;
				}

	        } catch (Exception e) {
	            throw e;
	        } finally {
	            // プリペアードステートメントを閉じる
	            if (statement != null) {
	                try {
	                    statement.close();
	                } catch (SQLException sqle) {
	                    throw sqle;
	                }
	            }
	            // コネクションを閉じる
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException sqle) {
	                    throw sqle;
	                }
	            }
	        }

	        return school;
	    }
}