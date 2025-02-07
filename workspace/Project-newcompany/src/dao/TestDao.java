package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Company;
import bean.Employee;
import bean.Subject;
import bean.Test;


public class TestDao extends Dao {
    /**
     * getメソッド 学生、科目、学校、回数を指定して成績インスタンスを1権取得する
     *
     * @param employee:Employee
     *            社員
     * @param subject:Subject
     *            科目
     * @param school:School
     *            学校
     * @param no:int
     *            回数
     * @return
     * @throws Exception
     */
    public Test get(Employee employee, Subject subject, Company school, int no) throws Exception {
        // 成績インスタンスを初期化
        Test test = new Test();

        Connection connection = getConnection();
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(
                    "select * from test where student_no=? and subject_cd=? and school_cd=? and no=?");
            statement.setString(1, employee.getNo());
            statement.setString(2, subject.getCd());
            statement.setString(3, school.getCd());
            statement.setInt(4, no);
            ResultSet rSet = statement.executeQuery();

            if (rSet.next()) {
                test.setEmployee(employee);
                test.setSubject(subject);
                test.setSchool(school);
                test.setNo(no);
                test.setPoint(rSet.getInt("point"));
            } else {
                test = null;
            }
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

        return test;
    }

    /**
     * baseSql:String 共通SQL文 プライベート
     */
    private String baseSql = "SELECT SJ.cd as sj_cd, SJ.name as sj_name, ST.no as st_no, ST.name as st_name, "
            + "ST.ent_year as st_ent_year, ST.class_num as st_class_num, ST.is_attend as st_is_attend, "
            + "T.no as t_no, coalesce(T.point, -1) as t_point "
            + "FROM student ST left outer join (test T inner join subject SJ on T.subject_cd=SJ.cd) "
            + "on ST.no=T.student_no ";

    /**
     * postFilterメソッド フィルター後のリストへの格納処理 プライベート
     *
     * @param rSet:リザルトセット
     * @param school:School
     *            学校
     * @return 成績のリスト:List<Student> 存在しない場合は0件のリスト
     * @throws Exception
     */
    private List<Test> postFilter(ResultSet rSet, Company school) throws Exception {
        // リストを初期化
        List<Test> list = new ArrayList<>();
        // リザルトセットを全件走査
        while (rSet.next()) {
            // 科目インスタンス
            Subject subject = new Subject();
            subject.setCd(rSet.getString("sj_cd"));
            subject.setName(rSet.getString("sj_name"));
            subject.setSchool(school);

            // 学生インスタンス
            Employee employee = new Employee();
            employee.setNo(rSet.getString("st_no"));
            employee.setName(rSet.getString("st_name"));
            employee.setEntYear(rSet.getInt("st_ent_year"));
            employee.setClassNum(rSet.getString("st_class_num"));
            employee.setAttend(rSet.getBoolean("st_is_attend"));
            employee.setSchool(school);

            // 成績インスタンス
            Test test = new Test();
            test.setEmployee(employee);
            test.setClassNum(rSet.getString("st_class_num"));
            test.setSubject(subject);
            test.setSchool(school);
            test.setNo(rSet.getInt("t_no"));
            test.setPoint(rSet.getInt("t_point"));

            // リストに追加
            list.add(test);
        }

        return list;
    }

    /**
     * filterメソッド 入学年度、クラス番号、科目、回数、学校を指定して成績の一覧を取得する
     *
     * @param entYear:int
     *            入学年度
     * @param classNum:String
     *            クラス番号
     * @param subject:Subject
     *            科目
     * @param num:int
     *            回数
     * @param school：School
     *            学校
     * @return 成績のリスト:List<Test> 存在しない場合は0件のリスト
     * @throws Exception
     */
    public List<Test> filter(int entYear, String classNum, Subject subject, int num, Company school) throws Exception {
        // リストを初期化
        List<Test> list = new ArrayList<>();

        Connection connection = getConnection();
        PreparedStatement statement = null;
        ResultSet rSet = null;

        // SQL文の条件
        String condition = "and T.subject_cd=? and T.no=? "
                + "where ST.ent_year=? and ST.class_num=? and ST.school_cd=? and ST.is_attend=true";
        // SQL文のソート
        String order = " order by ST.no asc";

        try {
            statement = connection.prepareStatement(baseSql + condition + order);
            statement.setString(1, subject.getCd());
            statement.setInt(2, num);
            statement.setInt(3, entYear);
            statement.setString(4, classNum);
            statement.setString(5, school.getCd());
            rSet = statement.executeQuery();

            list = postFilter(rSet, school);
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

    /**
     * saveメソッド 成績のリストをデータベースに保存する データが存在する場合は更新、存在しない場合は登録
     * 全て正常終了した場合にのみコミットし、それ以外はロールバックする
     *
     * @param list:List<Test>
     *            成績のリスト
     * @return 成功:true, 失敗:false
     * @throws Exception
     */
    public boolean save(List<Test> list) throws Exception {
        Connection connection = getConnection();
        int count = 0;

        try {
            for (Test test : list) {
                if (test != null) {
                    boolean result = TestDao.save(test, connection);
                    if (result) {
                        count++;
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {
                    throw sqle;
                }
            }
        }

        return count > 0;
    }

    /**
     * saveメソッド プライベート 成績インスタンスをデータベースに保存する データが存在する場合は更新、存在しない場合は登録
     *
     * @param test:Test
     *            成績
     * @return 成功:true, 失敗:false
     * @throws Exception
     */
    private static boolean save(Test test, Connection connection) throws Exception {
        PreparedStatement statement = null;
        int count = 0;

        try {
            if (test != null) {
                // まず、update文を実行
                statement = connection.prepareStatement(
                        "UPDATE test SET point=? WHERE employee_no=? AND subject_cd=? AND school_cd=? AND no=? AND class_num=?");
                Employee employee = test.getEmployee();
                Subject subject = test.getSubject();
                Company school = test.getSchool();

                statement.setInt(1, test.getPoint());
                statement.setString(2, employee.getNo());
                statement.setString(3, subject.getCd());
                statement.setString(4, school.getCd());
                statement.setInt(5, test.getNo());
                statement.setString(6, test.getClassNum());

                count = statement.executeUpdate();
                statement.close();

                // 更新件数が0件の場合はinsert文を実行
                if (count == 0) {
                    statement = connection.prepareStatement(
                            "INSERT INTO test (employee_no, subject_cd, school_cd, no, class_num, point) VALUES (?, ?, ?, ?, ?, ?)");

                    statement.setString(1, employee.getNo());
                    statement.setString(2, subject.getCd());
                    statement.setString(3, school.getCd());
                    statement.setInt(4, test.getNo());
                    statement.setString(5, test.getClassNum());
                    statement.setInt(6, test.getPoint());

                    count = statement.executeUpdate();
                }
            }
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
        }

        return count > 0;
    }
/**
 * deleteメソッド 社員をデータベースから削除する
 *
 * @param employee:Employee
 * @return 成功:true, 失敗:false
 * @throws Exception
 */
public boolean delete(Employee student) throws Exception {
	// コネクションを確立
	Connection connection = getConnection();
	// プリペアードステートメント
	PreparedStatement statement = null;
	// 実行件数
	int count = 0;

	try {
		// プリペアードステートメントにDELETE文をセット
		statement = connection.prepareStatement("delete from student where no=?");
		// プリペアードステートメントに学生番号をバインド
		statement.setString(1, student.getNo());
		// プリペアードステートメントを実行
		count = statement.executeUpdate();
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

	if (count > 0) {
		// 実行件数が1件以上ある場合
		return true;
	} else {
		// 実行件数が0件の場合
		return false;
	}
}
}