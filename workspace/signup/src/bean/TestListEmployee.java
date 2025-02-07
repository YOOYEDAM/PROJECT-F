package bean;

import java.io.Serializable;

public class TestListEmployee implements Serializable {
	/**
	 * 学習内容名:String
	 */
	private String studyName;

	/**
	 * 科目コード:String
	 */
	private String subjectCd;

	/**
	 * 回数:int
	 */
	private int num;

	/**
	 * 得点:int
	 */
	private int point;

	/**
	 * ゲッター、セッター
	 */
	public String getSubjectName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getSubjectCd() {
		return subjectCd;
	}

	public void setSubjectCd(String subjectCd) {
		this.subjectCd = subjectCd;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void setEmployeeName(String string) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setuserId(String userId) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setEntYear(int int1) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setClassNum(String string) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setStudentName(String string) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void putPoint(int num2, int point2) {
		// TODO 自動生成されたメソッド・スタブ

	}

}