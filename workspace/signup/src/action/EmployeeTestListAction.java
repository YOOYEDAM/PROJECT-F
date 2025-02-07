package scoremanager.main;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import bean.Subject;
import bean.Teacher;
import bean.TestListEmployee;
import dao.ClassNumDao;
import dao.EmployeeDao;
import dao.SubjectDao;
import dao.TestListEmployeeDao;
import tool.Action;


public class EmployeeTestListAction extends Action {

    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        // リクエストから学生番号を取得（文字列として取得）
        String employeeNo = req.getParameter("f4");

        // 学生番号を使ってStudentオブジェクトを作成
        Employee employee = new Employee();
        employee.setNo(employeeNo);

        // 学生成績DAOのインスタンス化
        TestListEmployeeDao testListEmployeeDao = new TestListEmployeeDao();

        // StudentDaoのインスタンス化
        EmployeeDao employeeDao = new EmployeeDao();

        String employeeName = null;
        try {
            // 学生情報を取得
            Employee employeeInfo = employeeDao.get(employeeNo);
            if (employeeInfo != null) {
                employeeName = employeeInfo.getName();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // エラーメッセージをリクエスト属性に設定
            req.setAttribute("errorMessage", "社員情報の取得に失敗しました。");
        }

        try {
            // 学生成績を取得
            List<TestListEmployee> testList = testListEmployeeDao.filter(employee);

            // 成績一覧をリクエスト属性に設定
            req.setAttribute("testList", testList);
        } catch (SQLException e) {
            e.printStackTrace();
            // エラーメッセージをリクエスト属性に設定
            req.setAttribute("errorMessage", "成績データの取得に失敗しました。");
        }


		List<Subject>subjects = null;
        SubjectDao subDao = new SubjectDao();
		HttpSession session=req.getSession();

	    ClassNumDao cNumDao = new ClassNumDao();
		Teacher teacher =(Teacher)session.getAttribute("user");

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


        // 学生番号と氏名をリクエスト属性に設定
        req.setAttribute("employeeNo", employeeNo);
        req.setAttribute("employeeName", employeeName);

        // JSPにフォワード
        req.getRequestDispatcher("test_list_employee.jsp").forward(req, res);
    }
}