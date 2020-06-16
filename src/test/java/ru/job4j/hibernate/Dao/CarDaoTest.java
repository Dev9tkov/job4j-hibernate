package ru.job4j.hibernate.Dao;

import org.junit.Test;
import ru.job4j.hibernate.Model.Car;
import ru.job4j.hibernate.Model.Driver;
import ru.job4j.hibernate.Model.Engine;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CarDaoTest {

    private ICar iCar = CarDao.getInstance();

    @Test
    public void saveCar() {
        Car car = new Car();
        car.setEngine(new Engine("disel"));
        Set<Driver> drivers = new HashSet<>();
        drivers.add(new Driver("Max"));
        car.setDrivers(drivers);
        iCar.save(car);
        assertThat(iCar.findAll().size(), is (1));
    }

    @Test
    public void updateCar() {
        Car car = new Car();
        car.setEngine(new Engine("disel"));
        iCar.save(car);
        car.setEngine(new Engine("petrol"));
        iCar.update(car);
        assertThat(iCar.find(new Car(car.getId())).getEngine().getName(), is("petrol"));
    }

    @Test
    public void deleteCar() {
        Car car = new Car();
        car.setEngine(new Engine("disel"));
        Set<Driver> drivers = new HashSet<>();
        drivers.add(new Driver("Max"));
        car.setDrivers(drivers);
        iCar.save(car);
        iCar.delete(car);
        assertThat(iCar.findAll().size(), is (0));
    }

    @Test
    public void findCar() {
        Car car = new Car();
        car.setEngine(new Engine("disel"));
        iCar.save(car);
        Car rsl = iCar.find(new Car(car.getId()));
        assertThat(rsl.getEngine().getName(), is("disel"));
    }
}