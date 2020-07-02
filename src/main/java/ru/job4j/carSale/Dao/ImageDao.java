package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.Model.Image;

import java.util.List;

public interface ImageDao {
    void save(Image image);

    void update(Image image);

    void delete(Image image);

    Image find(Image image);

    List<Image> findAll();

    List<Image> findByAdvert(Advertisement advertisement);
}
