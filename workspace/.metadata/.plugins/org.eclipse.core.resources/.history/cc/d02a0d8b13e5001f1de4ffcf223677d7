package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.ClassNumDao;
import dao.SubjectDao;
import tool.Action;



public class TestListAction extends Action{

	public void execute(HttpServletRequest req , HttpServletResponse res) throws Exception{

		HttpSession session=req.getSession();
		Teacher teacher =(Teacher)session.getAttribute("user");
        SubjectDao subDao = new SubjectDao();
	    ClassNumDao cNumDao = new ClassNumDao();
		List<Subject>subjects = null;
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();



		List<String>list = cNumDao.filter(teacher.getSchool());//クラス情報取得
		subjects =subDao.filter(teacher.getSchool());//科目情報取得


		 List<Integer> entYearSet = new ArrayList<>();
	        // 10年前から1年後まで年をリストに追加
	        for (int i = year - 10; i < year + 1; i++) {
	            entYearSet.add(i);
	        }



        // リクエストにデータをセット
        req.setAttribute("class_num_set", list);//クラスデータ
		req.setAttribute("subjects",subjects);//科目データ
        req.setAttribute("ent_year_set", entYearSet);


		req.getRequestDispatcher("test_list.jsp").forward(req,res);
	}



}