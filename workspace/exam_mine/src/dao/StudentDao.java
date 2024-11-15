package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao{
    private String baseSql = "select * from student where school_cd=? ";

    /**
     * postFilterメソッド フィルター後のリストへの格納処理 プライベート
     *
     * @param rSet:リザルトセット
     * @param school:School
     *            学校
     * @return 学生のリスト:List<Student> 存在しない場合は0件のリスト
     * @throws Exception
     */
    private List<Student> postFilter(ResultSet rSet, School school) throws Exception {
        // リストを初期化
        List<Student> list = new ArrayList<>();
        try {
            // リザルトセットを全権走査
            while (rSet.next()) {
                // 学生インスタンスを初期化
                Student student = new Student();
                // 学生インスタンスに検索結果をセット
                student.setNo(rSet.getString("no"));
                System.out.println(rSet.getString("no"));
                student.setName(rSet.getString("name"));
                System.out.println(rSet.getString("name"));
                student.setEntYear(rSet.getInt("ent_year"));
                System.out.println(rSet.getInt("ent_year"));
                student.setClassNum(rSet.getString("class_num"));
                System.out.println(rSet.getString("class_num"));
                student.setAttend(rSet.getBoolean("is_attend"));
                System.out.println(rSet.getBoolean("is_attend"));
                student.setSchool(school);
                // リストに追加
                list.add(student);
            }
        } catch (SQLException | NullPointerException e) {
            e.printStackTrace();
        }

        return list;
    }


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
    public List<Student> filter(School school, boolean isAttend) throws Exception {
        // リストを初期化
        List<Student> list = new ArrayList<>();
        // コネクションを確立
        Connection connection = getConnection();
        // プリペアードステートメント
        PreparedStatement statement = null;
        // リザルトセット
        ResultSet rSet = null;
        // SQL文の条件
        String order = " order by no asc";

        // SQL文の在学フラグ
        String conditionIsAttend = "";
        // 在学フラグがtrueの場合
        if (isAttend) {
            conditionIsAttend = "and is_attend=true";
        }

        try {
            // プリペアードステートメントにSQL文をセット
            statement = connection.prepareStatement(baseSql + conditionIsAttend + order);
            // プリペアードステートメントに学校コードをバインド
            statement.setString(1, school.getCd());
            // プリペアードステートメントを実行
            rSet = statement.executeQuery();
            // リストへの格納処理を実行
            list = postFilter(rSet, school);
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

        return list;
    }




}