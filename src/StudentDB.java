import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentDB implements AddUserCSV{
    public static Map<String, UserData> students = new HashMap<>();
    public void initializeUserCSV(){


        String csvFilePath = "src/student_list.csv";

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

                StudentData student = new StudentData(name,email,faculty,this);

            }

            // Close the scanner when you're done with it
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }




    }
}
