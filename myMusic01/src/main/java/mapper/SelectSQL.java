package mapper;

/**
 * Created by WLP on 2017/7/12.
 */
public class SelectSQL {

    public String selectNearUser(String address){
        String sql = new StringBuilder().append("SELECT userName,userSex,userAge,userPhoto,address ")
                .append("FROM user WHERE address LIKE '%").append(address)
                .append("%' ").toString();
        return sql;
    }
}
