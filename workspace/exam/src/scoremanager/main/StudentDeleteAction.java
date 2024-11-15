package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import tool.Action;

public class StudentDeleteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言 1
        StudentDao sDao = new StudentDao();//学生Dao
        HttpSession session = req.getSession();//セッション
        Teacher teacher = (Teacher)session.getAttribute("user");// ログインユーザーを取得
        Student student = new Student();
        //リクエストパラメータ―の取得 2
        String no = req.getParameter("no");//学番

        //DBからデータ取得 3

         student = sDao.get(no);//学生番号から学生インスタンスを取得



        req.setAttribute("student", student);

        //JSPへフォワード 7
        req.getRequestDispatcher("student_delete.jsp").forward(req, res);

    }
}