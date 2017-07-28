package controller;

import domain.PersonGeneral;
import domain.StarMusic;
import domain.User;
import domain.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.StarMusicService;
import util.AddressUtils;
import util.FindIP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 * Created by WLP on 2017/7/7.
 */
@Controller
public class StarMusicController {

    @Autowired
    private StarMusicService starMusicService;

    //显示首页推荐歌曲
    @RequestMapping("/First")
    public String firstPage(ModelMap modelMap, HttpServletRequest request){
        HttpSession session = request.getSession();
        //明星新歌推荐
        List<StarMusic> starMusics = starMusicService.suggestStarMusic();
        modelMap.addAttribute("starMusics",starMusics);

        List<Works> worksMusic = starMusicService.suggestWorkMusic();
        modelMap.addAttribute("workMusics",worksMusic);

        //明星高分排行榜
        List<StarMusic> listStarMusic = starMusicService.listStarMusic();
        session.setAttribute("listStarMusic",listStarMusic);

        //大众排行榜
        List<Works> bestUserMusic = starMusicService.bestUserMusic();
        session.setAttribute("bestMusic",bestUserMusic);

        //大众历史排行榜
        List<Works> bestHistoryMusic = starMusicService.bestHistoryMusic();
        session.setAttribute("historyMusic",bestHistoryMusic);
        return "suggestMusic";
    }

    //显示附近的用户
    @RequestMapping("/Near")
    public String nearUser(ModelMap modelMap){
        String address = "";
        String ip = "";
        AddressUtils add = new AddressUtils();
        FindIP findip = new FindIP();
        try{
            ip = findip.findIP();
            address = add.getAddress("ip="+ip, "utf-8");
            List<User> users = starMusicService.selectNearUser(address);
            modelMap.addAttribute("users",users);
            System.out.println(users.isEmpty());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "suggestMusic";
    }

    //查询明星歌曲返回歌曲信息
    @RequestMapping("/selectMusic")
    @ResponseBody
    public List<StarMusic> selectStarMusic(int id) {
        if(id==2){
            List<StarMusic> listStarMusic = starMusicService.listStarMusic();
            return listStarMusic;
        }else {
            List<StarMusic> starMusics = starMusicService.suggestStarMusic();
            return starMusics;
        }
    }

    //查询用户歌单信息
    @RequestMapping("/selectUserMusic")
    @ResponseBody
    public List<Works> selectUserMusic(int id){
        if (id == 3){
            List<Works> selectUserMusic = starMusicService.suggestWorkMusic();
            for (Works work:selectUserMusic){
                System.out.println(work);
            }
            return selectUserMusic;
        }else if (id == 4){
            List<Works> bestUserMusic = starMusicService.bestUserMusic();
            return bestUserMusic;
        }else {
            List<Works> bestHistoryMusic = starMusicService.bestHistoryMusic();
            return bestHistoryMusic;
        }
    }

    //用户新歌推荐查看更多
    @RequestMapping("/userMore")
    public String userMore(ModelMap modelMap){
        List<Works> worksMusic = starMusicService.suggestWorkMusic();
        modelMap.addAttribute("workMusics",worksMusic);
        return "List";
    }

    //明星新歌推荐查看更多
    @RequestMapping("/starMore")
    public String starMore(ModelMap modelMap){
        List<StarMusic> starMusics = starMusicService.suggestStarMusic();
        modelMap.addAttribute("starMusics",starMusics);
        return "List";
    }
}
