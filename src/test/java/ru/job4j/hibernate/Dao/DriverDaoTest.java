package ru.job4j.hibernate.Dao;

import org.junit.Test;
import ru.job4j.hibernate.Model.Car;
import ru.job4j.hibernate.Model.Driver;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DriverDaoTest {

    private IDriver iDriver = DriverDao.getInstance();

    @Test
    public void saveDriver() {
        Driver driver = new Driver();
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("toyota"));
        cars.add(new Car("Lada"));
        driver.setCars(cars);
        iDriver.save(driver);
        assertThat(iDriver.findAll().size(), is (1));
    }

    @Test
    public void updateDriver() {
        Driver driver = new Driver();
        driver.setName("Mike");
        iDriver.save(driver);
        driver.setName("Misha");
        iDriver.update(driver);
        assertThat(iDriver.find(new Driver(driver.getId())).getName(), is("Misha"));
    }

    @Test
    public void deleteDriver() {
        Driver driver = new Driver();
        Set<Car> cars = new HashSet<>();
        cars.add(new Car("toyota"));
        cars.add(new Car("Lada"));
        driver.setCars(cars);
        iDriver.save(driver);
        iDriver.delete(driver);
        assertThat(iDriver.findAll().size(), is (0));
    }

    @Test
    public void findDriver() {
        Driver driver = new Driver();
        driver.setName("Mike");
        iDriver.save(driver);
        Driver rsl = iDriver.find(new Driver(driver.getId()));
        assertThat(rsl.getName(), is("Mike"));
    }
}