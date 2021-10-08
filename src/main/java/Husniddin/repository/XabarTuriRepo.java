package Husniddin.repository;

import Husniddin.entity.XabarTuri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XabarTuriRepo extends JpaRepository<XabarTuri,Long> {
    public List<XabarTuri> findAllByOrderById();
}
