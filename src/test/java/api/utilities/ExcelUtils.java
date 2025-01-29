package api.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    private final XSSFWorkbook workbook;

    public ExcelUtils(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Dosya bulunamadı: " + filePath);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        this.workbook = new XSSFWorkbook(fileInputStream);
    }

    public Object[][] getSheetData(String sheetName) {
        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sayfa bulunamadı: " + sheetName);
        }

        int rowCount = sheet.getPhysicalNumberOfRows();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount - 1][columnCount];

        for (int i = 0; i < rowCount - 1; i++) {
            XSSFRow row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            data[i][j] = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (j == 0) { // Sadece userID için int dönüşümü yap
                                data[i][j] = (int) cell.getNumericCellValue();
                            } else {
                                data[i][j] = String.valueOf(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            data[i][j] = String.valueOf(cell.getBooleanCellValue());
                            break;
                        default:
                            data[i][j] = "";
                    }
                } else {
                    data[i][j] = "";
                }
            }
        }
        return data;
    }

    public void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
