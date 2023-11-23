import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CampsCSV {
    
    public static Map<String, CampInfo> camps = new HashMap<>();

    public static void initializeCampCSV() {
        String csvFilePath = "src/Camps.csv";

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

            // Read and process the data rows
            while (scanner.hasNextLine()) {
                String dataLine = scanner.nextLine();
                String[] dataParts = dataLine.split(",");

                if (dataParts.length != 9) {
                    System.err.println("Malformed data row: " + dataLine + dataParts.length);
                    continue; // Skip to the next row
                }
                

                String campName = dataParts[0];
                int campDate = Integer.parseInt(dataParts[1]);
                int regisCloseDate = Integer.parseInt(dataParts[2]);
                String location = dataParts[3];
                int totalSlots = Integer.parseInt(dataParts[4]);
                String campDescription = dataParts[5];
                StaffData staffInCharge = StaffDB.staffs.get(dataParts[6]); // Assuming StaffData constructor takes a String parameter
                boolean visibility = Boolean.parseBoolean(dataParts[7]);
                String faculty = dataParts[8];

                System.out.println(
                        campName + "\t" + campDate + "\t" + regisCloseDate + "\t" + location + "\t" + totalSlots
                                + "\t" + "10" + "\t" + campDescription + "\t" + staffInCharge + "\t"
                                + visibility + "\t" + faculty
                );

                CampInfo camp = new CampInfo(campName, campDate, regisCloseDate, location, totalSlots,10, campDescription, staffInCharge, visibility, faculty);
                CampDB.addCamp(campName, camp);
            }

            // Close the scanner when you're done with it
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

}
