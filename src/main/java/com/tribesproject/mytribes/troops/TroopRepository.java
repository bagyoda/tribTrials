package com.tribesproject.mytribes.troops;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TroopRepository extends CrudRepository<Troop,Long> {
}
