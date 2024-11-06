package com.marco.playerManager.bootstrap;

import com.github.javafaker.Faker;
import com.marco.playerManager.models.Address;
import com.marco.playerManager.models.Player;
import com.marco.playerManager.models.Team;
import com.marco.playerManager.models.enums.PlayerPosition;
import com.marco.playerManager.repositories.PlayerRepository;
import com.marco.playerManager.repositories.TeamRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class DataBaseSeeder implements ApplicationListener<ContextRefreshedEvent> {

    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final Faker faker;

    public DataBaseSeeder(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.faker = new Faker(Locale.UK);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       /* teamRepository.deleteAll();
        playerRepository.deleteAll();

        Set<String> teamNames = new HashSet<>();
        int counter = 0;

        while(counter<10){
            String teamName = faker.team().name();

            if (!teamName.contains(teamName)) {
                teamNames.add(teamName);
                counter++;
            }
        }

        for (String teamName: teamNames) {
            createAndPersistTeam(teamName);
        }*/
    }

    private void createAndPersistTeam(String teamName) {
        List<Player> players = new ArrayList<>() {{
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
            add(createPlayer());
        }};

        List<Player> createdPlayers = playerRepository.saveAll(players);

        Address address = new Address(
                faker.address().city(),
                faker.address().zipCode(),
                faker.address().streetAddress()
        );

        Team team = new Team()
                .setName(teamName)
                .setAcronym(teamName.replaceAll(" ","").toUpperCase().substring(0,4))
                .setAddress(address)
                .setPlayers(new HashSet<>(createdPlayers));
    }

    private Player createPlayer() {
        PlayerPosition[] positions = PlayerPosition.toArray();

        return new Player()
                .setName(faker.name().firstName() + " " + faker.name().lastName())
                .setBirthDate(faker.date().birthday(18,38))
                .setPosition(positions[faker.random().nextInt(0, positions.length - 1)])
                .setAvailable(faker.random().nextBoolean());
    }



}
























