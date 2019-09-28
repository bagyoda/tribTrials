package com.tribesproject.mytribes.kingdom;

import com.tribesproject.mytribes.kingdom.Kingdom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KingdomRepository extends CrudRepository<Kingdom,Long> {
  Kingdom save(Kingdom kingdom);
}
