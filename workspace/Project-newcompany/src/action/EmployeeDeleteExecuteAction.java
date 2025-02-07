package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDao;
import tool.Action;

public class EmployeeDeleteExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言 1
        EmployeeDao sDao = new EmployeeDao();// 科目Dao
        Employee employee = new Employee();//科目

      //リクエストパラメータ―の取得 2
        String no = req.getParameter("no");//学生番号

      //DBからデータ取得 3
        employee = sDao.get(no);// 学生番号から学生インスタンスを取得
        sDao.delete(employee);

        req.getRequestDispatcher("employee_delete_done.jsp").forward(req, res);
    }
}