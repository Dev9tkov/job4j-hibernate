package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Car;

import java.util.List;

public interface CarDao {

    void save (Car car);

    void update(Car car);

    void delete(Car car);

    List<Car> findAll();

    Car find(Car car);

}
