package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.Model.Brand;

import java.time.LocalDate;
import java.util.List;

public class AdvertDaoImpl extends AbstractDao implements AdvertDao {

    private final static AdvertDaoImpl INSTANCE = new AdvertDaoImpl();

    private AdvertDaoImpl() {
    }

    public static AdvertDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Advertisement advertisement) {
        super.save(advertisement);
    }

    @Override
    public void update(Advertisement advertisement) {
        super.update(advertisement);
    }

    @Override
    public void delete(Advertisement advertisement) {
        super.delete(advertisement);
    }

    @Override
    public List<Advertisement> findAll() {
        return super.findAll("Advertisement");
    }

    @Override
    public Advertisement find(Advertisement advertisement) {
        return super.find(Advertisement.class, advertisement.getId());
    }

    @Override
    public List<Advertisement> findByBrand(Brand brand) {
        return super.findAllBy("from Advertisement a where a.car.brand =: brand", "brand", brand);
    }

    @Override
    public List<Advertisement> findLastDay() {
        return super.tx(session -> {
            return session.createQuery("from Advertisement a where a.created >= :date")
                    .setParameter("date", LocalDate.now().atStartOfDay())
                    .list();
        });
    }
}
