package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Student;
import bean.Teacher;
import dao.ClassNumDao;
import dao.StudentDao;
import tool.Action;

public class StudentUpdateExecuteAction extends Action{
	 public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

	        StudentDao sDao = new StudentDao();//学生Dao
	        boolean isAttend  = false;
	        HttpSession session = req.getSession();//セッション
	        Teacher teacher = (Teacher) session.getAttribute("user");// ログインユーザーを取得
	        ClassNumDao cNumDao = new ClassNumDao();// クラス番号Daoを初期化
	        Map<String, String> errors = new HashMap<>();// エラーメッセージ


	        //リクエストパラメータ―の取得 2
	        String entYearStr = req.getParameter("ent_year");
	        String no = req.getParameter("no");
	        String name = req.getParameter("name");
	        String classNum = req.getParameter("class_num");
	        String isAttendStr = req.getParameter("is_attend");

	        List<String> list = cNumDao.filter(teacher.getSchool());
	        Student student = sDao.get(no);

	        if (isAttendStr !=null){
	        	isAttend = true;
	        }

	            if (student != null) {// 学生が未登録だった場合
	                // 学生インスタンスを初期化
	                student = new Student();
	                // インスタンスに値をセット

	                student.setNo(no);
	                student.setName(name);
	                student.setClassNum(classNum);
	                student.setAttend(isAttend);
	                // 学生を保存
	                sDao.save(student);
	            } else {
	                errors.put("no", "学生が存在していません");
	            }

	        //エラーがあったかどうかで手順6~7の内容が分岐
	        //レスポンス値をセット 6
	        //JSPへフォワード 7
	        req.setAttribute("class_num_set", list) ;//クラス番号のlistをセット

	        if(!errors.isEmpty()){
	            // リクエスト属性をセット
	            req.setAttribute("errors", errors);
	            req.setAttribute("ent_year", entYearStr);
	            req.setAttribute("no", no);
	            req.setAttribute("name", name);
	            req.setAttribute("class_num", classNum);
	            req.setAttribute("is_Attend", isAttendStr);
	            req.getRequestDispatcher("student_update.jsp").forward(req, res);
	            return;
	        }
	        req.getRequestDispatcher("student_update_done.jsp").forward(req, res);
	 }

}