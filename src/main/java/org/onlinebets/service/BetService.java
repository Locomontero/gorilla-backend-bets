package org.onlinebets.service;

import org.onlinebets.model.Bet;
import org.onlinebets.model.Game;
import org.onlinebets.model.User;
import org.onlinebets.repository.BetRepository;
import org.onlinebets.repository.GameRepository;
import org.onlinebets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BetService {

    @Autowired
    private BetRepository betRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    public Bet createBet(Long userId, Long gameId, Double amount, String prediction) {
        User user = userRepository.findById(userId).orElse(null);
        Game game = gameRepository.findById(gameId).orElse(null);

        if (user != null && game != null) {
            Bet bet = new Bet();
            bet.setUser(user);
            bet.setGame(game);
            bet.setAmount(amount);
            bet.setPrediction(prediction);
            bet.setIsClosed(false); // Aposta aberta, ainda não foi fechada
            return betRepository.save(bet);
        }
        return null;
    }

    public List<Bet> getBetsByUser(Long userId) {
        return betRepository.findByUserId(userId);
    }

    public Bet closeBet(Long betId, Boolean isWin) {
        Bet bet = betRepository.findById(betId).orElse(null);

        if (bet != null) {
            bet.setIsClosed(true);
            // Calcular o resultado da aposta aqui
            return betRepository.save(bet);
        }
        return null;
    }
}
