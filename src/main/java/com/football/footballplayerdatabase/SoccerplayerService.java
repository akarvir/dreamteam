package com.football.footballplayerdatabase;
import java.util.List; 
import org.springframework.stereotype.Service; 
import org.springframework.beans.factory.annotation.Autowired;
import com.football.footballplayerdatabase.SoccerplayerRepository;
@Service
public class SoccerplayerService {

    @Autowired
    private SoccerplayerRepository soccerplayerrepository;

    // Just two methods for now; need to quickly spin up the frontend. 

    List<Soccerplayer> findplayerswithnationality(String nationality) {return soccerplayerrepository.findByNationality(nationality);}
    List<Soccerplayer> findplayerswithage(int age) {return soccerplayerrepository.findByAge(age);}
    Iterable<Soccerplayer> findingallnationalities() {return soccerplayerrepository.findAll(); }
    Soccerplayer findplayerwithname(String name) {return soccerplayerrepository.findByName(name);}
    





}
