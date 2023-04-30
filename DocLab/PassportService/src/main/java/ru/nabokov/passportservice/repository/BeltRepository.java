package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nabokov.passportservice.model.Belt;
import java.util.List;

public interface BeltRepository extends JpaRepository<Belt, Long> {

    List<Belt> findAllByVolumeAndTypeId(Integer volume, Long typeId);

    @Query("select b from Belt b group by b.volume")
    List<Belt> findAllBottoms();
}
