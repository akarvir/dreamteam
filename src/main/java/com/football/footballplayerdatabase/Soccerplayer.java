package com.football.footballplayerdatabase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.sql.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="footballplayers")
public class Soccerplayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id; 

    private String name;

    private String full_name;

    private Date birth_date;

    private Integer age; 

    private Double heightCm; 

    private Double weightkgs; 

    private String positions;

    private String nationality;

    private int overallRating;

    private int potential;     

    @ManyToOne
    private User user; 


    
}
