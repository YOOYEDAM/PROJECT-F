package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		SubjectDao sDao = new SubjectDao();//学生Dao
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");// ログインユーザーを取得
		Subject subject = new Subject();
		//リクエストパラメータ―の取得 2
		String cd = req.getParameter("cd");//学番

		//DBからデータ取得 3

		 subject = sDao.get(cd, teacher.getSchool());//学生番号から学生インスタンスを取得



		req.setAttribute("subject", subject);

		//JSPへフォワード 7
		req.getRequestDispatcher("subject_delete.jsp").forward(req, res);

	}
}