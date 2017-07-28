package domain;

/**
 * Created by WLP on 2017/7/14.
 * //动态表实体类
 */
public class General {
    private int generalId;
    private String generalMusic;
    private int myId;
    private int discussId;
    private String generDate;

    public int getGeneralId() {
        return generalId;
    }

    public void setGeneralId(int generalId) {
        this.generalId = generalId;
    }

    public String getGeneralMusic() {
        return generalMusic;
    }

    public void setGeneralMusic(String generalMusic) {
        this.generalMusic = generalMusic;
    }

    public int getMyId() {
        return myId;
    }

    public void setMyId(int myId) {
        this.myId = myId;
    }

    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    public String getGenerDate() {
        return generDate;
    }

    public void setGenerDate(String generDate) {
        this.generDate = generDate;
    }
}
