package ru.job4j.hibernate.Dao;

import ru.job4j.hibernate.Model.Driver;

import java.util.List;

public class DriverDao extends AbstractDao implements IDriver{

    private final static IDriver INSTANCE = new DriverDao();

    private DriverDao() {
    }

    public static IDriver getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Driver driver) {
        super.save(driver);
    }

    @Override
    public void update(Driver driver) {
        super.update(driver);
    }

    @Override
    public List<Driver> findAll() {
        return super.findAll("Driver");
    }

    @Override
    public void delete(Driver driver) {
        super.delete(driver);
    }

    @Override
    public Driver find(Driver driver) {
        return super.find(Driver.class, driver.getId());
    }
}
