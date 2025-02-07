package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.History;

public class HistoryDao extends Dao{

	public List<History> getEmployeeHistory(String user_id) throws Exception {
		// 学校インスタンスを初期化
		List<History> history_list = new ArrayList<>();
		// データベースへのコネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("SELECT DISTINCT "

							+ "H.SCORE,"
							+ "U.USER_NAME,"
							+ "H.UNIT_ID,"
							+ "UN.UNIT_NAME,"
							+ "H.CHAPTER_ID,"
							+ "C.CHAPTER_NAME "

							+ "FROM HISTORY H "

							 + "JOIN USERACCOUNTS U ON H.USER_ID = U.USER_ID "
							 + "JOIN UNIT UN ON H.UNIT_ID = UN.UNIT_ID "
							 + "JOIN CHAPTER C ON H.CHAPTER_ID = C.CHAPTER_ID "
							 + "AND H.UNIT_ID = C.UNIT_ID "

							+ "WHERE H.USER_ID=? ");

			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, user_id);
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			while (rSet.next()) {
				History history = new History();
				// リザルトセットが存在する場合
				// 学校インスタンスに学校コードと学校名をセット
				history.setScore(rSet.getInt("score"));
				history.setUserName(rSet.getString("user_name"));
				history.setUnitId(rSet.getString("unit_id"));
				history.setUnitName(rSet.getString("unit_name"));
				history.setChapterName(rSet.getString("chapter_name"));
				history_list.add(history);
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
		return history_list;
	}

	public List<History> getUintHistory(String unit_id) throws Exception {
		List<History> history_list = new ArrayList<>();
		// 学校インスタンスを初期化
		// データベースへのコネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("SELECT DISTINCT "

					        + "H.SCORE,"
							+ "H.USER_ID,"
							+ "U.USER_NAME,"
							+ "UN.UNIT_NAME,"
							+ "C.CHAPTER_NAME "

							+ "FROM HISTORY H "

							 + "JOIN USERACCOUNTS U ON H.USER_ID = U.USER_ID "
							 + "JOIN UNIT UN ON H.UNIT_ID = UN.UNIT_ID "
							 + "JOIN CHAPTER C ON H.CHAPTER_ID = C.CHAPTER_ID "
							 + "AND H.UNIT_ID = C.UNIT_ID "

							+ "WHERE H.UNIT_ID=?");

			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, unit_id);
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			while (rSet.next()) {
				// リザルトセットが存在する場合
				// 学校インスタンスに学校コードと学校名をセット
				History history = new History();
				history.setScore(rSet.getInt("score"));
				history.setUserId(rSet.getString("user_id"));
				history.setUserName(rSet.getString("user_name"));
				history.setUnitName(rSet.getString("unit_name"));
				history.setChapterName(rSet.getString("chapter_name"));
				history_list.add(history);
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
		return history_list;
	}

	public List<History> getEmployee() throws Exception {
		// 学校インスタンスを初期化
		List<History> history_list = new ArrayList<>();
		// データベースへのコネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("SELECT USER_ID,USER_NAME FROM USERACCOUNTS");
			// プリペアードステートメントに学校コードをバインド

			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			while (rSet.next()) {
				History history = new History();
				// リザルトセットが存在する場合
				// 学校インスタンスに学校コードと学校名をセット
				history.setUserId(rSet.getString("user_id"));
				history.setUserName(rSet.getString("user_name"));
				history_list.add(history);

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
		return history_list;
	}

	public List<History> getUnit() throws Exception {
		// 学校インスタンスを初期化
		List<History> history_list = new ArrayList<>();
		// データベースへのコネクションを確率
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try {
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("SELECT UNIT_ID,UNIT_NAME FROM UNIT");
			// プリペアードステートメントに学校コードをバインド

			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			while (rSet.next()) {
				History history = new History();
				// リザルトセットが存在する場合
				// 学校インスタンスに学校コードと学校名をセット
				history.setUnitId(rSet.getString("unit_id"));
				history.setUnitName(rSet.getString("unit_name"));
				history_list.add(history);

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
		return history_list;
	}
}