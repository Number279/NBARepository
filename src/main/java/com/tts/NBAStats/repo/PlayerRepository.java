package com.tts.NBAStats.repo;

import com.tts.NBAStats.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findAll();
    Optional<Player> findById(Long id);
    List<Player> findByFirstName(String firstName);
    List<Player> findByLastName(String lastName);
    List<Player> findAllByOrderByPointsDesc();
    List<Player> findAllByOrderByAssistsDesc();
    List<Player> findAllByOrderByStealsDesc();
    List<Player> findAllByOrderByBlocksDesc();
    List<Player> findAllByOrderByReboundsDesc();
    List<Player> findAllByPositionOrderByPointsDesc(String position);
    List<Player> findAllByPositionOrderByReboundsDesc(String position);
    List<Player> findAllByPositionOrderByAssistsDesc(String position);
    List<Player> findAllByPositionOrderByStealsDesc(String position);
    List<Player> findAllByPositionOrderByBlocksDesc(String position);

//    @Query("SELECT DISTINCT p.name FROM Player p")
//    List<String> findDistinctNames();
//
//    @Query("SELECT DISTINCT p.points FROM Player p")
//    List<Integer> findByDistinctPoints();
//
//    @Query("SELECT DISTINCT p.assists FROM Player p")
//    List<Integer> findByDistinctAssists();
//
//    @Query("SELECT DISTINCT p.rebounds FROM Player p")
//    List<Integer> findByDistinctRebounds();
//
//    @Query("SELECT DISTINCT p.steals FROM Player p")
//    List<Integer> findByDistinctSteals();
//
//    @Query("SELECT DISTINCT p.blocks FROM Player p")
//    List<Integer> findByDistinctBlocks();

}
