package tests;

import java.util.List;
import java.util.Map;

import utilities.ExcelUtil;

public class ReadExcel {

	public static void main(String[] args) {
		List<Map<String,String>> data = ExcelUtil.readData("TestData.xlsx", "Sheet1");		
		
		System.out.println(data);
		
		for(Map<String,String> row : data) {
			System.out.println(row);
		}
		
		String [][] testData= ExcelUtil.readExcelData("TestData.xlsx", "Sheet1");
		
		System.out.println(testData[1][1]);

	}

}
