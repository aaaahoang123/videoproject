package user.login.attribute;

public class ResLoginAttribute {
    private long expiredTimeMLS;
    private long createdTimeMLS;
    private String secretToken;
    private int status;
    private long userId;

    public long getExpiredTimeMLS() {
        return expiredTimeMLS;
    }

    public void setExpiredTimeMLS(long expiredTimeMLS) {
        this.expiredTimeMLS = expiredTimeMLS;
    }

    public long getCreatedTimeMLS() {
        return createdTimeMLS;
    }

    public void setCreatedTimeMLS(long createdTimeMLS) {
        this.createdTimeMLS = createdTimeMLS;
    }

    public String getSecretToken() {
        return secretToken;
    }

    public void setSecretToken(String secretToken) {
        this.secretToken = secretToken;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
