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
    public List<Player> sortByPoints() {
        return playerRepository.findAllByOrderByPointsDesc();
    }

    @Override
    public List<Player> sortByRebounds() {
        List<Player> players = playerRepository.findAllByOrderByReboundsDesc();
        return players;
    }

    @Override
    public List<Player> sortByAssists() {
        return playerRepository.findAllByOrderByAssistsDesc();
    }

    @Override
    public List<Player> sortBySteals() {
        return playerRepository.findAllByOrderByStealsDesc();
    }

    @Override
    public List<Player> sortByBlocks() {
        return playerRepository.findAllByOrderByBlocksDesc();
    }

    @Override
    public void save(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public List<Player> sortByPositionByPoints(String position){
        return playerRepository.findAllByPositionOrderByPointsDesc(position);
    }

    @Override
    public List<Player> sortByPositionByRebounds(String position){
        return playerRepository.findAllByPositionOrderByReboundsDesc(position);
    }

    @Override
    public List<Player> sortByPositionByAssists(String position){
        return playerRepository.findAllByPositionOrderByAssistsDesc(position);
    }

    @Override
    public List<Player> sortByPositionBySteals(String position){
        return playerRepository.findAllByPositionOrderByStealsDesc(position);
    }

    @Override
    public List<Player> sortByPositionByBlocks(String position){
        return playerRepository.findAllByPositionOrderByBlocksDesc(position);
    }

}
