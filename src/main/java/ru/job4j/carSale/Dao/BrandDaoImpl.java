package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Brand;

import java.util.List;

public class BrandDaoImpl extends AbstractDao implements BrandDao {

    private final static BrandDaoImpl INSTANCE = new BrandDaoImpl();

    private BrandDaoImpl() {
    }

    public static BrandDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Brand brand) {
        super.save(brand);
    }

    @Override
    public Brand find(Brand brand) {
        return super.find(Brand.class, brand.getId());
    }

    @Override
    public List<Brand> findAll() {
        return super.findAll("Brand");
    }

    @Override
    public Brand findByName(String name) {
        return (Brand) super.findAllBy("from Brand b where b.name =: name", "name", name)
                .stream()
                .findFirst()
                .orElse(null);
    }
}
