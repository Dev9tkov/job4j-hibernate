package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Brand;

import java.util.List;

public interface BrandDao {

    void save(Brand brand);

    Brand find (Brand brand);

    List<Brand> findAll();

    Brand findByName(String name);
}
