package hate.worldwide;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;




import jakarta.servlet.ServletContext;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        sc.getRequestDispatcher("/text.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pathStr = "C:\\Users\\vsh21\\IdeaProjects\\Jsom\\worldwide\\src\\main\\webapp\\csv\\obj.csv";

        Path path = Paths.get(pathStr);
        response.setContentType("application/json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String datArrayString = "1";
        if (Files.exists(path)) {
            datArrayString = Files.readString(path);
        }
        PrintWriter out = response.getWriter(); //
        String jsonArrayString = "";
        if (datArrayString != "") {
            ArrayList<Band> series = FileWriter.readFromFile();
            jsonArrayString = gson.toJson(series);
        }
        out.print(jsonArrayString);
        out.close();


    }
}