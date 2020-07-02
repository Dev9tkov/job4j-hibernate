package ru.job4j.carSale.services;

import ru.job4j.carSale.Model.Brand;

public class HiberMain {

    public static void main(String[] args) {
        AdvertService advertService = AdvertService.getInstance();
        BrandService brandService = BrandService.getInstance();
        for (Brand val : brandService.findAll()) {
            System.out.println(val);
        }

        Brand br = brandService.findByName("Lada");
        System.out.println(br);
    }
}
