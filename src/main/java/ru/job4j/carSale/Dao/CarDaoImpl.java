package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Car;

import java.util.List;

public class CarDaoImpl extends AbstractDao implements CarDao {

    private final static CarDaoImpl INSTANCE = new CarDaoImpl();

    private CarDaoImpl() {
    }

    public static CarDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Car car) {
        super.save(car);
    }

    @Override
    public void update(Car car) {
        super.update(car);
    }

    @Override
    public void delete(Car car) {
        super.delete(car);
    }

    @Override
    public List<Car> findAll() {
        return super.findAll("Car");
    }

    @Override
    public Car find(Car car) {
        return super.find(Car.class, car.getId());
    }
}
