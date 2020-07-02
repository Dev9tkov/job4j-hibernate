package ru.job4j.carSale.services;

import ru.job4j.carSale.Dao.AdvertDaoImpl;
import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.Model.Brand;

import java.util.List;

public class AdvertService {
    private static final AdvertService INSTANCE = new AdvertService();

    private static final AdvertDaoImpl ADVERT_DAO = AdvertDaoImpl.getInstance();

    private AdvertService() {
    }

    public static AdvertService getInstance() {
        return INSTANCE;
    }

    public void save(Advertisement advertisement) {
        ADVERT_DAO.save(advertisement);
    }

    public void update(Advertisement advertisement) {
        ADVERT_DAO.update(advertisement);
    }

    public void delete(Advertisement advertisement) {
        ADVERT_DAO.delete(advertisement);
    }

    public List<Advertisement> findAll() {
       return ADVERT_DAO.findAll();
    }

    public Advertisement find (Advertisement advertisement) {
        return ADVERT_DAO.find(advertisement);
    }

    public List<Advertisement> findByBrand(Brand brand) {
        return ADVERT_DAO.findByBrand(brand);
    }

    public void changeStatus(int id) {
        Advertisement adv = ADVERT_DAO.findAll().stream()
                .filter(val -> val.getId() == id)
                .findFirst()
                .get();
        adv.setStatus(false);
        ADVERT_DAO.update(adv);
    }

    public List<Advertisement> findLastDay() {
        return ADVERT_DAO.findLastDay();
    }
}
