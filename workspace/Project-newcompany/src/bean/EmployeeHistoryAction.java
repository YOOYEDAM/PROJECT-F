package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.History;
import dao.HistoryDao;
import tool.Action;

public class EmployeeHistoryAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception{

		List<History> history = new ArrayList<>();
		HistoryDao historyDao = new HistoryDao();

		String userId = req.getParameter("userId");

		history = historyDao.getEmployeeHistory(userId);

		req.setAttribute("history_list", history);
		req.getRequestDispatcher("employee_history.jsp").forward(req, res);
	}
}
