package com.fest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExcelUtil {
	
	static int Student =3;
	static int Professional=3;
	static WebDriver driver;
	public static void name() throws IOException {

		//fill name
		for (int i = 1; i <= Student+Professional; i++) {
			File file = new File("C:\\Users\\acer\\Documents\\ExcelData\\StudentData.xlsx") ;
			FileInputStream ipsfile = new FileInputStream(file);
			XSSFWorkbook Stubook = new XSSFWorkbook(ipsfile);
			XSSFSheet sheet=Stubook.getSheetAt(0);
			XSSFRow row =sheet.getRow(i);
			XSSFCell cell=row.getCell(0);
			String cellString =cell.toString();
			System.out.println(cellString);
			WebElement studenName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/div[2]/div[2]/form[1]/div["+i+"]/div[1]/div[2]/div[1]/div[1]/input[1]"));
			studenName.sendKeys(cellString);	
		}
	}
	
	public static void email() throws Exception {
		//fill email
		for (int i = 0; i <= Student+Professional; i++) {
			File file = new File("C:\\Users\\acer\\Documents\\ExcelData\\StudentData.xlsx") ;
			FileInputStream ipsfile = new FileInputStream(file);
			XSSFWorkbook Stubook = new XSSFWorkbook(ipsfile);
			XSSFSheet sheet=Stubook.getSheetAt(0);
			XSSFRow row =sheet.getRow(i+1);
			XSSFCell cell=row.getCell(1);
			if (cell == null) {
				System.out.println("Cell in row " + i + " column 1 is null.");
				continue;  // Skip this iteration if the cell is null
			}
			String cellString =cell.toString();
			System.out.println(cellString);

			WebElement studenemail=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/div[2]/div[2]/form[1]/div["+i+"]/div[1]/div[2]/div[1]/div[2]/input[1]"));
			studenemail.sendKeys(cellString);


		}
	}
	
	public static void number() throws IOException {
		//mobile
		for (int i = 1; i <= Student+Professional; i++) {
			File file = new File("C:\\Users\\acer\\Documents\\ExcelData\\StudentData.xlsx") ;
			FileInputStream ipsfile = new FileInputStream(file);
			XSSFWorkbook Stubook = new XSSFWorkbook(ipsfile);
			XSSFSheet sheet=Stubook.getSheetAt(0);
			XSSFRow row =sheet.getRow(i);
			XSSFCell cell=row.getCell(2);
			String cellNumber =cell.toString().trim();
			System.out.println(cell);

			WebElement studentnumber=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/div[2]/div[2]/form[1]/div["+i+"]/div[1]/div[2]/div[2]/div[1]/div[1]/input[1]"));
			studentnumber.sendKeys(cellNumber);
							
		}
	}
	
}
