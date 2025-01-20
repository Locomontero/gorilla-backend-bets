package org.onlinebets.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BetDTO {

    private Long userId;
    private Long gameId;
    private Double amount;
    private String prediction;

}
