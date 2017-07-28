package domain;

/**
 * Created by WLP on 2017/7/15.
 * 个人动态实体类
 */
public class PersonGeneral {

    private String userName;
    private String userPhoto;
    private String userSign;
    private String generalMusic;
    private String generDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getGeneralMusic() {
        return generalMusic;
    }

    public void setGeneralMusic(String generalMusic) {
        this.generalMusic = generalMusic;
    }

    public String getGenerDate() {
        return generDate;
    }

    public void setGenerDate(String generDate) {
        this.generDate = generDate;
    }
}
