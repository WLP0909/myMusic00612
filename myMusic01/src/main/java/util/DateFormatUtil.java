package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/13.
 */
public class DateFormatUtil {
    public static  String date2str(Date date){
        String date2str=null;
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        date2str=format.format(date);
        return  date2str;
    }
    public static  Date str2date(String strDate){
        Date str2date=null;
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            str2date=format.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  str2date;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println( "测试date2string: "+date2str(new Date()));
        System.out.println( "测试 str2date  : "+str2date("2017-07-13"));
    }
}
