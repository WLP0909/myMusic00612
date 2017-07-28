package controller;
import domain.*;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.StarMusicService;
import service.UserService;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.*;
import java.util.List;


/**
 * Created by God汐Like彡 on 2017/7/7.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StarMusicService starMusicService;

    @RequestMapping("/Linsert")
    public String insert(User user) {
        userService.insert(user);
        return "middle";
    }

    @RequestMapping("/LSelectN")
    @ResponseBody
    public  String selectN(String userName,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userName",userName);
        String result = Integer.toString(userService.select(userName));
        return result;
    }

    @RequestMapping("/LSelect")
    @ResponseBody
    public String select(String userName, String pUser ,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userName",userName);
        String result = "";
        if ("普通用户".equals(pUser)) {
            result = Integer.toString(userService.select(userName));
        } else if ("管理员".equals(pUser)) {
            result = Integer.toString(userService.selectM(userName));
        }
        return result;
    }

    @RequestMapping("/LSelectP")
    @ResponseBody
    public String selectP(String phone) {
        String result = Integer.toString(userService.selectP(phone));
        return result;
    }

    @RequestMapping("/LSelectPN")
    @ResponseBody
    public String selectP(String phone,String userName) {
        User U  = userService.selectPN(userName);
        String result = U.getUserPhone();
        if(phone.equals(result)){
            return "0";
        } else{
            return "-1";
        }
    }

    //个人动态显示
    @RequestMapping("/UserCenter")
    public String showUserMusic(HttpSession session,ModelMap modelMap){
        //获得session
        String userName = (String)session.getAttribute("userName" );
        modelMap.addAttribute("userName",userName);
        String userName1 = (String)session.getAttribute("name" );
        System.out.println("获得的session"+userName);
        List<List<Works>> worksList = new ArrayList();
        if(userName != null && userName1 != null){
            //查询用户发表的动态歌曲
            List<PersonGeneral> generals = starMusicService.userGeneral(userName);
            System.out.println(generals.isEmpty());
            modelMap.addAttribute("generals",generals);
            for (PersonGeneral general:generals){
                String  generalMusic = general.getGeneralMusic();
                worksList.add(starMusicService.worksMusic(generalMusic));
            }
            List<Integer> num = new ArrayList<Integer>();
            List<Works> w = new ArrayList<Works>();
            for (List<Works> works:worksList){
                for (Works work:works){
                    String workName = work.getWorkName();
                    //查询用户作品的点赞数量
                    Integer num1 = starMusicService.selectGood(workName);
                    num.add(num1);
                    w.add(work);
                }
            }
            modelMap.addAttribute("worksMusic",w);
            modelMap.addAttribute("goodNum",num);
            return "suggestMusic";
        }else{
            return "login";
        }
    }

    @RequestMapping("/selectImage")
    public void selectImage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedImage im = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
        Graphics g = im.getGraphics();//画图
        Color c = new Color(200, 150, 255);
        g.setColor(c);//获取颜色
        g.fillRect(0, 0, 68, 22);//获取框
        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWSYZ0123456789".toCharArray();
        Random r = new Random();
        int len = ch.length, index;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {            //给验证码赋值
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));//每个验证码颜色不同
            g.drawString(ch[index] + "", (i * 15) + 3, 18); //字符画到图片上
            sb.append(ch[index]);//存起来
        }
        HttpSession session = request.getSession();
        session.setAttribute("code", sb.toString());
        System.out.println(sb.toString());
        ImageIO.write(im, "JPG", response.getOutputStream());
    }

    @RequestMapping("/Vai")
    @ResponseBody
    public String vai(String sign, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sign1 = (String) session.getAttribute("code");
        String result = "";
        if (sign == "") {
            result = "0";
        } else if (!sign.equals(sign1)) {
            result = "1";
        }
        return result;
    }


    @RequestMapping("/loginP")
    @ResponseBody
    public String findALL(String name, String pUser,String pwd,HttpServletRequest request) throws SQLException {
        //放入session
        HttpSession session = request.getSession();
        session.setAttribute("name",name);
        session.setAttribute("pwd",pwd);
        boolean b = "普通用户".equals(pUser);
        System.out.println(b);
        boolean b2 = "管理员".equals(pUser);
        System.out.println(b2);
        String r = "";
        if (b) {
            User user = userService.selectByName(name);
            boolean b1 = !pwd.equals(user.getPassword());
            if (b1) {
                r = "-1";
            } else {
                r = "0";
            }
        }else if(b2){
            //session.setAttribute("name",name);
            Admin user1 = userService.selectByMame(name);
            boolean b3 = !pwd.equals(user1.getAdminPsd());
            if(b3){
                r = "-1";
            }else {
                r = "0";
            }
        }
        return r;
    }

    @RequestMapping("/getMessage")
    @ResponseBody
    public String getSign(String phone,HttpServletRequest request){
        String sign = signValue();
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://sms.webchinese.cn/web_api/");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", "testttt"),new NameValuePair("Key", "c68a23bdc7a5c8664507"),new NameValuePair("smsMob",phone),new NameValuePair("smsText","myMusic提醒您，您的验证码是："+sign)};
        HttpSession session = request.getSession();
        session.setAttribute("sign",sign);
        post.setRequestBody(data);
        String result;
        try {
            client.executeMethod(post);
            Header[] headers = post.getResponseHeaders();
            int statusCode = post.getStatusCode();
            for(Header h : headers)
            {
                System.out.println(h.toString());
            }
            result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        post.releaseConnection();
        return "验证码已发送！";
    }


    //判断验证码是否输入正确
    @RequestMapping("/testSign")
    @ResponseBody
    public String testSign(String newSign,HttpServletRequest request){
        HttpSession session = request.getSession();
        String sign1 = (String) session.getAttribute("sign");
        if(newSign.equals(sign1)){
            return "0";
        }else{
            return "1";
        }
    }

    //修改密码
    @RequestMapping("/alterPwd")
    @ResponseBody
    public String alterPwdU(String password,String userName){
        User user = new User();
        user.setPassword(password);
        user.setUserName(userName);
        System.out.println(user.getPassword());
        String result = String.valueOf(userService.alterPwd(user));
        return result;
    }

   //生成随机的验证码
    private static String signValue(){
        SecureRandom s =  new SecureRandom();
        String sign=String.valueOf(s.nextInt()).substring(1,7);
        return sign;
    }

    //-------------------------个人中心--------------------------------
    /**
     * 个人中心页面
     * */
    //跳转个人中心主页
    @RequestMapping("/personal")
    public String selectName( HttpServletRequest request, ModelMap modelMap){
        System.out.println("已经进入个人中心的controller");
        HttpSession session = request.getSession();
        String userName =(String)session.getAttribute("name"); //获得session
        String pwd = (String)session.getAttribute("pwd");
        System.out.println("用户名:"+userName);
        //判断用户是否登录
        if ((userName != null) && (pwd != null)){
            //个人信息
            User users = userService.selectUserInfoByName(userName);
            modelMap.addAttribute("user",users);
            //关注数
            Integer interestNum =userService.SelectInterestNum(userName);
            modelMap.addAttribute("interest",interestNum);
            //粉丝数
            int toInterestNum =userService.SelectToInterestNum(userName);
            modelMap.addAttribute("toInterest",toInterestNum);
            //查询我的作品
            List<Works> list = userService.selectworks(userName);
            modelMap.addAttribute("works",list);
            for (Works work:list){
                System.out.println(work.getWorksDate());
            }
            return "personal";
        }
        else{
            return "login";
        }
    }

    //查看歌手个人中心信息
    @RequestMapping("/LookPersonal")
    public String lookPersonal(String userName,ModelMap modelMap){
        //个人信息
        User users = userService.selectUserInfoByName(userName);
        modelMap.addAttribute("user",users);
        //关注数
        Integer interestNum =userService.SelectInterestNum(userName);
        modelMap.addAttribute("interest",interestNum);
        //粉丝数
        int toInterestNum =userService.SelectToInterestNum(userName);
        modelMap.addAttribute("toInterest",toInterestNum);
        //查询我的作品
        List<Works> list = userService.selectworks(userName);
        modelMap.addAttribute("works",list);
        return "personal";
    }

    //模糊查询我的作品
    @RequestMapping("/searchMyWork")
    public String selectWorksByKey(String key, ModelMap modelMap, HttpServletRequest request , HttpServletResponse response){
        //获得session
        HttpSession session = request.getSession();
        String userName=(String) session.getAttribute("userName");
        //模糊查询
        List<Works> works=userService.selectWorksByKey(key,userName);
        modelMap.addAttribute("user",works);
        //查询个人信息
        User users = userService.selectUserInfoByName(userName);
        modelMap.addAttribute("user",users);
        //关注数
        Integer interestNum =userService.SelectInterestNum(userName);
        modelMap.addAttribute("interest",interestNum);
        //粉丝数
        int toInterestNum =userService.SelectToInterestNum(userName);
        modelMap.addAttribute("toInterest",toInterestNum);
        //查询我的作品
        List<Works> list = userService.selectworks(userName);
        modelMap.addAttribute("works",list);
        return "personal";
    }
    //----------------------------------我的关注----------------------------------------
    /**
     * 我关注人信息的界面
     * */
    //查询我关注人的信息
    @RequestMapping("/selectInterestInfo")
    public String selectInterestInfo(ModelMap modelMap, HttpSession session  ){
        String sesionUserNmae =(String) session.getAttribute("userName"); //获得session
        List<User> list = userService.selectInterestInfo(sesionUserNmae);
        modelMap.addAttribute("interest",list);
        return "interest";
    }
    //模糊查询我关注的人
    @RequestMapping("/selectInterestInfoByKey")
    public String selectInterestInfoByKey(User user,ModelMap modelMap, HttpSession session){
        String sesionUserNmae =(String) session.getAttribute("userName"); //获得session
        List<User> list = userService.selectInterestInfoByKey(user,sesionUserNmae);
        modelMap.addAttribute("interest",list);
        return "interest";
    }

//----------------------------------我的粉丝------------------------------------------
    /**
     * 我的粉丝的信息界面
     * */
    //查询我粉丝的信息
    @RequestMapping("/selectToInterestInfo")
    public String selectToInterestInfo(ModelMap modelMap, HttpSession session){
        String SessionUserName =(String) session.getAttribute("userName"); //获得session
        List<User> list = userService.selectToInterestInfo(SessionUserName);
        modelMap.addAttribute("toInterest",list);
        return "toInterest";

    }
    //-------------------------------------编辑资料-----------------------------------------------
    //修改个人信息
    @RequestMapping("/updatePersonalInfo")
    public String update(@RequestParam("file")MultipartFile file, String userName, String password, String userSex, int userAge, String userPhone, String address, String userSign, Integer id, ModelMap modelMap, HttpSession session){
        User u=new User();
        u.setUserId(id);
        u.setUserPhoto(file.getOriginalFilename());
        u.setUserName(userName);
        u.setPassword(password);
        u.setUserSex(userSex);
        u.setUserAge(userAge);
        u.setUserPhone(userPhone);
        u.setAddress(address);
        u.setUserSign(userSign);
        userService.update(u);

        User users = userService.selectUserInfoByName(u.getUserName());
        modelMap.addAttribute("user",users);

        //查询我的作品
        List<Works> list = userService.selectworks(userName);
        modelMap.addAttribute("works",list);
        return "personal";
    }


    @RequestMapping("/per")
    public String selectOne(Integer id,ModelMap modelMap){
        User user=  userService.selectOne(id);
        modelMap.addAttribute("user",user);
        return "alterPersonalInfo";
    }

    //删除作品
    @RequestMapping("/deleteWorkById")
    public String deleteWorkById(int workId,HttpServletRequest request,ModelMap modelMap){
        System.out.println("删除的作品id:"+workId);
        userService.deleteWorkById(workId);
        //删除作品
        String  userName = (String)request.getSession().getAttribute("userName");
        //查询个人信息
        User users  = userService.selectUserInfoByName(userName);
        modelMap.addAttribute("user",users);
        //关注数
        Integer interestNum =userService.SelectInterestNum(userName);
        modelMap.addAttribute("interest",interestNum);
        System.out.println("测试关注人数："+interestNum);
        //粉丝数
        int toInterestNum =userService.SelectToInterestNum(userName);
        modelMap.addAttribute("toInterest",toInterestNum);
        System.out.print("粉丝数："+toInterestNum);
        //查询我的作品
        List<Works> list = userService.selectworks(userName);
        modelMap.addAttribute("works",list);
        return "personal";
    }
}

