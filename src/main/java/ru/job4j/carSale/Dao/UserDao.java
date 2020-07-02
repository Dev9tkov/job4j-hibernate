package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    void update(User user);

    void delete(User user);

    User find (User user);

    User findByName(String name);

    List<User> findAll();

    boolean isExist(User user);
}
