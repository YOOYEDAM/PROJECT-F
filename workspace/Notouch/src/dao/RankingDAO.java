package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import bean.RankingBean;

public class RankingDAO {
    private static final String URL = "jdbc:h2:~/rank;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public RankingDAO() {
        try {
            Class.forName("org.h2.Driver");
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement()) {

                String createTableSQL = "CREATE TABLE IF NOT EXISTS rankings (" +
                        "id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "user_id VARCHAR(50) NOT NULL, " +
                        "score INT NOT NULL, " +
                        "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
                stmt.executeUpdate(createTableSQL);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertScore(RankingBean ranking) {
        String sql = "INSERT INTO rankings (user_id, score) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ranking.getUserId());
            pstmt.setInt(2, ranking.getScore());

            int rows = pstmt.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
