package ru.job4j.carSale.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ru.job4j.carSale.Dao.UserDaoImpl;
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

public class AuthServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
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
        User user = userService.findByName(name);
        ObjectNode resNode = mapper.createObjectNode();
        if (null != user && pass.equals(user.getPassword())) {
            session.removeAttribute("user");
            session.setAttribute("user", user);
            String userName = user.getName();
            resNode.put("name", userName);
            String json = mapper.writeValueAsString(resNode);
            pw.append(json);
        } else {
            session.setAttribute("user", new User());
            pw.append("error");
        }
        pw.flush();
    }
}
