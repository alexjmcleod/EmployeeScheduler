package utilities.JSONExport;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class JSONExport {

    String jsonString;

    public JSONExport(String jsonString) {
        
        this.jsonString = jsonString;

        start_ms();
        write_fifo();
        read_fifo();
    }

    // Start subprocess
    public void start_ms() {

        // Build process
        // Set command
        // Set WD
        ProcessBuilder pb = new ProcessBuilder("python", "json_writer.py", "./output.json");
        pb.directory(new File("./utilities/JSONExport"));
        try {
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Open FIFO and write JSON string
    public void write_fifo() {
        try {
            PrintWriter writer = new PrintWriter("./utilities/JSONExport/json-writer-request");
            writer.println(jsonString);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Open FIFO and read response
    public void read_fifo() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Scanner in = new Scanner(new File("./utilities/JSONExport/json-writer-response"));
            String input = in.nextLine();
            System.out.println(input);
            if (input.equals("./output.json")) {
                System.out.print("Message received from microservice: ");
                System.out.println("Export successful to ./output.json");
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
