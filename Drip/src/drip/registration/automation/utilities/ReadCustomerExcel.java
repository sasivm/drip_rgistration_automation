package drip.registration.automation.utilities;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadCustomerExcel {

	private final static int TOTAL_COLUMN_COUNT = FieldsExcelConstants.FIELDS_LABEL_LIST.length;

	public static boolean getDataFromExcel() throws IOException {
		File file = new File(FieldsExcelConstants.EXCEL_FILE_FULL_PATH);
		final String fileName = FieldsExcelConstants.EXCEL_FILE_NAME;

		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		String fileExtension = fileName.substring(fileName.indexOf("."));

		if (fileExtension.equals(FieldsExcelConstants.EXCEL_EXTENSION_XLSX)) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtension.equals(FieldsExcelConstants.EXCEL_EXTENSION_XLS)) {
			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet sheet = workbook.getSheet(FieldsExcelConstants.EXCEL_FILE_WORKSHEET_NAME);
		if (sheet == null) {
			System.out.println("The Excel workbook sheet is not found");
			return false;
		}
		// Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		if (rowCount < 1) { // rowCount starts from 0
			System.out.println("The Excel file does not have any customer data");
			return false;
		}

		if (!isHeaderInOrder(sheet.getRow(0))) {
			System.out.println("The Excel file headers or not in proper order");
			return false;
		}

		Row customerDataRow = sheet.getRow(1);
		for (int i = 0; i < TOTAL_COLUMN_COUNT; i++) {
			// Print Excel data in console
			String headerName = FieldsExcelConstants.FIELDS_LABEL_LIST[i];

			DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
			Cell columnCell = customerDataRow.getCell(i);
			String customerData = formatter.formatCellValue(columnCell).trim();

			if (FieldsExcelConstants.FIELDS_MAP.containsKey(headerName)) {
				FIELDS currentField = FieldsExcelConstants.FIELDS_MAP.get(headerName);
//				customerData = checkFilePathLocations(customerData, headerName);
				currentField.setValue(customerData);
			} else {
				System.out.println(headerName + " : Header field is not found in FIELDS_MAP");
				return false;
			}
		}

		/*
		 * Create a loop over all the rows of excel file to read it for (int i = 1; i <
		 * rowCount + 1; i++) { Row row = sheet.getRow(1); // Create a loop to print
		 * cell values in a row for (int j = 0; j < row.getLastCellNum(); j++) { //
		 * Print Excel data in console String columnValue =
		 * row.getCell(j).getStringCellValue().trim(); System.out.print(columnValue +
		 * "|| "); } System.out.println(); }
		 */
		return true;
	}

	private static boolean isHeaderInOrder(Row headerRow) {
		for (int i = 0; i < TOTAL_COLUMN_COUNT; i++) {
			String header = FieldsExcelConstants.FIELDS_LABEL_LIST[i];

			DataFormatter formatter = new DataFormatter(); // creating formatter using the default locale
			Cell columnCell = headerRow.getCell(i);
			String columnHeader = formatter.formatCellValue(columnCell).trim();

			if (!header.equals(columnHeader)) {
				System.out.println("Excel header " + header + " not matched with list : " + columnHeader);
				return false;
			}
		}

		return true;
	}
}
