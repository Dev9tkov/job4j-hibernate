package ru.job4j.carSale.services;

import ru.job4j.carSale.Dao.BrandDaoImpl;
import ru.job4j.carSale.Model.Brand;

import java.util.List;

public class BrandService {
    private static final BrandService INSTANCE = new BrandService();

    private static final BrandDaoImpl BRAND_DAO = BrandDaoImpl.getInstance();

    private BrandService() {
    }

    public static BrandService getInstance() {
        return INSTANCE;
    }

    public void save(Brand brand) {
        BRAND_DAO.save(brand);
    }

    public Brand find(Brand brand) {
        return BRAND_DAO.find(brand);
    }

    public List<Brand> findAll() {
        return BRAND_DAO.findAll();
    }

    public Brand findByName(String name) {
        return BRAND_DAO.findByName(name);
    }
}
