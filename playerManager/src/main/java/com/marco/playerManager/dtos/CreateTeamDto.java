package com.marco.playerManager.dtos;


import com.marco.playerManager.models.Address;
import com.marco.playerManager.models.Team;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateTeamDto {

    private String name;
    private String acronym;
    private Address address;

    public Team toTeam() {
        return new Team()
                .setName(name)
                .setAcronym(acronym)
                .setAddress(address);
    }

}
