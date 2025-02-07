package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;
import dao.UserDAO;

@WebServlet("/SignupAction")
public class SignupAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/plain"); //AJAX

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");

        PrintWriter out = response.getWriter();

        //埋め忘れチェック
        if (userId == null || password == null || name == null || email == null || department == null ||
            userId.trim().isEmpty() || password.trim().isEmpty() || name.trim().isEmpty() || email.trim().isEmpty() || department.trim().isEmpty()) {
            out.print("fail");
            out.flush();
            return;
        }

        UserBean user = new UserBean();
        user.setUserId(userId);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setDepartment(department);

        UserDAO dao = new UserDAO();
        if (dao.insertUser(user)) {
            out.print("success");
        } else {
            out.print("fail");
        }
        out.flush();
    }
}
