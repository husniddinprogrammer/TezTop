package Husniddin.service.impl;

import Husniddin.entity.GameClub;
import Husniddin.repository.GameClubRepo;
import Husniddin.service.GameClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameClubServiceImpl implements GameClubService {
    @Autowired
    private GameClubRepo gameClubRepo;

    @Override
    public List<GameClub> getAll() throws Exception {
        return gameClubRepo.findAll();
    }

    @Override
    public GameClub add(GameClub gameClub) throws Exception {
        return gameClubRepo.save(gameClub);
    }

    @Override
    public void update(GameClub gameClub) throws Exception {
        gameClubRepo.save(gameClub);
    }

    @Override
    public void delete(GameClub gameClub) {
        deleteById(gameClub.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        gameClubRepo.deleteById(aLong);
    }

    @Override
    public Optional<GameClub> getById(Long aLong) throws Exception {
        return gameClubRepo.findById(aLong);
    }
}
