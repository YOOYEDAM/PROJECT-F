package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDao;
import dao.EmployeeDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

public class TestRegistAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		Teacher teacher = (Teacher) session.getAttribute("user");
		LocalDate todaysDate = LocalDate.now();
		int year = todaysDate.getYear();
		ClassNumDao cNumDao = new ClassNumDao();
		List<Integer> entYearSet = new ArrayList<>();
		SubjectDao subDao = new SubjectDao();
		EmployeeDao stuDao = new EmployeeDao();
		TestDao testDao = new TestDao();
		List<Integer> kaisuSet = new ArrayList<>();
		Map<String, String> errors = new HashMap<>();

		for (int i = year - 10; i <= year; i++) {
			entYearSet.add(i);
		}
		for (int i = 1; i <= 2; i++) {
			kaisuSet.add(i);
		}

		List<String> classList = cNumDao.filter(teacher.getSchool());
		List<Subject> subjects = subDao.filter(teacher.getSchool());

		String nendoStr = req.getParameter("f1");
		String kurasu = req.getParameter("f2");
		String subjectCd = req.getParameter("f3");
		String kaisuStr = req.getParameter("f4");
		String zero = "0";


		int nendo = 0;
		int kaisu = 0;

		if (nendoStr != null && !nendoStr.equals(zero) && kurasu != null && !kurasu.equals(zero) && subjectCd != null&& !subjectCd.equals(zero) && kaisuStr != null&& !kaisuStr.equals(zero)) {

			nendo = Integer.parseInt(nendoStr);
			kaisu = Integer.parseInt(kaisuStr);

			if (errors.isEmpty()) {
				List<Employee> studentList = stuDao.filter(teacher.getSchool(), nendo, kurasu, true);
				Subject subject = subDao.get(subjectCd, teacher.getSchool());
				List<Test> testList = testDao.filter(nendo, kurasu, subject, kaisu, teacher.getSchool());

				req.setAttribute("tests", testList);
				req.setAttribute("subject", subject);
				req.setAttribute("num", kaisu);
				req.setAttribute("students", studentList);
			}
		}else{
			if (nendoStr != null){
				errors.put("filter", "入社年度と所属部署と科目を選択してください。");
			}
		}

		req.setAttribute("class_num_set", classList);
		req.setAttribute("ent_year_set", entYearSet);
		req.setAttribute("subjects", subjects);
		req.setAttribute("num_set", kaisuSet);
		req.setAttribute("errors", errors);

		req.getRequestDispatcher("test_regist.jsp").forward(req, res);
	}
}
