package ru.nabokov.passportservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nabokov.passportservice.model.PipelineNorm;

import java.util.List;

public interface PipelineNormRepository extends JpaRepository<PipelineNorm, Long> {

    List<PipelineNorm> findAllByTypeId(Long typeId);
}
