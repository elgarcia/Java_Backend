package com.elias.Repository;

import com.elias.Domain.MedicionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicionRepository extends JpaRepository<MedicionEntity, Long> {
    List<MedicionEntity> findByAnho(Short any);
}
