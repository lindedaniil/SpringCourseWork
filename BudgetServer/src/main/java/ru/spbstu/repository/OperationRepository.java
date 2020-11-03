package ru.spbstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spbstu.entity.OperationsEntity;

public interface OperationRepository extends JpaRepository<OperationsEntity, Integer> {
}