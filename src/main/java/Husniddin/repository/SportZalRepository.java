package Husniddin.repository;

import Husniddin.entity.SportZal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportZalRepository extends JpaRepository<SportZal,Long> {
}
