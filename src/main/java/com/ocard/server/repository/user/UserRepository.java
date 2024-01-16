package com.ocard.server.repository.user;

import com.ocard.server.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
