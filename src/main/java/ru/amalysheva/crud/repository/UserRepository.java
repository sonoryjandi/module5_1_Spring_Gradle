package ru.amalysheva.crud.repository;

import org.springframework.stereotype.Repository;
import ru.amalysheva.crud.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MyRepository<User> {
    Optional<User> findUserByLogin(String login);

}
