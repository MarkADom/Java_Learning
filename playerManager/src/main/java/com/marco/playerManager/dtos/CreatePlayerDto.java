package com.marco.playerManager.dtos;

import com.marco.playerManager.models.Player;
import com.marco.playerManager.models.enums.PlayerPosition;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreatePlayerDto {
    private String name;
    private Date birthDate;
    private PlayerPosition position;
    private boolean isAvaible;

    public Player toPlayer() {
        return new Player()
                .setName(name)
                .setBirthDate(birthDate)
                .setPosition(position)
                .setAvailable(isAvaible);
    }
}
