package Husniddin.service.impl;

import Husniddin.entity.SportZal;
import Husniddin.repository.SportZalRepository;
import Husniddin.service.SportZalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SportZalServiceImpl implements SportZalService {
    @Autowired
    private SportZalRepository sportZalRepository;

    @Override
    public List<SportZal> getAll() throws Exception {
        return sportZalRepository.findAll();
    }

    @Override
    public SportZal add(SportZal sportZal) throws Exception {
        return sportZalRepository.save(sportZal);
    }

    @Override
    public void update(SportZal sportZal) throws Exception {
        sportZalRepository.save(sportZal);
    }

    @Override
    public void delete(SportZal sportZal) {
        deleteById(sportZal.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        sportZalRepository.deleteById(aLong);
    }

    @Override
    public Optional<SportZal> getById(Long aLong) throws Exception {
        return sportZalRepository.findById(aLong);
    }
}
