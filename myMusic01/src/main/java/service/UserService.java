package service;


import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/7.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    //查询姓名  《测试》
    public String selectName(String userName){
       return userMapper.selectName(userName);
    }

}
