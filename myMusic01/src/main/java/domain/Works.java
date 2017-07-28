package domain;

import util.DateFormatUtil;

import java.util.Date;

/**
 * Created by WLP on 2017/7/10.
 */
public class Works {

    private int workId;
    private String workName;
    private String userName;
    private int userId;
    private String photo;
    private String workAddress;
    private Date worksDate;
    private int labelsId;
    private int good;
    private String time;
    private String workLyrics;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String  getWorksDate() {
        return DateFormatUtil.date2str(this.worksDate);
    }

    public void setWorksDate(String worksDate) {
        this.worksDate = DateFormatUtil.str2date(worksDate);
    }

    public int getLabelsId() {
        return labelsId;
    }

    public void setLabelsId(int labelsId) {
        this.labelsId = labelsId;
    }

    public String getWorkLyrics() {
        return workLyrics;
    }

    public void setWorkLyrics(String workLyrics) {
        this.workLyrics = workLyrics;
    }

    @Override
    public String toString() {
        return "Works{" +
                "workName='" + workName + '\'' +
                ", userName='" + userName + '\'' +
                ", photo='" + photo + '\'' +
                ", workAddress='" + workAddress + '\'' +
                ", workLyrics='" + workLyrics + '\'' +
                '}';
    }
}
