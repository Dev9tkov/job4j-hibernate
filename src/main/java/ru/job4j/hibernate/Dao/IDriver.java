package ru.job4j.hibernate.Dao;

import ru.job4j.hibernate.Model.Driver;

import java.util.List;

public interface IDriver {

    void save(Driver driver);

    void update(Driver driver);

    List<Driver> findAll();

    void delete(Driver driver);

    Driver find(Driver driver);
}
