package ru.amalysheva.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.amalysheva.crud.entities.User;
import ru.amalysheva.crud.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements MyService<User> {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public String getUserInfo(int id) {
        return userRepository.findById(id).toString();
    }

    @Override
    public void update(Integer id, String login, String password) {
        User userForChange = userRepository.getReferenceById(id);
        userForChange.setLogin(login);
        userForChange.setPassword(password);
        userRepository.save(userForChange);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
