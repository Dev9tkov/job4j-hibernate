package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.Model.Brand;

import java.util.List;

public interface AdvertDao {

    void save(Advertisement advertisement);

    void update(Advertisement advertisement);

    void delete(Advertisement advertisement);

    List<Advertisement> findAll();

    Advertisement find(Advertisement advertisement);

    List<Advertisement> findByBrand(Brand brand);

    List<Advertisement> findLastDay();
}
