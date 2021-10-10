package Husniddin.repository;

import Husniddin.entity.MaydonTuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaydonTuriRepo extends JpaRepository<MaydonTuri,Long> {
}
