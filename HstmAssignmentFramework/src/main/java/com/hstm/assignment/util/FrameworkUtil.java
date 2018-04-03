package com.hstm.assignment.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.github.javafaker.Faker;
import com.hstm.assignment.base.TestBase;
import com.hstm.assignment.flux1.AddCourse;
import com.hstm.assignment.flux1.AddStudent;

public class FrameworkUtil extends TestBase {

	public static int PAGE_LOAD_TIMEOUT = 60;
	public static int IMPLICIT_WAIT = 60;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "//src//main///java//com//hstm//assignment//testdata//AssignmentData.xlsx";

	Faker faker = new Faker();

	// Get Random student Name and userID
	public String studentFirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}

	public String studentLastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}

	public String studentUserName() {
		String userName = faker.name().username();
		return userName;

	}

	// Get Random Course Name
	public String courseName() {
		String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		while (sb.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * CHARS.length());
			sb.append(CHARS.charAt(index));
		}
		String cName = sb.toString();
		return cName;
	}

	// Fetch current date
	public String currentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String cDate = sdf.format(new Date());
		return cDate;
	}

	public void jsScrollDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void WriteStudentDataToExcel(String path) throws Exception {
		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fis); // Access the workbook

		XSSFSheet worksheet = wb.getSheetAt(0);

		worksheet.createRow(1);

		worksheet.getRow(1).createCell(0).setCellValue(AddStudent.userID);
		worksheet.getRow(1).createCell(1).setCellValue(AddStudent.lName);
		worksheet.getRow(1).createCell(2).setCellValue(AddStudent.fName);

		FileOutputStream fout = new FileOutputStream(path);
		wb.write(fout);

	}
	
	public void WriteCourseDatatoExcel(String path) throws Exception{
		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fis); // Access the workbook

		XSSFSheet worksheet = wb.getSheetAt(0);

		worksheet.createRow(1);
		worksheet.getRow(1).createCell(0).setCellValue(AddCourse.crstitle);

		FileOutputStream fout = new FileOutputStream(path);
		wb.write(fout);
		
	}

	public String ReadStudentDataFromExcel(String path, int row, int col) throws Exception {

		FileInputStream fis = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fis); // Access the workbook

		XSSFSheet worksheet = wb.getSheetAt(0);

		String data = worksheet.getRow(row).getCell(col).getStringCellValue();
		return data;

	}

	public String selectPastDate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -3);
		String reqDate = dateFormat.format(cal.getTime());
		return reqDate;
	}

	public String selectFutureDate() {

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 6);
		String reqDate = dateFormat.format(cal.getTime());
		return reqDate;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	public Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		Workbook book = null;
		Sheet sheet;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
		
		
	}
	
	}
	
