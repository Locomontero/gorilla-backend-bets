package org.onlinebets.repository;

import org.onlinebets.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findByUserId(Long userId);
}
