package cn.zalezone.domain;

/**
 * 用户信息
 * @author zlk
 *
 */

public class UserInfo {
    private String userId;
    private String alpha;
    private String name;
    private String time;
    private String des;
    private String messageHint;

    public UserInfo(String userId, String alpha, String name, String time, String des, String messageHint)
    {
        this.userId = userId;
        this.alpha = alpha;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
