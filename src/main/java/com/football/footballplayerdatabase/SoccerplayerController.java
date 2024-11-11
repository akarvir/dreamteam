package com.football.footballplayerdatabase;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import java.util.ArrayList;

// Return JSON formatted string

//http://localhost:8080/soccerplayer/nationality



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/soccerplayer") 


public class SoccerplayerController {
    
    @Autowired
    private SoccerplayerService soccerplayerservice; 

    @GetMapping("/nationality")
    public ResponseEntity<List<Soccerplayer>> findsoccerplayersbynationality() {
        
         return new ResponseEntity<List<Soccerplayer>>(soccerplayerservice.findplayerswithnationality("Argentina"),HttpStatus.OK);
    }

    @GetMapping("/renderingnationalities")
    public ResponseEntity<List<String>> findingallnationalities() {
        
        Iterable<Soccerplayer> iterable = soccerplayerservice.findingallnationalities();
        List<String> list = new ArrayList<String>();
        for(Soccerplayer player: iterable) if(!(list.contains(player.getNationality()))) list.add(player.getNationality());
        return new ResponseEntity<List<String>>(list,HttpStatus.OK);


    }

    @PostMapping("/selectednationality")
    public ResponseEntity<List<Soccerplayer>> generatingtable(@RequestBody String input) {
        JSONObject jsonObject = new JSONObject(input);
        
        // Access the value associated with the key "country"
        String country = jsonObject.getString("country");
        return new ResponseEntity<List<Soccerplayer>>(soccerplayerservice.findplayerswithnationality(country),HttpStatus.OK);
    }
   


}
