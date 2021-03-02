package com.tts.NBAStats.service;

import com.tts.NBAStats.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> findAll();
    Optional<Player> findById(Long id);
    List<Player> findByFirstName(String firstName);
    List<Player> findByLastName(String lastName);
    List<Player> findByPoints(int points);
    List<Player> sortByRebounds();
    List<Player> findByAssists(int assists);
    List<Player> findBySteals(int steals);
    List<Player> findByBlocks(int blocks);
    void save(Player player);
    void delete(Long id);
}