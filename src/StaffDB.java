import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StaffDB implements AddUserCSV{
    public static Map<String, StaffData> staffs = new HashMap<>();

    public void initializeUserCSV(){


        String csvFilePath = "src/staff_list.csv";

        try {
            File csvFile = new File(csvFilePath);
            Scanner scanner = new Scanner(csvFile);

            // Set the delimiter to a comma (`,`), which is common in CSV files
            scanner.useDelimiter(",");

            // Read and process the header (column names)
            String headerLine = scanner.nextLine();
            String[] headers = headerLine.split(",");
            System.out.println("CSV Headers:");
            for (String header : headers) {
                System.out.print(header + "\t");
            }
            System.out.println();
            int i = 0;
            // Read and process the data rows
            while (scanner.hasNextLine()) {
                String dataLine = scanner.nextLine();
                String[] dataParts = dataLine.split(",");

                if (dataParts.length != 3) {
                    System.err.println("Malformed data row: " + dataLine);
                    continue; // Skip to the next row
                }

                String name = dataParts[0];
                String email = dataParts[1].replaceAll(";", ""); // Remove semicolon
                String faculty = dataParts[2];

                System.out.println(name + "\t" + email + "\t" + faculty);

                StaffData staff = new StaffData(name,email,faculty);

            }

            // Close the scanner when you're done with it
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }




    }
}
