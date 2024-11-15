package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		SubjectDao sDao = new SubjectDao();//学生Dao
		Subject subject = new Subject();
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");// ログインユーザーを取得
		//リクエストパラメータ―の取得 2
		String cd = req.getParameter("cd");//学番
		subject = sDao.get(cd, teacher.getSchool());
        sDao.delete(subject);

        //エラーがあったかどうかで手順6~7の内容が分岐
        //レスポンス値をセット 6
        //JSPへフォワード 7
        req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);
	}
}

