package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokov.passportservice.model.Bottom;

import java.util.List;

public interface BottomRepository extends JpaRepository<Bottom, Long> {

    List<Bottom> findAllByVolume(Integer volume);

    @Query("select b from Bottom b group by b.volume")
    List<Bottom> findAllBottoms();
}
