package drip.registration.automation;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import drip.registration.automation.utilities.FIELDS;
import drip.registration.automation.utilities.FieldsExcelConstants;
import drip.registration.automation.utilities.GlobalConstants;
import drip.registration.automation.utilities.ReadCustomerExcel;

public class Registeration {
	private static WebDriver driver = null;

	private static void initializeDriver() {
		System.setProperty(GlobalConstants.CHROME_DRIVER_NAME, GlobalConstants.CHROME_DRIVER_LOCATION);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(GlobalConstants.BASE_REGISTRATION_URL);
	}

	public static void passValueToField(FIELDS field) {
		if (field.getValue() == null || field.getValue().isEmpty()) {
			return;
		}

		try {
			String fieldType = field.getType();

			if (fieldType.equals(FieldsExcelConstants.FIELD_TYPE_TEXTBOX)) {
				WebElement element = driver.findElement(By.id(field.getId()));
				element.sendKeys(field.getValue());
			} else if (fieldType.equals(FieldsExcelConstants.FIELD_TYPE_DROPDOWN)) {
				Select dropdown = new Select(driver.findElement(By.id(field.getId())));
				dropdown.selectByVisibleText(field.getValue());
			} else {
				System.out.println("Field Type not matched : type is : " + fieldType);
			}
		} catch (UnhandledAlertException e) {
			System.out.println("Alert Box opende while filling field : " + field.getId());
			printFirstLineError(e.getMessage());
		} catch (InvalidArgumentException e) {
			printFirstLineError(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("Error while filling dropdown field element/option not found: " + field.getId());
			printFirstLineError(e.getMessage());
		} catch (Exception e) {
			System.out.println("Error while filling field : " + field.getId());
			e.printStackTrace();
		}
	}

	public static void clickButton(String btnId) {
		try {
			driver.findElement(By.id(btnId)).click();
		} catch (Exception e) {
			System.out.println("Error while clicking button - btn id : " + btnId);
			printFirstLineError(e.getMessage());
		}
	}

	private static void printFirstLineError(String errorMessage) {
		String[] messageList = errorMessage.split("\n");
		System.out.println(messageList[0]);
	}

	private static void fillAllFields() {
		try {
			if (ReadCustomerExcel.getDataFromExcel()) {
				System.out.println(FieldsExcelConstants.FIELDS_MAP);

				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

				FormMapper.copyFieldsValueToFormMaps();

				ArrayList<FIELDS> fields = new ArrayList<FIELDS>(FieldsExcelConstants.FORMER_FORM_FIELDS_MAP.values());

				passValueToField(fields.get(0));
				driver.findElement(By.id("txtFarmerName")).sendKeys("");// For Aadhar Validation

				for (int i = 1; i < fields.size(); i++) {
					passValueToField(fields.get(i));
				}

				for (FIELDS field : FieldsExcelConstants.LAND_FORM_FIELDS_MAP.values()) {
					passValueToField(field);
				}
				
				FormMapper.checkForMultSurvey();

				for (FIELDS field : FieldsExcelConstants.CROP_FORM_FIELDS_MAP.values()) {
					passValueToField(field);
				}

				for (FIELDS field : FieldsExcelConstants.ACCOUNT_FORM_FIELDS_MAP.values()) {
					passValueToField(field);
				}

				for (FIELDS field : FieldsExcelConstants.DOCUMENT_FORM_FIELDS_MAP.values()) {
					passValueToField(field);
				}
			}
		} catch (IOException e) {
			System.out.println("Error occured while reading customer data from Excel");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Expected while filling form");
			e.printStackTrace();
		} finally {
			System.out.println("********************* Completed filling form *********************");
		}
	}

	public static void main(String[] args) {
		initializeDriver();
		fillAllFields();
	}

}
