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

public class SubjectDeleteExecuteAction extends Action {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
	    SubjectDao subDao = new SubjectDao();// 科目Dao
	    HttpSession session = req.getSession();//セッション
	    Teacher teacher = (Teacher)session.getAttribute("user");// ログインユーザーを取得
	    ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化

	    //リクエストパラメータ―の取得 2
	    String cd = req.getParameter("cd");//科目コード

	    //DBからデータ取得 3
	  	Subject subject = subDao.get(cd, teacher.getSchool());//科目コードから科目インスタンスを取得
	  	List<String> list = cNumDao.filter(teacher.getSchool());// ログインユーザーの学校コードをもとにクラス番号の一覧を取得

	    //ビジネスロジック 4
	  	//なし

	    //DBへデータ保存 5
	  	subject.setCd(cd);//インスタンスに科目コードをセット
        subDao.delete(subject);//科目を削除

        //レスポンス値をセット 6
        req.setAttribute("class_num_set", list);//クラス番号のリストをセット

        //JSPへフォワード 7
        req.getRequestDispatcher("subject_delete_done.jsp").forward(req, res);

    }
}
