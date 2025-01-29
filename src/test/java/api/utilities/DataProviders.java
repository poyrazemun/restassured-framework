package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {


    @DataProvider(name = "allUserData")
    public Object[][] getUserData() throws IOException {
        String filePath = "testData/userData.xlsx";
        ExcelUtils excelUtils = new ExcelUtils(filePath);
        Object[][] data = excelUtils.getSheetData("data");
        excelUtils.closeWorkbook();
        return data;
    }


    @DataProvider(name = "userNameProvider")
    public Object[][] getUserNames() throws IOException {
        String filePath = "testData/userData.xlsx";
        ExcelUtils excelUtils = new ExcelUtils(filePath);

        String sheetName = "data";
        Object[][] sheetData = excelUtils.getSheetData(sheetName);


        Object[][] userNameData = new Object[sheetData.length][1];
        for (int i = 0; i < sheetData.length; i++) {
            userNameData[i][0] = sheetData[i][1];
        }

        excelUtils.closeWorkbook();
        return userNameData;
    }


}
