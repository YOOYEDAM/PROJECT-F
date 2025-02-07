package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectListAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言 1
        HttpSession session = req.getSession();//セッション
        Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザー
        SubjectDao sbDao = new SubjectDao();//学生Dao

        //DBからデータ取得 3
        // ログインユーザーの学校コードをもとにクラス番号の一覧を取得
        List<Subject> list = sbDao.filter(teacher.getSchool());


        // リクエストにデータをセット
        req.setAttribute("subjects", list);


        //JSPへフォワード 7
        req.getRequestDispatcher("subject_list.jsp").forward(req, res);
    }
}