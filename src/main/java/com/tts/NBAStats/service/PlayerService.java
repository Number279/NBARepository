package com.tts.NBAStats.service;

import com.tts.NBAStats.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> findAll();
    Optional<Player> findById(Long id);
    List<Player> findByFirstName(String firstName);
    List<Player> findByLastName(String lastName);
    List<Player> sortByPoints();
    List<Player> sortByRebounds();
    List<Player> sortByAssists();
    List<Player> sortBySteals();
    List<Player> sortByBlocks();
    List<Player> sortByPositionByPoints(String position);
    List<Player> sortByPositionByRebounds(String position);
    List<Player> sortByPositionByAssists(String position);
    List<Player> sortByPositionBySteals(String position);
    List<Player> sortByPositionByBlocks(String position);
    void save(Player player);
    void delete(Long id);
}
