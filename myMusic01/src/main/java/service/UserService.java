package service;


import domain.Admin;
import domain.User;
import domain.Works;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by God汐Like彡 on 2017/7/7.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    //用户注册
    @Transactional
    public void insert(User user){
        userMapper.insert(user);
    }

    //查询同名用户
    public int select(String userName){
        return userMapper.select(userName);
    }

    //查询重复的电话号码
    public int selectP(String phone){
        return userMapper.selectP(phone);
    }

    //查找管理员用户
    public int selectM(String adminName){
        return userMapper.selectM(adminName);
    }

    //查询普通用户的密码和姓名
    public User selectByName(String userName){
        return userMapper.selectByName(userName);
    }

    //查询管理员密码姓名
    public Admin selectByMame(String adminName){
        Admin u = userMapper.selectByMame(adminName);
        return u;
    }

    //查询用户的电话号码
    public User selectPN(String userName){
        return userMapper.selectPN(userName);
    }

    //修改密码
    @Transactional
    public int alterPwd(User user){
        return userMapper.alterPwd(user);
    }
    //----------------------------个人中心-----------------------------------

    //个人信息查询
    public User selectUserInfoByName(String userName){
        return  userMapper.selectUserInfoByName(userName);
    }

    //查询关注数
    public  int SelectInterestNum(String userName){
        return userMapper.SelectInterestNum(userName);
    }

    //查询粉丝数
    public  int SelectToInterestNum(String userName ){
        return  userMapper.SelectToInterestNum(userName);
    }

    //查询我的作品
    public List<Works>selectworks(String userName){
        return userMapper.selectWorks(userName);
    }

    //模糊查询我的作品
    public List<Works>selectWorksByKey(String key,String userName){
        return userMapper.selectWorksByKey(key,userName);
    }

    //查询我关注人的信息
    public List<User> selectInterestInfo(String SessionuserName){
        return userMapper.selectInterestInfo(SessionuserName);
    }

    //模糊查询我关注的人的信息
    public List<User> selectInterestInfoByKey(User user ,String sessionUserName){
        return userMapper.selectInterestInfoByKey(user , sessionUserName);
    }

    //查询我的粉丝信息
    public List<User> selectToInterestInfo(String SessionUserName){
        return userMapper.selectToInterestInfo(SessionUserName);
    }

    //修改信息
    @Transactional
    public int update(User user){
        return userMapper.update(user);
    }

    //按id查询
    public User selectOne(Integer userId){
        return userMapper.selectOne(userId);
    }

    //删除
    public int deleteWorkById(Integer workId){
        return userMapper.deleteWorkById(workId);
    }

}

