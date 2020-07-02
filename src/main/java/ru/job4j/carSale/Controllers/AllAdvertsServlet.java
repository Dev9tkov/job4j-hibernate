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

public class AllAdvertsServlet extends HttpServlet {

    private final AdvertService advertService = AdvertService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/mainpage.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Advertisement> ads = advertService.findAll();
        PrintWriter pw = resp.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ads);
        pw.append(json);
        pw.flush();
    }
}
