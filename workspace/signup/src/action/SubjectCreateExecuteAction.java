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

public class SubjectCreateExecuteAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();//セッション
		SubjectDao subDao = new SubjectDao();
		Map<String, String> errors = new HashMap<>();// エラーメッセージ
		Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザーを取得
		String cd =  "";
		String name = "";
		Subject subject = null;


		//リクエストパラメータ―の取得 2
	    cd = req.getParameter("cd");//科目コード
		name = req.getParameter("name");//科目名


		//DBからデータ取得 3
		subject = subDao.get(cd,teacher.getSchool());// 学生番号から学生インスタンスを取得
		List<Subject> list = subDao.filter(teacher.getSchool());// ログインユーザーの学校コードをもとに科目一覧を取得
		 if (cd.length() != 3) {
	            errors.put("cd", "科目コードは3文字で入力してください");
	            req.setAttribute("errors", errors);
	            }else{
		if (subject == null){
			// 科目インスタンスを初期化
		    subject = new Subject();
			// インスタンスに値をセット
			subject.setCd(cd);
			subject.setName(name);
			subject.setSchool(((Teacher)session.getAttribute("user")).getSchool());

			// 科目を保存
			subDao.save(subject);

		} else {
			errors.put("cd", "科目コードが重複しています。");
		}
	            }

		//エラーがあったかどうかで手順6~7の内容が分岐
		//レスポンス値をセット 6
		//JSPへフォワード 7
		req.setAttribute("subject",list);//クラス番号のlistをセット

		if(!errors.isEmpty()) {
			// リクエスト属性をセット
			req.setAttribute("cd",cd );
			req.setAttribute("name", name);
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("subject_create.jsp").forward(req, res);
			return;
		}
		req.getRequestDispatcher("subject_create_done.jsp").forward(req, res);
	}
}