package scoremanager.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.School;
import bean.Subject;
import bean.Teacher;
import bean.Test;
import dao.ClassNumDao;
import dao.SubjectDao;
import dao.TestDao;
import tool.Action;

public class TestRegistAction extends Action{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();//セッション
        Teacher teacher = (Teacher)session.getAttribute("user");//ログインユーザー
        String entYearStr=null;// 入力された入学年度
        String classNum = null;//入力されたクラス番号
        String subjectCd =null;
        Subject subject = null;
        String testNumStr = null;
        int entYear = 0;// 入学年度
        int testNum = 0;
        List<Test> tests = new ArrayList<>();
        LocalDate todaysDate = LocalDate.now();
        int year = todaysDate.getYear();
        SubjectDao sDao = new SubjectDao();
        ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
        TestDao testDao = new TestDao();
        List<Integer> entYearSet = new ArrayList<>();
        List<Integer> numSet = new ArrayList<>();
        Map<String, String> errors = new HashMap<>();// エラーメッセージ

        //リクエストパラメータ―の取得 2
        entYearStr = req.getParameter("f1");
        classNum = req.getParameter("f2");
        subjectCd = req.getParameter("f3");
        testNumStr = req.getParameter("f4");

        // 入学年度が送信されていた場合
        if (entYearStr != null) {
            // 数値に変換
            entYear = Integer.parseInt(entYearStr);
        }

        if (testNumStr != null) {
            // 数値に変換
            testNum = Integer.parseInt(testNumStr);
        }

        List<String> list = cNumDao.filter(teacher.getSchool());
        List<Subject> list2 = sDao.filter(teacher.getSchool());

        for (int i = year - 10; i < year + 1; i++) {
            entYearSet.add(i);
        }

        for (int i = 1; i <= 2; i++) {
            numSet.add(i);
        }
        School school = teacher.getSchool();
        subject = sDao.get(subjectCd, school);

        if (entYearStr != null || classNum != null || subject != null || testNumStr != null) {
            if (entYear != 0 && !classNum.equals("0") && subject != null && testNum != 0) {
                // 入学年度とクラス番号と科目を指定
                tests = testDao.filter(entYear, classNum, subject, testNum, school);
                req.setAttribute("tests", tests);
            } else {
                errors.put("filter", "入学年度とクラスと科目と回数を選択してください");
                req.setAttribute("errors", errors);
            }

        }
        req.setAttribute("f1", entYearStr);
        req.setAttribute("f2", classNum);
        req.setAttribute("f3", subject);
        req.setAttribute("f4", testNum);
        req.setAttribute("test_num_set", numSet);
        req.setAttribute("class_num_set", list);
        req.setAttribute("ent_year_set", entYearSet);
        req.setAttribute("sub_name_set", list2);
        req.setAttribute("subject", subject);

        req.getRequestDispatcher("test_regist.jsp").forward(req, res);
}
}