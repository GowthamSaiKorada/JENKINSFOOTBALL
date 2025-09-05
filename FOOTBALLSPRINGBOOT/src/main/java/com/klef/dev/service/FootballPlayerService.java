package com.klef.dev.service;

import java.util.List;
import com.klef.dev.entity.FootballPlayer;

public interface FootballPlayerService {
    FootballPlayer addPlayer(FootballPlayer player);
    List<FootballPlayer> getAllPlayers();
    FootballPlayer getPlayerById(int id);
    FootballPlayer updatePlayer(FootballPlayer player);
    void deletePlayerById(int id);
}
