package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RankingBean;
import dao.RankingDAO;

@WebServlet("/RankingAction")
public class RankingAction extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String scoreStr = request.getParameter("score");

        PrintWriter out = response.getWriter();

        if (userId == null || scoreStr == null || userId.trim().isEmpty() || scoreStr.trim().isEmpty()) {
            out.print("fail");
            out.flush();
            return;
        }

        int score = Integer.parseInt(scoreStr);

        RankingBean ranking = new RankingBean();
        ranking.setUserId(userId);
        ranking.setScore(score);

        RankingDAO dao = new RankingDAO();
        boolean success = dao.insertScore(ranking);

        if (success) {
            out.print("success");
        } else {
            out.print("fail");
        }
        out.flush();
    }
}
