package com.marco.playerManager.repositories;

import com.marco.playerManager.models.Player;
import com.marco.playerManager.models.enums.PlayerPosition;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    List<Player> findByPositionAndIsAvailable(PlayerPosition playerPosition, boolean isAvailable);

    List<Player> findDistinctNameByPositionIn(List<PlayerPosition> playerPositions);

    List<Player> findByBirthDateIsBetweenOrderByBirthDate(Date fromDate, Date toDate);

    Player findFirstByOrderByBirthDateDesc();

    List<Player> findFirst10ByOrderByBirthDate();

    Page<Player> findByIdIsNotNull(Pageable pageable);
}
