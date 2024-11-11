package com.football.footballplayerdatabase;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name= "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id; 

    private String username;

    private String password; 
    
     @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Soccerplayer> team;

    


    // custom constructor; 
    public User(String username, String password) {
        this.username = username; 
        this.password = password; 
        this.team = new ArrayList<Soccerplayer>(); 
    }

}
