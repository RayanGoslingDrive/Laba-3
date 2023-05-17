package hate.worldwide;


import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
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


        String filePath = "C:\\Users\\vsh21\\IdeaProjects\\Jsom\\worldwide\\src\\main\\webapp\\csv\\obj.csv";

        List<String[]> rows = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                rows.add(values);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String json = gson.toJson(rows);
        System.out.println(json);

        PrintWriter out = response.getWriter();
        out.println(json);
    }
}