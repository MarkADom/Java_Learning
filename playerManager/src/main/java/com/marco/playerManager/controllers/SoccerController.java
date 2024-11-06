package com.marco.playerManager.controllers;

import com.marco.playerManager.dtos.CreatePlayerDto;
import com.marco.playerManager.dtos.CreateTeamDto;
import com.marco.playerManager.models.Player;
import com.marco.playerManager.models.Team;
import com.marco.playerManager.models.enums.PlayerPosition;
import com.marco.playerManager.repositories.PlayerRepository;
import com.marco.playerManager.repositories.TeamRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoccerController {

    TeamRepository teamRepository;
    PlayerRepository playerRepository;

    public SoccerController(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@RequestBody CreateTeamDto createTeamDto) {
        Team teamCreated = teamRepository.save(createTeamDto.toTeam());

        return new ResponseEntity<>(teamCreated, HttpStatus.CREATED);
    }

    @PostMapping("/players")
    public ResponseEntity<Player> createPlayer(@RequestBody CreatePlayerDto createPlayerDto) {
        Player playerCreated = playerRepository.save(createPlayerDto.toPlayer());

        return new ResponseEntity<>(playerCreated, HttpStatus.CREATED);
    }

    //Update a team
    @PutMapping("teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable String id, @RequestBody CreateTeamDto createTeamDto) {
        Optional<Team> optionalTeam = teamRepository.findById(id);

        if (optionalTeam.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        Team teamToUpdate = optionalTeam.get()
                .setAddress(createTeamDto.getAddress())
                .setName(createTeamDto.getName())
                .setAcronym(createTeamDto.getAcronym());

        Team teamUpdated = teamRepository.save(teamToUpdate);

        return new ResponseEntity<>(teamUpdated,HttpStatus.OK);
    }

    //Delete a team
    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable String id, @RequestBody CreateTeamDto createTeamDto ) {
        teamRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Create players
    @PostMapping("/players/bulk")
    public ResponseEntity<List<Player>> createPlayers(@RequestBody List<CreatePlayerDto> createPlayerDtoList) {
        List<Player> players = createPlayerDtoList
                .stream()
                .map(CreatePlayerDto::toPlayer)
                .collect(Collectors.toList());

        List<Player> playerCreated = playerRepository.saveAll(players);

        return new ResponseEntity<>(playerCreated, HttpStatus.CREATED);
    }

    //Add players to a team
    @PostMapping("/teams/{id}/players")
    public ResponseEntity<Team> addPlayersToTeam(@PathVariable String id, @RequestBody List<String> playerIds) {
        Optional<Team> optionalTeam = teamRepository.findById(id);

        if (optionalTeam.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        Team teamToUpdate = optionalTeam.get();

        Set<Player> playersToAdd = playerIds.stream()
                .map(playerId -> playerRepository.findById(playerId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        teamToUpdate.setPlayers(playersToAdd);

        Team teamUpdated = teamRepository.save(teamToUpdate);

        return new ResponseEntity<>(teamUpdated, HttpStatus.OK);
    }


    //Retrieving all the documents of a collection with findAll()
    @GetMapping("/teams")
    public ResponseEntity<List<Team>> allTeams() {
        // Sort teams by name in descending order
        List<Team> teams = teamRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> allPlayers() {
        // Sort player by position in ascending order and name in descending order
        List<Sort.Order> orders = new ArrayList<>(){{
            add(Sort.Order.by("position").with(Sort.Direction.ASC));
            add(Sort.Order.by("name").with(Sort.Direction.DESC));
        }};

        List<Player> players = playerRepository.findAll(Sort.by(orders));

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> oneTeam(@PathVariable String id) {
        Optional<Team> teamOptional = teamRepository.findById(id);

        return teamOptional
                .map(team -> new ResponseEntity<>(team, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<Player> onePlayer(@PathVariable String id) {
        Optional<Player> playerOptional = playerRepository.findById(id);

        return playerOptional
                .map(player -> new ResponseEntity<>(player, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/players-example1")
    public ResponseEntity<List<Player>> listPlayersExample() {
        List<Player> players = playerRepository.findByPositionAndIsAvailable(PlayerPosition.STRIKER, true);

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/teams-example2")
    public ResponseEntity<List<Team>> listTeamsExample2() {
        List<Team> teams = teamRepository.findByNameContainingIgnoreCaseOrderByNameDesc("as");

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/players-example3")
    public ResponseEntity<List<Player>> listPlayersExample3() {
        List<PlayerPosition> playerPositions = new ArrayList<>() {{
            add(PlayerPosition.DEFENSIVE_MIDFIELDER);
            add(PlayerPosition.GOALKEEPER);
        }};

        List<Player> players = playerRepository.findDistinctNameByPositionIn(playerPositions);

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/players-example4")
    public ResponseEntity<List<Player>> listPlayersExample4() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(1991, Calendar.JANUARY, 1);
        Date fromDate = calendar.getTime();

        calendar.set(1996, Calendar.JANUARY, 1);
        Date toDate = calendar.getTime();

        List<Player> players = playerRepository.findByBirthDateIsBetweenOrderByBirthDate(fromDate, toDate);

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/players-example5")
    public ResponseEntity<Player> listPlayersExample5() {
        Player player = playerRepository.findFirstByOrderByBirthDateDesc();

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping("/players-example6")
    public ResponseEntity<List<Player>> listPlayersExample6() {
        List<Player> players = playerRepository.findFirst10ByOrderByBirthDate();

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @GetMapping("/teams-example7/{city}")
    public ResponseEntity<List<Team>> listTeamsExample7(@PathVariable String city) {
        List<Team> teams = teamRepository.findByAddressCityIgnoreCase(city);

        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/players-page")
    public ResponseEntity<Page<Player>> listPlayersPage(@RequestParam int page) {
        Page<Player> players = playerRepository.findByIdIsNotNull(PageRequest.of(page - 1, 10));

        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}












