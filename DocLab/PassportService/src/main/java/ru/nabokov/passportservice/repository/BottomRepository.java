package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokov.passportservice.model.Bottom;

import java.util.List;

public interface BottomRepository extends JpaRepository<Bottom, Long> {

    List<Bottom> findAllByVolumeAndTypeId(Integer volume, Long typeId);

    @Query("select b from Bottom b group by b.volume")
    List<Bottom> findAllBottoms();
}
