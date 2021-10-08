package Husniddin.repository;

import Husniddin.entity.Poliya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoliyaRepo extends JpaRepository<Poliya,Long> {
    public List<Poliya> findAllByOrderById();
    public List<Poliya> findAllByBoshliqId(Long id);
}
