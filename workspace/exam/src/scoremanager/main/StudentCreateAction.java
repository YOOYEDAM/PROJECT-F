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

public class StudentCreateAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	//ローカル変数の宣言 1
    HttpSession session = req.getSession();//セッション
    ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
    Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザー
    LocalDate todaysDate = LocalDate.now();// LcalDateインスタンスを取得
    int year = todaysDate.getYear();// 現在の年を取得
    List<Integer> entYearSet = new ArrayList<>();//入学年度のリストを初期化

    List<String> list = cNumDao.filter(teacher.getSchool());

    for (int i = year-10; i < year + 10; i++){
    	entYearSet.add(i);
    	}


    req.setAttribute("class_num_set",list );
    req.setAttribute("ent_year_set",entYearSet);

    req.getRequestDispatcher("student_create.jsp").forward(req, res);
	}
}