package scoremanager.main;

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
import dao.EmployeeDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

public class TestRegistExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        String subjectCd = req.getParameter("subject_cd");
        int num = Integer.parseInt(req.getParameter("num"));
        String[] studentNoSet = req.getParameterValues("student_no_set[]");

        SubjectDao subDao = new SubjectDao();
        EmployeeDao stuDao = new EmployeeDao();
        TestDao testDao = new TestDao();

        Subject subject = subDao.get(subjectCd, teacher.getSchool());

        Map<String, String> errors = new HashMap<>();
        Map<String, Integer> inputPoints = new HashMap<>();
        List<Test> tests = new ArrayList<>();

        for (String studentNo : studentNoSet) {
            Employee student = stuDao.get(studentNo);
            if (student != null) {
                String pointStr = req.getParameter("point_" + student.getNo());
                if (pointStr != null && !pointStr.isEmpty()) {
                    try {
                        int point = Integer.parseInt(pointStr);
                        if (point < 0 || point > 100) {
                            errors.put(student.getNo(), "0～100の範囲で入力してください。");
                        } else {
                            Test test = new Test();
                            test.setStudent(student);
                            test.setSubject(subject);
                            test.setSchool(teacher.getSchool());
                            test.setNo(num);
                            test.setPoint(point);
                            test.setClassNum(student.getClassNum());
                            tests.add(test);
                            inputPoints.put(student.getNo(), point);
                        }
                    } catch (NumberFormatException e) {
                        errors.put(student.getNo(), "数値を入力してください。");
                    }
                }
            }
        }


        if (!errors.isEmpty()){
            Employee student = stuDao.get(studentNoSet[0]);
    		int nendo = student.getEntYear();
    		String kurasu = student.getClassNum();

			List<Employee> studentList = stuDao.filter(teacher.getSchool(), nendo, kurasu, true);
			Subject kamoku = subDao.get(subjectCd, teacher.getSchool());
			List<Test> testList = testDao.filter(nendo, kurasu, subject, num, teacher.getSchool());

			req.setAttribute("tests", testList);
			req.setAttribute("subject", kamoku);
			req.setAttribute("num", num);
			req.setAttribute("students", studentList);
            req.setAttribute("errors", errors);
			req.getRequestDispatcher("test_regist.jsp").forward(req, res);

			return;
        }
        if (errors.isEmpty()) {
        	testDao.save(tests);
        }

        req.setAttribute("subject", subject);
        req.setAttribute("num", num);
        req.setAttribute("students", studentNoSet);
        req.setAttribute("errors", errors);
        req.setAttribute("input_points", inputPoints);

        req.getRequestDispatcher("test_regist_done.jsp").forward(req, res);
    }
}
