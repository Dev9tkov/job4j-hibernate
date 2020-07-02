package ru.job4j.carSale.Controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ru.job4j.carSale.services.AdvertService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeStatusServlet extends HttpServlet {
    private final AdvertService advertService = AdvertService.getInstance();

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
        int index = node.get("id").asInt();
        advertService.changeStatus(index);
        PrintWriter pw = resp.getWriter();
        ObjectNode resNode = mapper.createObjectNode();
        resNode.put("status", "success");
        String json = mapper.writeValueAsString(resNode);
        pw.append(json);
        pw.flush();
    }
}
