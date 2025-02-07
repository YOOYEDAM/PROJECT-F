package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.History;
import dao.HistoryDao;
import tool.Action;

public class HistoryAction extends Action{

	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception{

		List<History> history = new ArrayList<>();
		HistoryDao historyDao = new HistoryDao();
		history = historyDao.getEmployee();

		req.setAttribute("employee_list", history);

		history = historyDao.getUnit();

		req.setAttribute("unit_list", history);
	    req.getRequestDispatcher("history.jsp").forward(req, res);
	}
}
