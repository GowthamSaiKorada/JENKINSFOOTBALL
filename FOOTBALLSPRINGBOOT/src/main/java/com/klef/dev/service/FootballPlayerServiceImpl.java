package com.klef.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.dev.entity.FootballPlayer;
import com.klef.dev.repository.FootballPlayerRepository;

@Service
public class FootballPlayerServiceImpl implements FootballPlayerService {

    @Autowired
    private FootballPlayerRepository repository;

    @Override
    public FootballPlayer addPlayer(FootballPlayer player) {
        return repository.save(player);
    }

    @Override
    public List<FootballPlayer> getAllPlayers() {
        return repository.findAll();
    }

    @Override
    public FootballPlayer getPlayerById(int id) {
        Optional<FootballPlayer> opt = repository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public FootballPlayer updatePlayer(FootballPlayer player) {
        return repository.save(player);
    }

    @Override
    public void deletePlayerById(int id) {
        repository.deleteById(id);
    }
}
