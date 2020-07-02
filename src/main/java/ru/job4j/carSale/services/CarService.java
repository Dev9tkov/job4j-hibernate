package ru.job4j.carSale.services;

import ru.job4j.carSale.Dao.CarDaoImpl;
import ru.job4j.carSale.Model.Car;

import java.util.List;

public class CarService {
    private static final CarService INSTANCE = new CarService();

    private static final CarDaoImpl CAR_DAO = CarDaoImpl.getInstance();

    private CarService() {
    }

    public static CarService getInstance() {
        return INSTANCE;
    }

    public void save (Car car) {
        CAR_DAO.save(car);
    }

    public void update(Car car) {
        CAR_DAO.update(car);
    }

    public void delete(Car car) {
        CAR_DAO.delete(car);
    }

    public List<Car> findAll() {
        return CAR_DAO.findAll();
    }

    public Car find(Car car) {
        return CAR_DAO.find(car);
    }
}
