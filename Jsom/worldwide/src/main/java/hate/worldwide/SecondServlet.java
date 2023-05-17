package hate.worldwide;


import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Model.Model;
import POJO.POJO;

public class SecondServlet extends HttpServlet {
    Model dataModel = new Model();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/write.html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filePath = "C:\\Users\\vsh21\\IdeaProjects\\Jsom\\worldwide\\src\\main\\webapp\\csv\\obj.csv";
        String data = request.getParameter("data");
        System.out.println(data);
        Gson gson = new Gson();
        POJO gfg = gson.fromJson(data, POJO.class);
        System.out.println(gfg.Bandname);
        String[] row = {gfg.Bandname, gfg.hometown, gfg.genre, gfg.last_ablbum, gfg.Singer};
        dataModel.addData(row);
        dataModel.writeToCSV(filePath);
    }
}