package controller;

import domain.Works;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MusicService;
import service.StarMusicService;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class MusicSechController {
    @Autowired
    private MusicService musicService;

    @Autowired
    private StarMusicService starMusicService;

    @RequestMapping("/sechMu")
    @ResponseBody
    public List<String> sechMusic(String sech){
        List<Works> works = musicService.sechMusic(sech);
        int total=(works.size()>5?5:works.size());
        List<String> lists = new ArrayList<String>();
        for(int i=1;i<=total;i++){
            try {
                String str1 = works.get(i-1).getWorkName();
                String str2 = works.get(i-1).getUserName();
                String str="";
                if(!"".equals(str2)&&str2!=null){
                     str =str1+" - "+str2;
                }else{
                     str =str1;
                }
                lists.add(str);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return lists;
    }

    @RequestMapping("/sechShow")
    public String seachShowMusic(String str, ModelMap modelMap){
        String musicName = "";
        String WorkName = "";
        List<Works> works = new ArrayList<Works>();
        if(str.contains("-")){
           musicName = str.substring(0,str.indexOf("-"));
           WorkName = str.substring(str.indexOf("-")+1);
           works = musicService.sechMW(musicName,WorkName);
        }else {
           works = musicService.sechMW(str,WorkName);
        }
        modelMap.addAttribute("works",works);
        return "MusicShow";
    }
}
