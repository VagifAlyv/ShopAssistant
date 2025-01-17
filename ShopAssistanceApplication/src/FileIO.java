import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
    public static String readFileToString(String filePath) throws IOException {
        String content = ""; 
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
        }
        return content;
    }
}
