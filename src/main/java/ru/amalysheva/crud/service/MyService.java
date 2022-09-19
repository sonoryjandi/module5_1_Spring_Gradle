package ru.amalysheva.crud.service;

import ru.amalysheva.crud.entities.Persistable;

import java.util.List;

public interface MyService<T extends Persistable> { //<T extends Persistable> delete
    T create(T entity);

    void update(Integer id, String login, String password);

    void delete(Integer id);

    String getUserInfo(int id);

    List<T> getAll();
}
