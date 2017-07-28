package mapper;

import domain.User;

/**
 * Created by Administrator on 2017/7/13.
 */
public class GetSelectSql {
    //模糊查询我的作品
    public String  getSelectSql(String key,String userName1){
        return new StringBuilder()
                .append("SELECT time,workId ,workName,worksDate FROM works ")
                .append(" WHERE workName LIKE '%").append(key).append("%'")
                .append(" AND userName = '").append(userName1).append("'")
                .toString();
    }
    //查询我关注人的信息
    public String getInterestWorkId(String SessionUserName){  //SessionUserName 表示session中获得用户名
        return new StringBuilder()
                .append(" SELECT userName,userSex,userAge,userPhoto,address,userSign FROM user WHERE userId IN")
                .append(" (SELECT userId FROM interest WHERE userName = ").append("'").append(SessionUserName).append("'").append(")")
                .toString();
    }
    //模糊查询我关注人的信息
    public String getSelectInterest(User user,String SessionUserName){
        return new StringBuilder()
                .append(" SELECT userName,userSex,userAge,userPhoto,address,userSign FROM user WHERE userId IN  ")
                .append(" (SELECT userId FROM interest WHERE userName = '").append(SessionUserName).append("' ）")
                .append(" AND userName Like '%").append("#{userName}").append(" %'")
                .toString();
    }

    //查询我粉丝的信息
    public String getToInterestInfo(String SessionUserName){  //SessionUserName 表示session中获得用户名
        return new StringBuilder()
                .append(" SELECT userName,userSex,userAge,userPhoto,address,userSign FROM user WHERE userId IN ")
                .append("(SELECT userId FROM tointerest WHERE userName = ").append("'").append(SessionUserName).append("'").append(")")
                .toString();
    }

}
