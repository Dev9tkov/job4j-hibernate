package ru.job4j.carSale.services;

import ru.job4j.carSale.Dao.UserDaoImpl;
import ru.job4j.carSale.Model.User;

import java.util.List;

public class UserService {
    private static final UserService INSTANCE = new UserService();

    private static final UserDaoImpl USER_DAO = UserDaoImpl.getInstance();

    private UserService() {
    }

    public static UserService getInstance() {
        return INSTANCE;
    }

    public void save(User user) {
        USER_DAO.save(user);
    }

    public void update(User user) {
        USER_DAO.update(user);
    }

    public void delete(User user) {
        USER_DAO.delete(user);
    }

    public User find(User user) {
        return USER_DAO.find(user);
    }

    public List<User> findAll() {
        return USER_DAO.findAll();
    }

    public User findByName(String name) {
        return USER_DAO.findByName(name);
    }

    public boolean isExist(User user) {
        return USER_DAO.isExist(user);
    }
}
