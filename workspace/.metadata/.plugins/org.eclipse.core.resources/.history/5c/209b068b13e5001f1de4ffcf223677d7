package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectUpdateAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言 1
        SubjectDao subjectDao = new SubjectDao();//学生Dao
        HttpSession session = req.getSession();//セッション
        Teacher teacher = (Teacher)session.getAttribute("user");// ログインユーザーを取得
        Map<String, String> errors = new HashMap<>();//エラーメッセージ

        //リクエストパラメータ―の取得 2
        String cd = req.getParameter("cd");

        //DBからデータ取得 3
        Subject subject = subjectDao.get(cd,teacher.getSchool());//学生番号から学生インスタンスを取得
        List<Subject> list = subjectDao.filter(teacher.getSchool());//ログインユーザーの学校コードをもとにクラス番号の一覧を取得


        //ビジネスロジック 4
        //DBへデータ保存 5
        //レスポンス値をセット 6
        //条件で手順4~6の内容が分岐
        req.setAttribute("subject_cd_set", list);
        if (subject != null) {// 学生が存在していた場合
            req.setAttribute("cd", subject.getCd());
            req.setAttribute("name", subject.getName());
        } else {// 学生が存在していなかった場合

            req.setAttribute("errors", errors);
        }
        //JSPへフォワード 7
        req.getRequestDispatcher("subject_update.jsp").forward(req, res);
    }
}