package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class EmployeeCreateAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//ローカル変数の宣言 1
		HttpSession session = req.getSession();//セッションa
		Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザーa
		LocalDate todaysDate = LocalDate.now();// LcalDateインスタンスを取得a
		int year = todaysDate.getYear();// 現在の年を取得a
		ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化a
		List<Integer> entYearSet = new ArrayList<>();		// リストを初期化

		//DBからデータ取得 3
		// ログインユーザーの学校コードをもとにクラス番号の一覧を取得
		List<String> list = cNumDao.filter(teacher.getSchool());


		//ビジネスロジック 4
		for (int i = year - 10; i < year +10; i++){
			entYearSet.add(i);
		}

		//DBへデータ保存 5
		//なし

		//レスポンス値をセット 6
		// リクエストに入学年度をセット
		req.setAttribute("class_num_set", list);
		req.setAttribute("ent_year_set", entYearSet);

		//JSPへフォワード 7
		req.getRequestDispatcher("emoployee_create.jsp").forward(req, res);
	}
}