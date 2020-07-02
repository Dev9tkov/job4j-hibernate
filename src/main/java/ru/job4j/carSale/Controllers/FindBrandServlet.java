package ru.job4j.carSale.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.Model.Brand;
import ru.job4j.carSale.services.AdvertService;
import ru.job4j.carSale.services.BrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindBrandServlet extends HttpServlet {
    private final AdvertService advertService = AdvertService.getInstance();
    private final BrandService brandService = BrandService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(sb.toString());
        String brandName = node.get("brand").asText();
        Brand brand = brandService.findByName(brandName);
        List<Advertisement> ads = advertService.findByBrand(brand);
        PrintWriter pw = resp.getWriter();
        String json = mapper.writeValueAsString(ads);
        pw.append(json);
        pw.flush();
    }
}
