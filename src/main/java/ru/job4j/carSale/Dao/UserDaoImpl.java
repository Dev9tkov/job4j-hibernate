package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.User;

import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDao {

    private final static UserDaoImpl INSTANCE = new UserDaoImpl();

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(User user) {
        super.save(user);
    }

    @Override
    public void update(User user) {
        super.update(user);
    }

    @Override
    public void delete(User user) {
        super.delete(user);
    }

    @Override
    public User find(User user) {
        return super.find(User.class, user.getId());
    }

    @Override
    public User findByName(String name) {
        List<User> users = super.findAllBy("from User u where u.name =: name", "name", name);
        return users.stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return super.findAll("User");
    }

    @Override
    public boolean isExist(User user) {
        return findByName(user.getName()) != null;
    }
}
