package ru.job4j.carSale.Dao;

import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.Model.Image;

import java.util.List;

public class ImageDaoImpl extends AbstractDao implements ImageDao {

    private final static ImageDaoImpl INSTANCE = new ImageDaoImpl();

    private ImageDaoImpl() {
    }

    public static ImageDaoImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Image image) {
        super.save(image);
    }

    @Override
    public void update(Image image) {
        super.update(image);
    }

    @Override
    public void delete(Image image) {
        super.delete(image);
    }

    @Override
    public Image find(Image image) {
        return super.find(Image.class, image.getId());
    }

    @Override
    public List<Image> findAll() {
        return super.findAll("Image");
    }

    @Override
    public List<Image> findByAdvert(Advertisement advertisement) {
        return super.findAllBy("from Image i where i.advertisement =: advertisement", "advertisement", advertisement);
    }
}
