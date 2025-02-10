package bean;

import java.sql.Timestamp;

public class RankingBean {
    private int id;              // 고유 ID (자동 증가)
    private String userId;       // 사용자 ID
    private int score;           // 사용자 점수
    private Timestamp createdAt; // 등록된 시간

    // 기본 생성자
    public RankingBean() {
    }

    // 매개변수를 받는 생성자
    public RankingBean(int id, String userId, int score, Timestamp createdAt) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.createdAt = createdAt;
    }

    // Getter & Setter 메서드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // toString() 메서드 (디버깅 및 출력 용도)
    @Override
    public String toString() {
        return "RankingBean{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", score=" + score +
                ", createdAt=" + createdAt +
                '}';
    }
}
