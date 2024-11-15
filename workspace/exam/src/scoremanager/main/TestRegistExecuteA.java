package scoremanager.main;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

public class TestRegistExecuteA extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言 1
        HttpSession session = req.getSession();//セッション
        TestDao tDao = new TestDao();//学生Dao
        SubjectDao subDao = new SubjectDao();
        String classNum = null;//クラス番号
        String no = null;//学生番号
        String[] point = null;
        String subjectCd = null;
        String[] studentNo = null;
        Subject subject = null;
        Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザーを取得
        School school = teacher.getSchool();

        //リクエストパラメータ―の取得 2
        studentNo = req.getParameterValues("student_no_set[]");
        subjectCd = req.getParameter("subject_cd");
        classNum = req.getParameter("f2");//クラス番号
        no = req.getParameter("f4");//学生番号
        point = req.getParameterValues("point[]");//
        subject = subDao.get(subjectCd, school);
        school = teacher.getSchool();


        List<Test> tests = new ArrayList<>();

            for (int i = 0; i < point.length; i++){
                // 学生インスタンスを初期化
                Test test = new Test();
                Student student = new Student();
                test.setPoint(Integer.parseInt(point[i]));
                student.setNo(studentNo[i]);
                test.setStudent(student);
                test.setSubject(subject);
                test.setSchool(school);
                test.setNo(Integer.parseInt(no));
                test.setClassNum(classNum);
                tests.add(test);
            }
                // 学生を保存
                tDao.save(tests);

        req.getRequestDispatcher("test_regist_done.jsp").forward(req, res);
    }
}