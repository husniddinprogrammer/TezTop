package Husniddin.repository;

import Husniddin.entity.TulovQilish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TulovQilishRepo  extends JpaRepository<TulovQilish,Long> {
    public List<TulovQilish> findAllByOrderByIdDesc();
    public List<TulovQilish> findAllByBuyurtmaId(Long id);
    public List<TulovQilish> findAllById(Long id);
}
