package ru.job4j.carSale.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    private Integer year;

    private Integer mileAge;

    private String bodyCar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    @JsonManagedReference
    private Engine engine;

    private String transmission;

    public Car() {
    }

    public Car(int id) {
        this.id = id;
    }

    public Car(Brand brand, Integer year, Integer mileAge, String bodyCar, Engine engine, String transmission) {
        this.brand = brand;
        this.year = year;
        this.mileAge = mileAge;
        this.bodyCar = bodyCar;
        this.engine = engine;
        this.transmission = transmission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileAge() {
        return mileAge;
    }

    public void setMileAge(Integer mileAge) {
        this.mileAge = mileAge;
    }

    public String getBodyCar() {
        return bodyCar;
    }

    public void setBodyCar(String bodyCar) {
        this.bodyCar = bodyCar;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand=" + brand +
                ", year=" + year +
                ", mileAge=" + mileAge +
                ", bodyCar=" + bodyCar +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}
