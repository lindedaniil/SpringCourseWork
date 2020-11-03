package ru.spbstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.spbstu.entity.ArticlesEntity;

public interface ArticleRepository extends JpaRepository<ArticlesEntity, Integer> {
}