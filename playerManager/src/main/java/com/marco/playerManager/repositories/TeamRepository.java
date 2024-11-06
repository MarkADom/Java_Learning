package com.marco.playerManager.repositories;

import com.marco.playerManager.models.Team;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
    List<Team> findByNameOrderByNameDesc();

    List<Team> findByIdIsNotNullOrderByNameDesc();

    List<Team> findByNameContainingIgnoreCaseOrderByNameDesc(String nameKeyword);

    List<Team> findByAddressCityIgnoreCase(String city);

}
