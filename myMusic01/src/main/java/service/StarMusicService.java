package service;

import domain.PersonGeneral;
import domain.StarMusic;
import domain.User;
import domain.Works;
import mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WLP on 2017/7/7.
 */
@Service
public class StarMusicService {

    @Autowired
    private MusicMapper musicMapper;

    public List<StarMusic> suggestStarMusic(){
        return musicMapper.suggestStarMusic();
    }

    public List<Works> suggestWorkMusic(){
        return musicMapper.suggestWorksMusic();
    }

    public List<StarMusic> listStarMusic(){
        return musicMapper.listStarMusic();
    }

    public List<User> selectNearUser(String address){
        return musicMapper.selectNearUser(address);
    }

    public List<Works> bestUserMusic(){
        return musicMapper.bestUserMusic();
    }

    public List<Works> bestHistoryMusic(){
        return musicMapper.bestHistoryMusic();
    }

    public List<StarMusic> findStarMusic() {
        return musicMapper.selectStarMusic();
    }

    public List<PersonGeneral> userGeneral(String userName){
        return musicMapper.selectUserGener(userName);
    }

    public List<Works> worksMusic(String generalMusic){
        return musicMapper.workMusic(generalMusic);
    }

    public Integer selectGood(String workName){
        return musicMapper.selectGood(workName);
    }
}
