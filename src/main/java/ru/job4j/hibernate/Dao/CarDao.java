package ru.job4j.hibernate.Dao;

import ru.job4j.hibernate.Model.Car;

import java.util.List;

public class CarDao extends AbstractDao implements ICar {

    private final static ICar INSTANCE = new CarDao();

    private CarDao() {
    }

    public static ICar getInstance() {
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
    public Car find(Car car) {
        return super.find(Car.class, car.getId());
    }

    @Override
    public List<Car> findAll() {
        return super.findAll("Car");
    }

    @Override
    public void delete(Car car) {
        super.delete(car);
    }
}
