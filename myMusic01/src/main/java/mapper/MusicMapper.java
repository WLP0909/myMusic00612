package mapper;

import domain.PersonGeneral;
import domain.StarMusic;
import domain.User;
import domain.Works;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by WLP on 2017/7/7.
 */
@Mapper
public interface MusicMapper {

    //明星新歌推荐歌曲
    @Select("SELECT starPhoto,starName,starMusicName,starMusicAddress,starLyrics,starId FROM starmusic order by starDate DESC")
    List<StarMusic> suggestStarMusic();

    //大众推荐歌曲
    @Select("SELECT worksDate,photo,u.userName userName,workName,workAddress,workLyrics FROM works w JOIN user u ON(w.userId = u.userId) order by w.worksDate DESC")
    List<Works> suggestWorksMusic();

    //明星高分榜
    @Select("SELECT * FROM starmusic order by starScore")
    List<StarMusic> listStarMusic();

    //附近的人查询
    @SelectProvider(type = SelectSQL.class,method ="selectNearUser" )
    List<User> selectNearUser(String address);

    //查询当前月份的最好大众歌曲
    @Select("SELECT * FROM works\n" +
            "WHERE PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( worksDate, '%Y%m' ) ) =0 " +
            "ORDER BY good DESC")
    List<Works> bestUserMusic();

    //历史最好大众音乐
    @Select("SELECT * FROM works order by good DESC")
    List<Works> bestHistoryMusic();

    //查询歌曲信息
    @Select("SELECT starName,starMusicName,starLyrics,starPhoto,starMusicAddress from starmusic")
    List<StarMusic> selectStarMusic();

    //查询个人动态
    @Select("SELECT userName,userPhoto,userSign,generalMusic,generDate from user JOIN general ON (userId = myId) WHERE userName =#{userName} order by generDate DESC")
    List<PersonGeneral> selectUserGener(String userName);

    //根据发表的动态去作品表查找用户创作的歌曲
    @Select("SELECT * FROM works WHERE workName =#{generalMusic}")
    List<Works> workMusic(String generalMusic);

    //根据输入的歌曲名查找歌曲
    @SelectProvider(type=SqlPrivde.class,method = "getSql")
    List<Works> seletMulit(String sech);

    //根据输入的歌曲名和歌唱者查找
    @SelectProvider(type=SqlPrivde.class,method = "getSqlMW")
    List<Works> seletMW(String myName,String WorkName );

    //查询用户作品的点赞数
    @Select("SELECT good FROM works WHERE workName=#{workName}")
    Integer selectGood(String workName);

}
