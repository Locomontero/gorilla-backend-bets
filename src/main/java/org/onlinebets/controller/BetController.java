package org.onlinebets.controller;

import org.onlinebets.model.Bet;
import org.onlinebets.service.BetService;
import org.onlinebets.dto.BetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bets")
public class BetController {

    @Autowired
    private BetService betService;

    @PostMapping
    public Bet createBet(@RequestBody BetDTO betDTO) {
        return betService.createBet(betDTO.getUserId(), betDTO.getGameId(), betDTO.getAmount(), betDTO.getPrediction());
    }

    @GetMapping("/{userId}")
    public List<Bet> getUserBets(@PathVariable Long userId) {
        return betService.getBetsByUser(userId);
    }

    @PutMapping("/{betId}")
    public Bet closeBet(@PathVariable Long betId, @RequestParam Boolean isWin) {
        return betService.closeBet(betId, isWin);
    }
}
