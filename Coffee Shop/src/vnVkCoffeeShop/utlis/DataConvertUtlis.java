package vnVkCoffeeShop.utlis;

import java.io.*;
import java.util.*;

public class DataConvertUtlis {
    public static <T> void write(String path, List<T> items) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            for (T item : items) {
                printWriter.println(item.toString());
            }
            printWriter.flush();
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
    }

    public static List<String> read(String path) {
        List<String> lists = new ArrayList<>();
        File file = new File(path);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null && !line.trim().isEmpty()) {
                lists.add(line);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(path + " invalid");
        }
        return lists;
    }
}
