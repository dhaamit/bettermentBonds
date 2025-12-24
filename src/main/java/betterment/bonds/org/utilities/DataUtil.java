package betterment.bonds.org.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<String[]>  readTestData (final String filePath){
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split("="));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}