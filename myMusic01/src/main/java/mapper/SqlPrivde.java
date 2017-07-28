package mapper;

/**
 * Created by God汐Like彡 on 2017/7/14.
 */
public class SqlPrivde {
    public String getSql(String musicName){
        String sql = new StringBuilder()
                .append("select * ")
                .append("from mymusic.works ")
                .append("where workName like '%").append(musicName).append("%'")
                .toString();
        return sql;
    }

    public String getSqlMW(String WorkName,String myName){
        StringBuilder sql1 = new StringBuilder("select * from mymusic.works");
        sql1.append(" where workName like '%"+WorkName+"%'");
        if(!"".equals(myName)&&myName!=null){
            sql1.append(" and userName like '%"+myName+"%'");
        }
        String sql=sql1.toString();
        return sql;
    }
}
