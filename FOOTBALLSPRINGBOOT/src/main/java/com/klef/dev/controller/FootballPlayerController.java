package com.klef.dev.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.klef.dev.entity.FootballPlayer;
import com.klef.dev.service.FootballPlayerService;

@RestController
@RequestMapping("/fplayerapi")
@CrossOrigin(origins = "*")
public class FootballPlayerController {

    @Autowired
    private FootballPlayerService service;

    @GetMapping("/")
    public String home() {
        return "Football Player API is running...";
    }

    @PostMapping("/add")
    public ResponseEntity<FootballPlayer> addPlayer(@RequestBody FootballPlayer player) {
        player.setId(null);  // <--- ensure ID is not manually set
        FootballPlayer saved = service.addPlayer(player);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<FootballPlayer>> getAllPlayers() {
        List<FootballPlayer> players = service.getAllPlayers();
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable int id) {
        FootballPlayer player = service.getPlayerById(id);
        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Player with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePlayer(@RequestBody FootballPlayer player) {
        FootballPlayer existing = service.getPlayerById(player.getId());
        if (existing != null) {
            FootballPlayer updated = service.updatePlayer(player);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot update. Player with ID " + player.getId() + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        FootballPlayer existing = service.getPlayerById(id);
        if (existing != null) {
            service.deletePlayerById(id);
            return new ResponseEntity<>("Player with ID " + id + " deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot delete. Player with ID " + id + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
