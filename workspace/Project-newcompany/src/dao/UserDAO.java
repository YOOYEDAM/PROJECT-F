package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import bean.UserBean;

public class UserDAO {
	private static final String URL = "jdbc:h2:tcp://localhost/~/prof;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public UserDAO() {
        try {
            Class.forName("org.h2.Driver");

            //  USERSテーブル自動生成
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {

                String createTableSQL = "CREATE TABLE IF NOT EXISTS USERS ("
                        + "USER_ID VARCHAR(50) PRIMARY KEY, "
                        + "PASSWORD VARCHAR(255) NOT NULL, "
                        + "NAME VARCHAR(100) NOT NULL, "
                        + "EMAIL VARCHAR(100) NOT NULL, "
                        + "DEPARTMENT VARCHAR(50) NOT NULL)";

                stmt.executeUpdate(createTableSQL);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertUser(UserBean user) {
        String sql = "INSERT INTO USERS (USER_ID, PASSWORD, NAME, EMAIL, DEPARTMENT) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getDepartment());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
