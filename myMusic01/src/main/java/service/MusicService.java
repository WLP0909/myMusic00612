package service;

import domain.Works;
import mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by God汐Like彡 on 2017/7/14.
 */
@Service
public class MusicService {
    @Autowired
    private MusicMapper musicMapper;

    public List<Works> sechMusic(String sech){
        return musicMapper.seletMulit(sech);
    }

    public List<Works> sechMW(String myName,String WorkName){
        return musicMapper.seletMW( myName,WorkName);
    }

}
