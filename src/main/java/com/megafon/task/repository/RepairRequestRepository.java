package com.megafon.task.repository;

import com.megafon.task.domain.RepairRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RepairRequestRepository extends JpaRepository<RepairRequest, Long> {
    Optional<RepairRequest> findByIdAndDeletedFalse(Long id);

    List<RepairRequest> findAllByDeletedFalse();

    @Query("update RepairRequest set deleted = true where id = :id")
    @Modifying
    void delete(@Param("id") Long id);
}
