package com.tts.NBAStats.controller;

import com.tts.NBAStats.model.Player;
import com.tts.NBAStats.repo.PlayerRepository;
import com.tts.NBAStats.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "nbaPlayers", description = "Operations pertaining to NBA player database.")
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

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved the player."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "Get Players by ID", response = Player.class,
            responseContainer = "Individual")
    @GetMapping("/{id}")
    public Optional<Player> findById(@PathVariable Long id, Model model){
        return playerService.findById(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all players."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "Get all players.", response = Player.class,
            responseContainer = "List")
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

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all players ordered by points."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "Sort all players by total points.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/points")
    public Iterable<Player> getPoints(){
        return playerService.sortByPoints();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all players ordered by total rebounds."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "Sort all players by total rebounds.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/rebounds")
    public Iterable<Player> getRebounds(){
            return playerService.sortByRebounds();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all players ordered by total assists."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "Sort all players by total assists..", response = Player.class,
            responseContainer = "List")
    @GetMapping("/assists")
    public Iterable<Player> getAssists(){
        return playerService.sortByAssists();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all players ordered by total steals."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "Sort all players by total steals.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/steals")
    public Iterable<Player> getSteals(){
        return playerService.sortBySteals();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved all players ordered by total blocks."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "Sort all players by total blocks.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/blocks")
    public Iterable<Player> getBlocks(){
        return playerService.sortByBlocks();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved the position sorted by points."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "All players of a specific position sorted by total points.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/points/position")
    public List<Player> sortByPointsByPosition(@RequestParam(value="position", required = false) String position){
        if(position!=null){
            return playerService.sortByPositionByPoints(position);}
        return playerService.sortByPoints();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved the position sorted by rebounds."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "All players of a specific position sorted by total rebounds.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/rebounds/position")
    public List<Player> sortByReboundsByPosition(@RequestParam(value="position", required = false) String position){
        if(position!=null){
            return playerService.sortByPositionByRebounds(position);}
        return playerService.sortByRebounds();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved the position sorted by assists."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "All players of a specific position sorted by total assists.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/assists/position")
    public List<Player> sortByAssistsByPosition(@RequestParam(value="position", required = false) String position){
        if(position!=null){
            return playerService.sortByPositionByAssists(position);}
        return playerService.sortByAssists();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved the position sorted by blocks."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "All players of a specific position sorted by total blocks.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/blocks/position")
    public List<Player> sortByBlocksByPosition(@RequestParam(value="position", required = false) String position){
        if(position!=null){
            return playerService.sortByPositionByBlocks(position);}
        return playerService.sortByBlocks();
    }

    @ApiResponses(value = {
            @ApiResponse(code=200, message="Successfully retrieved the position sorted by steals."),
            @ApiResponse(code = 401, message = "You are not authorized to view this menu item.")
    })
    @ApiOperation(value = "All players of a specific position sorted by total steals.", response = Player.class,
            responseContainer = "List")
    @GetMapping("/steals/position")
    public List<Player> sortByStealsByPosition(@RequestParam(value="position", required = false) String position){
        if(position!=null){
            return playerService.sortByPositionBySteals(position);}
        return playerService.sortBySteals();
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
