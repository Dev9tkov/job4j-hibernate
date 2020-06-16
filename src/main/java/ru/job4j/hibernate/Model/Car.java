package ru.job4j.hibernate.Model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "History_Owner",
            joinColumns = { @JoinColumn(name = "cars_id", updatable = false)},
            inverseJoinColumns = { @JoinColumn(name = "drivers_id", updatable = false)}
    )
    private Set<Driver> drivers;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public Car(int id) {
        this.id = id;
    }

    public Car(String name, Engine engine, Set<Driver> drivers) {
        this.name = name;
        this.engine = engine;
        this.drivers = drivers;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
