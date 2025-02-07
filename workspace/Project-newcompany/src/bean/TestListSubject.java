package bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TestListSubject implements Serializable {
	/**
	 * 入社年度:int
	 */
	private int entYear;

	/**
	 * ユーザID:String
	 */
	private String userId;

	/**
	 * 社員氏名:String
	 */
	private String employeeName;

	/**
	 * クラス番号:String
	 */
	private String classNum;

	/**
	 * 得点マップ:Map<Integer, Integer> key:回数, value:得点
	 */
	private Map<Integer, Integer> points;

	/**
	 * コンストラクタ
	 */
	public TestListSubject() {
		// 得点マップを初期化
		points = new HashMap<>();
	}

	/**
	 * ゲッター、セッター
	 */
	public int getEntYear() {
		return entYear;
	}

	public void setEntYear(int entYear) {
		this.entYear = entYear;
	}

	public String getuserId() {
		return userId;
	}

	public void setuserId(String user_id) {
		this.userId = user_id;
	}

	public String employeeName() {
		return employeeName;
	}

	public void setemployeeName(String employee_name) {
		this.employeeName = employee_name;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public Map<Integer, Integer> getPoints() {
		return points;
	}

	public void setPoints(Map<Integer, Integer> points) {
		this.points = points;
	}

	/**
	 * getPointメソッド 得点マップから値を取得する
	 *
	 * @param key:int
	 *            回数
	 * @return 得点:String
	 */
	public String getPoint(int key) {
		// 得点マップから値を取得
		Integer k = points.get(key);
		if (k == null) {
			// 得点マップに値が存在しなかった場合"-"を返却
			return "-";
		} else {
			// 得点マップに値が存在した場合、文字列として得点を返却
			return k.toString();
		}
	}

	/**
	 * putPointメソッド 得点マップに値を格納する
	 *
	 * @param key:int
	 *            回数
	 * @param value:int
	 */
	public void putPoint(int key, int value) {
		// 得点マップに値を格納
		points.put(key, value);
	}
}
