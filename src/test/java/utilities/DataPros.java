package utilities;

import org.testng.annotations.DataProvider;

public class DataPros {

	@DataProvider(name="LoginData")
	public String[][] getdata() throws Exception{
		
		String path = ".\\testData\\TestData.xlsx";
		
		Excel_Utility excel = new Excel_Utility(path);
		
		int totalRows = excel.rowCount("Sheet1");
		int totalCells = excel.cellCount("Sheet1", 1);
		
		String loginData[][] = new String[totalRows][totalCells];
		
		for(int i=1; i<=totalRows; i++) {
			
			for(int j=0; j<totalCells; j++) {
				loginData[i-1][j] = excel.getCelldata("Sheet1", i, j);
			}
		}
		
		return loginData;
	}
}
