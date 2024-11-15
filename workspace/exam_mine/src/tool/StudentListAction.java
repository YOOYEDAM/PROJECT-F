package tool;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import scoremanager.ClassNumDao;
import scoremanager.HashMap;
import scoremanager.LocalDate;
import scoremanager.Map;
import scoremanager.student;

public class StudentListAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();//セッション
		Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザー
		boolean isAttend = false;

		StudentDao sDao = new StudentDao();

		List<Student> students = sDao.filter(teacher.getSchool(), isAttend);

		// リクエストに学生リストをセット
		req.setAttribute("students", students);

		//JSPへフォワード 7
		req.getRequestDispatcher("student_list.jsp").forward(req, res);

		Teacher teacher = (Teacher)session.getAttribute("user");
		String entYearStr="";
		String classNum="";
		String isAttendStr="";
		int entYear = 0;
		boolean isAttend = false;
		List<student> students = null;
		LocalDate todatsDate = LocalDate.now();
		int year = todaysDate.getYear();
		StudentDao sDao = new StudentDao();
		ClassNumDao cNumDao = new ClassNumDao();
		Map<String, String> errors = new HashMap<>();

		entYearStr = req.getParameter("f1");
		classNum = req.getParameter("f2");
		isAttendStr = req.getParameter("f3");

		List<String> list = cNumDao.filter(teacher.getSchool());



}
}
