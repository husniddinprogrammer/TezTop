package Husniddin.service.impl;

import Husniddin.entity.MaydonTuri;
import Husniddin.repository.MaydonTuriRepo;
import Husniddin.service.MaydonTuriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaydonTuriServiceImpl implements MaydonTuriService {
    @Autowired
    private MaydonTuriRepo maydonTuriRepo;

    @Override
    public List<MaydonTuri> getAll() throws Exception {
        return maydonTuriRepo.findAll();
    }

    @Override
    public MaydonTuri add(MaydonTuri maydonTuri) throws Exception {
        return maydonTuriRepo.save(maydonTuri);
    }

    @Override
    public void update(MaydonTuri maydonTuri) throws Exception {
        maydonTuriRepo.save(maydonTuri);
    }

    @Override
    public void delete(MaydonTuri maydonTuri) {
        deleteById(maydonTuri.getId());
    }

    @Override
    public void deleteById(Long aLong) {
        maydonTuriRepo.deleteById(aLong);
    }

    @Override
    public Optional<MaydonTuri> getById(Long aLong) throws Exception {
        return maydonTuriRepo.findById(aLong);
    }
}
