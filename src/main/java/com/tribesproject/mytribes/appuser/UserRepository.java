package com.tribesproject.mytribes.appuser;

import com.tribesproject.mytribes.appuser.TribeUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<TribeUser, Long> {

  TribeUser findUserByUsername(String username);
}
