package com.tts.NBAStats.service;

import com.tts.NBAStats.model.Player;
import com.tts.NBAStats.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.SpringObjenesis;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findByFirstName(String firstName) {
        return playerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Player> findByLastName(String lastName) {
        return playerRepository.findByLastName(lastName);
    }

    @Override
    public List<Player> findByPoints(int points) {
        return playerRepository.findByPoints(points);
    }

    @Override
    public List<Player> sortByRebounds() {
        List<Player> players = playerRepository.findAllByOrderByReboundsDesc();
        return players;
    }

    @Override
    public List<Player> findByAssists(int assists) {
        return playerRepository.findByAssists(assists);
    }

    @Override
    public List<Player> findBySteals(int steals) {
        return playerRepository.findBySteals(steals);
    }

    @Override
    public List<Player> findByBlocks(int blocks) {
        return playerRepository.findByBlocks(blocks);
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
