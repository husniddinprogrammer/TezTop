package Husniddin.service;

import Husniddin.entity.Poliya;

import java.util.List;

public interface PoliyaService extends PublicService<Poliya,Long> {
    public Poliya getBekorQilish(Long id);
    public List<Poliya> getAllPeople() throws Exception;
}
