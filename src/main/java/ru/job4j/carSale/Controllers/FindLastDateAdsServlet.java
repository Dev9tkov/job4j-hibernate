package ru.job4j.carSale.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.carSale.Model.Advertisement;
import ru.job4j.carSale.services.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FindLastDateAdsServlet extends HttpServlet {

    private final AdvertService advertService = AdvertService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Advertisement> ads = advertService.findLastDay();
        PrintWriter pw = resp.getWriter();
        String json = mapper.writeValueAsString(ads);
        pw.append(json);
        pw.flush();
    }
}
