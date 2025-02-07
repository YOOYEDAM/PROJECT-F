package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Company;
import bean.Subject;

public class SubjectDao extends Dao {
    /**
     * getメソッド 科目コードを指定して科目インスタンスを1件取得する
     *
     * @param cd:String
     *            科目コード
     * @return 学生クラスのインスタンス 存在しない場合はnull
     * @throws Exception
     */
    public Subject get(String cd,Company school) throws Exception {
        // 学生インスタンスを初期化
        Subject subject = new Subject();
        // データベースへのコネクションを確立
        Connection connection = getConnection();
        // プリペアードステートメント
        PreparedStatement statement = null;

        try {
            // プリペアードステートメントにSQL文をセット
            statement = connection.prepareStatement("select * from subject where cd=? and school_cd=?");
            // プリペアードステートメントに学生番号をバインド
            statement.setString(1, cd);
            statement.setString(2, school.getCd());
            // プリペアードステートメントを実行
            ResultSet rSet = statement.executeQuery();

            // 学校Daoを初期化
            CompanyDao schoolDao = new CompanyDao();

            if (rSet.next()) {
                // リザルトセットが存在する場合
                // 学生インスタンスに検索結果をセット
                // 学校フィールドには学校コードで検索した学校インスタンスをセット
                subject.setSchool(schoolDao.get(rSet.getString("school_cd")));
                subject.setCd(rSet.getString("cd"));
                subject.setName(rSet.getString("name"));
            } else {
                // リザルトセットが存在しない場合
                // 学生インスタンスにnullをセット
                subject = null;
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

        return subject;
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
    public List<Subject> filter(Company school) throws Exception {
        // リストを初期化
        List<Subject> list = new ArrayList<>();
        // コネクションを確立
        Connection connection = getConnection();
        // プリペアードステートメント
        PreparedStatement statement = null;
        // リザルトセット
        ResultSet rSet = null;
        // SQL文の条件
        String order = " order by cd asc";

        try {
            // プリペアードステートメントにSQL文をセット
            statement = connection.prepareStatement("select * from subject where school_cd = ?" + order);
            // プリペアードステートメントに学校コードをバインド
            statement.setString(1, school.getCd());
            // プリペアードステートメントを実行
            rSet = statement.executeQuery();
            // リザルトセットを全権走査
                    while (rSet.next()) {
                        // 学生インスタンスを初期化
                        Subject subject= new Subject();
                        // 学生インスタンスに検索結果をセット
                        subject.setSchool(school);
                        subject.setCd(rSet.getString("cd"));
                        subject.setName(rSet.getString("name"));
                        // リストに追加
                        list.add(subject);
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

        return list;
    }

    /**
     * saveメソッド 学生インスタンスをデータベースに保存する データが存在する場合は更新、存在しない場合は登録
     *
     * @param student：Student
     *            学生
     * @return 成功:true, 失敗:false
     * @throws Exception
     */
    public boolean save(Subject subject) throws Exception {
        // コネクションを確立
        Connection connection = getConnection();
        // プリペアードステートメント
        PreparedStatement statement = null;
        // 実行件数
        int count = 0;

        try {
            // データベースから学生を取得
            Subject old = get(subject.getCd(),subject.getSchool());
            if (old == null) {
                // 科目が存在しなかった場合
                // プリペアードステートメンにINSERT文をセット
                statement = connection.prepareStatement(
                        "insert into subject(school_cd,cd,name) values(?, ?, ?)");
                // プリペアードステートメントに値をバインド
                statement.setString(1, subject.getSchool().getCd());
                statement.setString(2, subject.getCd());
                statement.setString(3, subject.getName());
            } else {
                // 科目が存在した場合
                // プリペアードステートメントにUPDATE文をセット
                statement = connection
                        .prepareStatement("update subject set name=? where cd=?");
                // プリペアードステートメントに値をバインド
                statement.setString(1, subject.getName());
                statement.setString(2, subject.getCd());
            }

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

    /**
     * deleteメソッド 学生をデータベースから削除する
     *
     * @param student:Student
     * @return 成功:true, 失敗:false
     * @throws Exception
     */
    public boolean delete(Subject subject) throws Exception {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        int count = 0;
        try {
            statement = connection.prepareStatement("DELETE FROM SUBJECT WHERE CD = ?");
            statement.setString(1,subject.getCd());
            count = statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally {
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
        if (count > 0) {
            return true;
        } else {
            return false;
        }

    }
}