package domain;

/**
 * Created by WLP on 2017/7/7.
 *
 * 明星歌单实体类
 */
public class StarMusic {

    private int starId;
    private String starName;
    private String starMusicName;
    private String starLyrics;
    private String starDate;
    private String starPhoto;
    private String starMusicAddress;
    private String starScore;

    public String getStarScore() {
        return starScore;
    }

    public void setStarScore(String starScore) {
        this.starScore = starScore;
    }

    public String getStarMusicAddress() {
        return starMusicAddress;
    }

    public void setStarMusicAddress(String starMusicAddress) {
        this.starMusicAddress = starMusicAddress;
    }

    public int getStarId() {
        return starId;
    }

    public void setStarId(int starId) {
        this.starId = starId;
    }

    public String getStarName() {
        return starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public String getStarMusicName() {
        return starMusicName;
    }

    public void setStarMusicName(String starMusicName) {
        this.starMusicName = starMusicName;
    }

    public String getStarLyrics() {
        return starLyrics;
    }

    public void setStarLyrics(String starLyrics) {
        this.starLyrics = starLyrics;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getStarPhoto() {
        return starPhoto;
    }

    public void setStarPhoto(String starPhoto) {
        this.starPhoto = starPhoto;
    }

    @Override
    public String toString() {
        return "StarMusic{" +
                "starId=" + starId +
                ", starName='" + starName + '\'' +
                ", starMusicName='" + starMusicName + '\'' +
                ", starLyrics='" + starLyrics + '\'' +
                ", starDate='" + starDate + '\'' +
                ", starScore='" + starScore + '\'' +
                ", starPhoto='" + starPhoto + '\'' +
                ", starMusicAddress='" + starMusicAddress + '\'' +
                '}';
    }
}
