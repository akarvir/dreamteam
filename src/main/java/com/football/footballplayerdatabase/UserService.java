package com.football.footballplayerdatabase;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepository; 

    public User finduserbyusername(String username) {return userrepository.findByUsername(username);}
    public boolean userhasanaccount(String username){return userrepository.existsByUsername(username);}
    public void addusertodatabase(User user) {userrepository.save(user);}
    public void update(User user) {userrepository.save(user);}
    



    
    
}
