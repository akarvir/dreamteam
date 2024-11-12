package com.football.footballplayerdatabase;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.json.JSONObject;
import java.util.List;


import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userservice; 
    @Autowired
    private SoccerplayerService playerservice; 

    @PostMapping("/addplayer")
    @ResponseBody
    public  ResponseEntity<Void>  addingplayer(@RequestBody String input) {

        
        JSONObject object = new JSONObject(input);
      
        String username = object.getString("username");
       
        String playername = object.getString("playername");
       
        
       User user = userservice.finduserbyusername(username);

       
       
       for(Soccerplayer player: user.getTeam()) {
            if(player.getName().equals(playername)) return ResponseEntity.status(HttpStatus.OK).build();
       }
       
       Soccerplayer player = playerservice.findplayerwithname(playername);
       
       
       user.getTeam().add(player);
       userservice.update(user);
       User user2 = userservice.finduserbyusername(username);
       for(Soccerplayer teamplayer: user2.getTeam()) {System.out.println("The newest player to have been added is " + teamplayer.getName());}
      
       
       return ResponseEntity.status(HttpStatus.OK).build();


    }
    


    @GetMapping("/experiment")
    @ResponseBody
    public String greet() {
        
        return "hello";}





     @PostMapping("/login")
    public String loggingin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        if(userservice.userhasanaccount(username)) {
            model.addAttribute("user",username);
            return "trial";
        }
        model.addAttribute("accountstatus","You do not have an account. Please create one");
        return "createaccount";
}

    @PostMapping("/personalteam")
    @ResponseBody
    public ResponseEntity<List<Soccerplayer>> generatingteam(@RequestBody String input) {

        JSONObject object = new JSONObject(input);
        String username = object.getString("username");
        User user = userservice.finduserbyusername(username);
      
        
        for (Soccerplayer player:user.getTeam()) System.out.println(player.getName());
        return new ResponseEntity<List<Soccerplayer>>(user.getTeam(),HttpStatus.OK);


    }


    @PostMapping("/createdaccount")
    public String createdaccount(@RequestParam("newusername") String username, @RequestParam("newpassword") String password) {

        
        User user = new User(username, password);
        userservice.addusertodatabase(user);
        return "login"; 

    }

    @PostMapping("/removeplayer")
    public ResponseEntity<Void> removingplayer(@RequestBody String input) {

       
        JSONObject object = new JSONObject(input);
        String playername = object.getString("playername"); 
        String username = object.getString("username");
        User user = userservice.finduserbyusername(username);
        for(Soccerplayer player: user.getTeam()) {
            if(player.getName().equals(playername)) {
                user.getTeam().remove(player);
                userservice.update(user);
                return ResponseEntity.status(HttpStatus.OK).build(); 
            }
        }
        return ResponseEntity.status(HttpStatus.OK).build(); 


    }



    
}
