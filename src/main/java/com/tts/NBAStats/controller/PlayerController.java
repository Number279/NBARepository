package com.tts.NBAStats.controller;

import com.tts.NBAStats.model.Player;
import com.tts.NBAStats.repo.PlayerRepository;
import com.tts.NBAStats.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerRepository playerRepository;

//    public PlayerController (PlayerRepository playerRepository){
//        this.playerRepository = playerRepository;
//    }
//
//    public PlayerController (PlayerService playerService){
//        this.playerService = playerService;
//    }

    @PostMapping("/add")
    public ResponseEntity<Void> createPlayer(@RequestBody Player player, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        playerService.save(player);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Player> findById(@PathVariable Long id, Model model){
        return playerService.findById(id);
    }

    @GetMapping("/all")
    public Iterable<Player> findAll(){
        return playerService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") Long id){
        playerService.delete(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable(value = "id")Long id, @RequestBody Player player){
        playerService.save(player);
    }

    @GetMapping("/rebounds")
    public Iterable<Player> getRebounds(){
            return playerService.sortByRebounds();
    }

    @GetMapping("/points")
    public Iterable<Player> getPoints(){
        return playerService.sortByPoints();
    }

    @GetMapping("/assists")
    public Iterable<Player> getAssists(){
        return playerService.sortByAssists();
    }

    @GetMapping("/steals")
    public Iterable<Player> getSteals(){
        return playerService.sortBySteals();
    }

    @GetMapping("/blocks")
    public Iterable<Player> getBlocks(){
        return playerService.sortByBlocks();
    }


//    @PostMapping("/player")
//    public void createPlayer(@PathVariable(value = "id") Long id, @RequestBody Player player){
//        playerRepository.save(player);
//    }

//    @GetMapping("/addPlayer")
//    public String addPlayer(Model model){
//        Player player = new Player();
//        model.addAttribute("player", newPlayer);
//        return "addPlayer";
//    }

//    @GetMapping("{firstName}")
//    public

}
