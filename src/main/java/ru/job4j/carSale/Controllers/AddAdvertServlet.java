package ru.job4j.carSale.Controllers;

import ru.job4j.carSale.Model.*;
import ru.job4j.carSale.services.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@MultipartConfig
public class AddAdvertServlet extends HttpServlet {
    private final AdvertService advertService = AdvertService.getInstance();
    private final BrandService brandService = BrandService.getInstance();
    private final CarService carService = CarService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        String brandCar = req.getParameter("brand");
        Brand brand = new Brand(brandCar);
        brandService.save(brand);

        Integer year = Integer.valueOf(req.getParameter("year"));
        Integer mileAge = Integer.valueOf(req.getParameter("km"));
        String bodyCar = req.getParameter("carBody");

        String engineType = req.getParameter("engineType");
        Integer power = Integer.valueOf(req.getParameter("power"));
        Engine engine = new Engine(power, engineType);

        String transmission = req.getParameter("transmission");
        Car car = new Car(brand, year, mileAge, bodyCar, engine, transmission);
        carService.save(car);

        Integer price = Integer.valueOf(req.getParameter("price"));
        Advertisement adv = new Advertisement(car, user, price);

        Image image = new Image();
        String applicationPath = req.getServletContext().getRealPath("/images");

        File uploadFolder = new File(applicationPath);
        if (!uploadFolder.exists()) {
            uploadFolder.mkdirs();
        }
        for (Part part : req.getParts()) {
           if ("image".equals(part.getName())) {
               System.out.println(part.getSubmittedFileName());
               String fileName = part.getSubmittedFileName();
               part.write(uploadFolder + File.separator + fileName);
               image.setName(fileName);
               System.out.println(uploadFolder.getAbsolutePath());
           }
        }
        adv.setImage(image);
        advertService.save(adv);
    }
}
