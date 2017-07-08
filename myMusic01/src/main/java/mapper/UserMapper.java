package mapper;

import domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface UserMapper {
    @Select("SELECT userSign FROM user WHERE userName = #{userName}")
    public String selectName(String userName);
}
