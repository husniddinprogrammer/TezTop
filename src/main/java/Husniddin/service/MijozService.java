package Husniddin.service;


import Husniddin.entity.Mijoz;

import java.time.LocalDate;
import java.util.List;

public interface MijozService extends PublicService<Mijoz,Long> {
    public Mijoz getBekorQilish(Long id);
    public List<Mijoz> getAllByQushilganVaqtBetweenOrderByIdDesc(LocalDate sana1);
    public List<Mijoz> getAllByQushilganVaqtBetweenOrderByIdDescWeek(LocalDate sana1);
}
