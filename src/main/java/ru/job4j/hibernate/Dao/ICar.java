package ru.job4j.hibernate.Dao;

import ru.job4j.hibernate.Model.Car;

import java.util.List;

public interface ICar {

    void save(Car car);

    void update(Car car);

    List<Car> findAll();

    void delete(Car car);

    Car find(Car car);
}
