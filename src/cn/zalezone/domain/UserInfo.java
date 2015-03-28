package cn.zalezone.domain;

/**
 * 用户信息
 * @author zlk
 *
 */

public class UserInfo {
    private String userId;
    private String alpha;
    private String title;
    private String time;
    private String des;
    private String messageHint;

    public UserInfo(String userId, String alpha, String title, String time, String des, String messageHint)
    {
        this.userId = userId;
        this.alpha = alpha;
        this.title = title;
        this.time = time;
        this.des = des;
        this.messageHint = messageHint;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        userId = userId;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getMessageHint() {
        return messageHint;
    }

    public void setMessageHint(String messageHint) {
        this.messageHint = messageHint;
    }

}
