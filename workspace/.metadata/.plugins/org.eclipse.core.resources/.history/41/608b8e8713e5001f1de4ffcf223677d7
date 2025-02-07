package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

public class EmployeeDeleteAction extends Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String no = req.getParameter("no");//社員番号
        String name = req.getParameter("name");//氏名

        req.setAttribute("no", no);
        req.setAttribute("name", name);
        //JSPへフォワード
        req.getRequestDispatcher("employee_delete.jsp").forward(req, res);
    }

}