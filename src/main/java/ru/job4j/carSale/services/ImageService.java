package ru.job4j.carSale.services;

import ru.job4j.carSale.Dao.ImageDaoImpl;
import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.Model.Image;

import java.util.List;

public class ImageService {
    private static final ImageService INSTANCE = new ImageService();

    private static final ImageDaoImpl IMAGE_DAO = ImageDaoImpl.getInstance();

    private ImageService() {
    }

    public static ImageService getInstance() {
        return INSTANCE;
    }

    public void save(Image image) {
        IMAGE_DAO.save(image);
    }

    public void update(Image image) {
        IMAGE_DAO.update(image);
    }

    public void delete(Image image) {
        IMAGE_DAO.delete(image);
    }

    public List<Image> findAll() {
        return IMAGE_DAO.findAll();
    }

    public List<Image> findByAdvert(Advertisement advertisement) {
        return IMAGE_DAO.findByAdvert(advertisement);
    }

    public Image find(Image image) {
        return IMAGE_DAO.find(image);
    }
}
