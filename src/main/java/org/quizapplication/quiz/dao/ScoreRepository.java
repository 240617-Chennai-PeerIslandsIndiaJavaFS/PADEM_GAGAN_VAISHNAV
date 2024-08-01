package org.quizapplication.quiz.dao;

import org.quizapplication.quiz.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Integer> {
    Optional<Score> findByUserid(int userId);
    List<Score> findTop3ByOrderByScoreDesc();
}
