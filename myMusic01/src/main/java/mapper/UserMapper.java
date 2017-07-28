package mapper;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import domain.Admin;
import domain.User;
import domain.Works;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by God汐Like彡 on 2017/7/7.
 */
public interface UserMapper {

    //插入注册用户信息
    @Insert("insert into mymusic.user (userName,password,userSex,userPhone,address) values (#{userName},#{password},#{userSex},#{userPhone},#{address})")
    int insert(User user);

    //查询同名的用户
    @Select("select count(*) from mymusic.user where userName = #{userName}")
    int select(String userName);

    //查询手机号是否被重复使用
    @Select("select count(*) from mymusic.user where userPhone = #{userPhone}")
    int selectP(String phone);

    //查找管理员用户
    @Select("select count(*) from mymusic.admin where adminName = #{adminName}")
    int selectM(String adminName);

    //根据用户名查询用户密码和用户名
    @Select("select userName, password from mymusic.user where userName = #{userName} ")
    User selectByName(String userName);

    //根据管理员用户名查询密码和用户名
    @Select("select adminName,adminPsd from mymusic.admin where adminName = #{adminName}")
    Admin selectByMame(String adminName);

    //查询用户的电话号码
    @Select("select userPhone from mymusic.user where userName = #{userName}")
    User selectPN(String userName);

    //修改密码
    @Update("update mymusic.user set password = #{password} where userName = #{userName} ")
    int alterPwd(User user);
    //-----------------------个人中心部分------------------------
    //查询个人中心信息
    @Select("SELECT userId,userName,password,userSex,userAge,userPhoto,address,userSign" +
            " FROM user WHERE userId=(SELECT userId FROM user WHERE userName = #{userName})")
    User selectUserInfoByName(String userName);

    //查询关注数
    @Select("SELECT count(userId) FROM interest  WHERE userName = #{userName} ")
    int SelectInterestNum(String userName);

    //查询粉丝数
    @Select("SELECT count(userId) FROM tointerest  WHERE userName = #{userName}")
    int SelectToInterestNum(String userName);

    //查询我全部的作品
    @Select("SELECT time,workId,workName,worksDate,workAddress FROM works w JOIN user u ON w.userName = u.userName " +
            " WHERE w.userName = #{userName} " +
            " ORDER BY worksDate DESC LIMIT 6;")
    List<Works> selectWorks(String userName);

    //模糊查询我的作品
    @SelectProvider(type = GetSelectSql.class,method = "getSelectSql")
    List<Works> selectWorksByKey(String key,String userName1);

    //查询我关注人的信息
    @SelectProvider(type = GetSelectSql.class, method = "getInterestWorkId")
    List<User> selectInterestInfo(String userName);

    //模糊查询我关注的人
    @SelectProvider(type= GetSelectSql.class, method = "getSelectInterest")
    List<User> selectInterestInfoByKey(User user,  String SessionUserName);

    //查询我粉丝的信息
    @SelectProvider(type = GetSelectSql.class, method="getToInterestInfo")
    List<User> selectToInterestInfo(String SessionUserName);

    //修改个人信息
    @Update("update user set userName=#{userName},password=#{password},userSex=#{userSex},userAge=#{userAge},userPhone=#{userPhone},address=#{address},userPhoto=#{userPhoto},userSign=#{userSign} where userId=#{userId}")
    int update(User user);

    //按id查找
    @Select("select * from user where userId=#{userId}")
    User selectOne(Integer userId);

    //删除我的作品
    @Delete("DELETE FROM works WHERE workId=#{workId}")
    int deleteWorkById(Integer workId);
}
