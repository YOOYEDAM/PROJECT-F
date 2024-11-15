package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentDeleteExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言 1
        StudentDao sDao = new StudentDao();//学生Dao
        Student student = new Student();
        HttpSession session = req.getSession();//セッション
        Teacher teacher = (Teacher)session.getAttribute("user");// ログインユーザーを取得
        //リクエストパラメータ―の取得 2
        String no = req.getParameter("no");//学番
        student = sDao.get(no);
        sDao.delete(student);

        //エラーがあったかどうかで手順6~7の内容が分岐
        //レスポンス値をセット 6
        //JSPへフォワード 7
        req.getRequestDispatcher("student_delete_done.jsp").forward(req, res);
    }
}