package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;

public class SubjectDeleteAction extends Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession(true);// セッションを取得
		SubjectDao subDao = new SubjectDao();//学生Dao
		ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
		Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザーを取得


		//リクエストパラメータ―の取得 2
		String cd = req.getParameter("cd");//科目コード

		//DBからデータ取得 3
		Subject subject = subDao.get(cd,teacher.getSchool());//科目コードから科目インスタンスを取得
		List<String> list = cNumDao.filter(teacher.getSchool());// ログインユーザーの学校コードをもとにクラス番号の一覧を取得

		//ビジネスロジック 4
		//なし

		//DBへデータ保存 5
		//なし

		//レスポンス値をセット 6
		req.setAttribute("class_num_set", list);//クラス番号のリストをセット

		req.setAttribute("cd", cd);
		req.setAttribute("name", subject.getName());
		//JSPへフォワード 7
		req.getRequestDispatcher("subject_delete.jsp").forward(req, res);
	}
}
