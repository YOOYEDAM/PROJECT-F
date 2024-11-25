package scoremanager.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class TestListExecuteAction extends Action{
	 @Override
	 public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 SubjectDao subjectDao = new SubjectDao();//学生Dao
		 boolean isAttend=false;
		 HttpSession session=req.getSession();
		 Teacher teacher = (Teacher) session.getAttribute("user");
		 Map<String, String> errors=new HashMap<>();
		 String cd=req.getParameter("cd");
		 String name=req.getParameter("name");
		 String isAttendSet=req.getParameter("is_attend");
		 if (isAttendSet != null) {
			 isAttend=true;
		 }
		 Subject subject=subjectDao.get(cd,teacher.getSchool());
		 List<Subject> list=subjectDao.filter(teacher.getSchool());
		 if (subject != null) {
			 subject.setName(name);
			 subject.setCd(cd);
			 subjectDao.save(subject);
		 } else {
			 errors.put("cd", "科目が存在していません");
		 }
		 req.setAttribute("subject_cd_set", list);//クラス番号のlistをセット
	     req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
		 if (errors.isEmpty()) {//エラーがあった場合、更新画面へ戻る
			 req.setAttribute("errors", errors);
	         req.setAttribute("cd", cd);
	         req.setAttribute("name", name);
	         req.getRequestDispatcher("subject_update.jsp").forward(req, res);
	         return;
		 }
	     req.getRequestDispatcher("subject_update_done.jsp").forward(req, res);
	 }
}