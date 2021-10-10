package Husniddin.repository;

import Husniddin.entity.PlayStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayStationRepository  extends JpaRepository<PlayStation,Long> {
}
