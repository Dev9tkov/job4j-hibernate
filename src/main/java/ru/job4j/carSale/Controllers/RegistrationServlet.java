package ru.job4j.carSale.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.carSale.Model.User;
import ru.job4j.carSale.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(sb.toString());
        String name = node.get("name").asText();
        String pass = node.get("password").asText();
        String city = node.get("city").asText();
        User user = new User(name, pass, city);
        if (!userService.isExist(user)) {
            userService.save(user);
            HttpSession session = req.getSession();
            session.setAttribute("user", new User());
            pw.append("success");
        } else {
            pw.append("error");
        }
        pw.flush();
    }
}
