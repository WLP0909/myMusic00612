package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

/**
 * Created by Administrator on 2017/7/7.
 */
@Controller

//@RequestMapping( "/account/")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String selectName(String userName){
        String str = userService.selectName(userName);
        System.out.println("用户名"+str);
          //  return "WEB-INF/account/login";
        return "WEB-INF/account/login";
    }
}
