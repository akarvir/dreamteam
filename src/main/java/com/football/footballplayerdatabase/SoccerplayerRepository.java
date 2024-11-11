package com.football.footballplayerdatabase;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SoccerplayerRepository extends CrudRepository<Soccerplayer, Integer> {

    List<Soccerplayer> findByNationality(String nationality);
    List <Soccerplayer> findByHeightCmBetween(Double lowerheightbound, Double upperheightbound);
    List<Soccerplayer> findByWeightkgsBetween(Double lowerweightbound, Double upperweightbound);
    List<Soccerplayer> findByAge(int age); 
    List<Soccerplayer> findByAgeLessThan(int age);
    List<Soccerplayer> findByAgeGreaterThan(int age);
    List<Soccerplayer> findByOverallRatingBetween(int lowerratingbound, int higherratingbound);
    List<Soccerplayer> findByOverallRatingGreaterThan(int rating);
    List<Soccerplayer> findByOverallRatingLessThan(int rating); 
    List<Soccerplayer> findByPotentialBetween(int lowerpotentialbound, int higherpotentialbound);
    List<Soccerplayer> findByPotentialGreaterThan(int rating);
    List<Soccerplayer> findByPotentialLessThan(int rating); 
    List<Soccerplayer> findDistinctByNationality(String nationality);
    Soccerplayer findByName(String name);


} 