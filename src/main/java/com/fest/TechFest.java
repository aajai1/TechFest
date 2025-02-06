package com.fest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TechFest {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://techfest.oceanacademy.co.in/ticket-summary");
		driver.manage().window().maximize();
		int Student =3;
		int Professional=1;

	



		//student
		for (int i = 1; i <= Student; i++) { 
			WebElement plusStudent =driver.findElement(By.xpath("//*[@id=\"root\"]/main[2]/section[1]/div[3]/div[1]/main/section/div/div[1]/div/button[2]"));
			plusStudent.click();
		}
		//pro
		for (int i = 1; i <= Professional; i++) { 
			WebElement plusPro =driver.findElement(By.xpath("/html[1]/body[1]/div[1]/main[2]/section[1]/div[3]/div[2]/main[1]/section[1]/div[1]/div[1]/button[2]"));
			plusPro.click();
		}

		driver.findElement(By.xpath("//button[@type='submit']")).click();


		File file = new File("./StudentData.xlsx") ;
		FileInputStream ipsfile = new FileInputStream(file);
		XSSFWorkbook Stubook = new XSSFWorkbook(ipsfile);
		XSSFSheet sheet=Stubook.getSheetAt(0);



		//fill name
		for (int i = 1; i <= Student+Professional; i++) {
			XSSFRow row =sheet.getRow(i);
			XSSFCell cell=row.getCell(0);
			String cellString =cell.toString();
			System.out.println(cellString);
			WebElement studenName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/div[2]/div[2]/form[1]/div["+i+"]/div[1]/div[2]/div[1]/div[1]/input[1]"));
			studenName.sendKeys(cellString);	
		}
		//fill email
		for (int i = 1; i <= Student+Professional; i++) {
			XSSFRow row =sheet.getRow(i);
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

		//mobile
		for (int i = 1; i <= Student+Professional; i++) {
			XSSFRow row =sheet.getRow(i);
			XSSFCell cell=row.getCell(2);
			String cellNumber =cell.toString().trim();
			System.out.println(cell);

			WebElement studentnumber=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/div[2]/div[2]/form[1]/div["+i+"]/div[1]/div[2]/div[2]/div[1]/div[1]/input[1]"));
			studentnumber.sendKeys(cellNumber);
			//					
		}

		//Institute
		for (int i = 1; i <= Student+Professional; i++) {
			XSSFRow row =sheet.getRow(i);
			XSSFCell cell=row.getCell(3);
			String cellInstitute =cell.toString().trim();
			System.out.println(cellInstitute);

			WebElement studentnumber=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/section[1]/div[2]/div[2]/form[1]/div["+i+"]/div[1]/div[2]/div[3]/input[1]"));
			studentnumber.sendKeys(cellInstitute);

		}

		//Size
		for (int i = 1; i <= Student+Professional; i++) {
			XSSFRow row =sheet.getRow(i);
			XSSFCell cellsize=row.getCell(4);


			String sizeValue = cellsize.toString().trim().toLowerCase();
			
			int optionIndex = 0;
			switch (sizeValue) {
			case "s":
				optionIndex = 2;  
				break;
			case "m":
				optionIndex = 3; 
				break;
			case "l":
				optionIndex = 4;  
				break;
			case "xl":
				optionIndex = 5;  
				break;
			case "xxl":
				optionIndex = 6;  
				break;
			default:
				System.out.println("Invalid size: " + sizeValue);
				continue;  // Skip if the size is invalid
			}
			WebElement selectSize = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/form/div[" + i + "]/div/div[2]/div[2]/div[2]/select"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(selectSize));
			selectSize.click();

			// Construct the XPath using the option index
			String xpath = "/html/body/div[1]/section/div[2]/div[2]/form/div[" + i + "]/div/div[2]/div[2]/div[2]/select/option[" + optionIndex + "]";
			WebElement sizeOption = driver.findElement(By.xpath(xpath));
			sizeOption.click();  // Select the size option						
		}
		WebElement check =driver.findElement(By.xpath("/html/body/div[1]/section/section/div/section/div/div/div/button"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(check));
		check.click();
	}

}


