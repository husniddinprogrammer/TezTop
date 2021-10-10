package Husniddin.service.impl;

import Husniddin.entity.PlayStation;
import Husniddin.repository.PlayStationRepository;
import Husniddin.service.PlayStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PlayStationServiceImpl implements PlayStationService {
    @Autowired
    private PlayStationRepository xabarTuriRepository;

    @Override
    public List<PlayStation> getAll() throws Exception {
        return xabarTuriRepository.findAll();
    }

    @Override
    public PlayStation add(PlayStation xabarTuri) throws Exception {
        return xabarTuriRepository.save(xabarTuri);
    }

    @Override
    public void update(PlayStation xabarTuri) throws Exception {
        xabarTuriRepository.save(xabarTuri);
    }

    @Override
    public void delete(PlayStation xabarTuri) {
        deleteById(xabarTuri.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        xabarTuriRepository.deleteById(aLong);
    }

    @Override
    public Optional<PlayStation> getById(Long aLong) throws Exception {
        return xabarTuriRepository.findById(aLong);
    }
}
