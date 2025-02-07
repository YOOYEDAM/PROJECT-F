package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Employee;
import bean.TestListEmployee;

public class TestListEmployeeDao extends Dao {

	/**
	 * baseSql:String 共通SQL文 プライベート
	 */
	private String baseSql = "SELECT SJ.name as sj_name, SJ.cd as sj_cd, T.no as t_no, T.point as t_point "
			+ "FROM student ST inner join (test T inner join subject SJ on T.subject_cd=SJ.cd) "
			+ "on ST.no=T.student_no ";

	/**
	 * postFilterメソッド フィルター後のリストへの格納処理 プライベート
	 *
	 * @param rSet:リザルトセット
	 * @return 社員成績表示用のリスト:List<TestListStudent> 存在しない場合は0件のリスト
	 * @throws Exception
	 */
	private List<TestListEmployee> postFilter(ResultSet rSet) throws Exception {
		List<TestListEmployee> list = new ArrayList<>();

		while (rSet.next()) {
			TestListEmployee test = new TestListEmployee();
			test.setNum(rSet.getInt("t_no"));
			test.setPoint(rSet.getInt("t_point"));
			test.setSubjectCd(rSet.getString("sj_cd"));
			test.setEmployeeName(rSet.getString("sj_name"));

			list.add(test);
		}
		return list;
	}

	/**
	 * filterメソッド 学生を指定して学生成績表示用の一覧を取得する
	 *
	 * @param employee:Employee
	 *            社員
	 * @return 社員成績表示用のリスト:List<TestListEmployee> 存在しない場合は0件のリスト
	 * @throws Exception
	 */
	public List<TestListEmployee> filter(Employee employee) throws Exception {
		List<TestListEmployee> list = new ArrayList<>();
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet rSet = null;

		String condition = "where ST.no=?";
		String order = " order by SJ.cd asc, T.no asc";

		try {
			statement = connection.prepareStatement(baseSql + condition + order);
			statement.setString(1, employee.getNo());
			rSet = statement.executeQuery();

			list = postFilter(rSet);
		} catch (Exception e) {
			throw e;
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sqle) {
					throw sqle;
				}
			}
		}

		return list;
	}
}
