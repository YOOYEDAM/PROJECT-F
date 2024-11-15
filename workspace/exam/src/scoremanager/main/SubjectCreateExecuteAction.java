package scoremanager.main;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        //ローカル変数の宣言 1
        HttpSession session = req.getSession();//セッション
        SubjectDao sDao = new SubjectDao();//学生Dao
        String cd = "";//学生番号
        String name = "";//氏名
        Subject subject = null;//学生
        Teacher teacher = (Teacher)session.getAttribute("user");
        Map<String, String> errors = new HashMap<>();// エラーメッセージ

        //リクエストパラメータ―の取得 2
        cd = req.getParameter("cd");//学生番号
        name = req.getParameter("name");//氏名

        //DBからデータ取得 3
        subject = sDao.get(cd, teacher.getSchool());// 学生番号から学生インスタンスを取得
        System.out.println("sub:" + subject);
        if (cd.length() == 3){
        	if (subject == null) {// 学生が未登録だった場合
        		// 学生インスタンスを初期化
        		subject = new Subject();
        		// インスタンスに値をセット
        		subject.setCd(cd);
        		subject.setName(name);
        		subject.setSchool(((Teacher)session.getAttribute("user")).getSchool());
        		// 学生を保存
        		sDao.save(subject);
	        } else {//入力された学番がDBに保存されていた場合
	        	System.out.println("else:");
	            errors.put("cd", "科目コードが重複しています");
	        }
        }else{
        	errors.put("size", "科目コードは3文字で入力してください");
        }

        if (!errors.isEmpty()){
        	req.setAttribute("errors", errors);
        	req.setAttribute("cd", cd);
        	req.setAttribute("name", name);

        	req.getRequestDispatcher("subject_create.jsp").forward(req, res);
        }

        req.getRequestDispatcher("subject_create_done.jsp").forward(req, res);
    }
}