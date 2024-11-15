package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Teacher;
import dao.ClassNumDao;
import tool.Action;

public class SubjectCreateAction extends Action{
    @Override
    public void execute (HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言1
        HttpSession session = req.getSession(true);
        ClassNumDao cNumDao = new ClassNumDao();
        Teacher teacher = (Teacher) session.getAttribute("user");
        List<Integer> entYearSet = new ArrayList<>();

        List<String> list = cNumDao.filter(teacher.getSchool());


        req.setAttribute("class_num_set", list);
        req.setAttribute("ent_year_set", entYearSet);

        req.getRequestDispatcher("subject_create.jsp").forward(req, res);
    }

}