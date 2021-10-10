package Husniddin.repository;

import Husniddin.entity.GameClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameClubRepo extends JpaRepository<GameClub,Long> {
}
