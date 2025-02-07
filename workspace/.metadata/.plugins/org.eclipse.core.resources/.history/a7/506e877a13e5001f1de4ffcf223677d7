package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.History;
import dao.HistoryDao;
import tool.Action;

public class UnitHistoryAction extends Action{
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception{

		List<History> history = new ArrayList<>();
		HistoryDao historyDao = new HistoryDao();
		String unitId = req.getParameter("unitId");

		history = historyDao.getUintHistory(unitId);

		req.setAttribute("history_list", history);
		req.getRequestDispatcher("unithistory.jsp").forward(req, res);
	}
}
