package hate.worldwide;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FileWriter {
    private static String pathStr = "C:\\Users\\vsh21\\IdeaProjects\\Jsom\\worldwide\\src\\main\\webapp\\csv\\obj.csv";
    private static Path path = Paths.get(pathStr);
    public static ArrayList<Band> readFromFile() throws IOException {
        if(Files.exists(path)) {
            BufferedReader reader = new BufferedReader(new FileReader(pathStr));
            String data = reader.readLine();
            ArrayList<Band> bands = new ArrayList<>();
            while(data != null) {
                String[] parameters = data.split(",");
                Band temp = new Band(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4]);
                bands.add(temp);
                data = reader.readLine();
            }
            reader.close();
            return bands;
        }
        return null;
    }
}
