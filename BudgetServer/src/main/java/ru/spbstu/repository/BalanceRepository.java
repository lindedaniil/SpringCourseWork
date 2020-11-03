package ru.spbstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spbstu.entity.BalanceEntity;

public interface BalanceRepository extends JpaRepository<BalanceEntity, Integer> {
}
