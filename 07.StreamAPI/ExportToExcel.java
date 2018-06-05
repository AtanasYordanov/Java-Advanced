import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private static final String PATH = "./src/main/resources/StudentData.txt";

    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student Data");
        Map<Integer, String[]> data = new TreeMap<>();
        int rowIndex = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] cells = line.split("\\t");
                data.put(rowIndex++, cells);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        sheet.setColumnWidth(0, 3000);
        sheet.setColumnWidth(1, 3000);
        sheet.setColumnWidth(2, 3000);
        sheet.setColumnWidth(3, 8000);
        sheet.setColumnWidth(4, 2000);
        sheet.setColumnWidth(5, 2000);
        sheet.setColumnWidth(6, 2000);
        sheet.setColumnWidth(7, 2000);
        sheet.setColumnWidth(8, 2000);
        sheet.setColumnWidth(9, 2000);
        sheet.setColumnWidth(10, 4000);

        rowIndex = 0;
        for (Integer key : data.keySet()) {
            Row row = sheet.createRow(rowIndex++);
            int cellIndex = 0;
            for (String cellData : data.get(key)) {
                Cell cell = row.createCell(cellIndex++);
                cell.setCellValue(cellData);

            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("student-data.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
