package com.fest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TechFest {
<<<<<<< HEAD
	@Test
	public  void techFest() throws InvalidFormatException, IOException, InterruptedException {
=======
@Test
	public void event() throws IOException {
>>>>>>> 0faa63f60decdf738efa1dff8e7ddf7d9ef36d4d
		WebDriver driver = new ChromeDriver();
		driver.get("https://oa-techfest-test.web.app/ticket-summary");
		driver.manage().window().maximize();
		int Student =1;
		int Professional=1;
<<<<<<< HEAD

=======
		
>>>>>>> 0faa63f60decdf738efa1dff8e7ddf7d9ef36d4d
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
				continue;  
			}
			WebElement selectSize = driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div[2]/form/div[" + i + "]/div/div[2]/div[2]/div[2]/select"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(selectSize));
			selectSize.click();

			//   option index
			String xpath = "/html/body/div[1]/section/div[2]/div[2]/form/div[" + i + "]/div/div[2]/div[2]/div[2]/select/option[" + optionIndex + "]";
			WebElement sizeOption = driver.findElement(By.xpath(xpath));
			sizeOption.click();  // Select the size option						
		}
		WebElement check =driver.findElement(By.xpath("/html/body/div[1]/section/section/div/section/div/div/div/button"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(check));
		check.click();
		Thread.sleep(5000);
		
		WebElement iframe = driver.findElement(By.xpath("//input[@name='save']"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		iframe.click();
		driver.switchTo().frame(iframe);
		
		//driver.switchTo().frame(0);
		iframe.click();
		driver.switchTo().frame(iframe);
		
		WebElement cardNo = driver.findElement(By.xpath("//[@type='checkbox']"));
		//String CardString = cardNo.toString();
		//CardString.
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById(arguments[0]).value = arguments[1];", "/html/body/div/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div/form/div[1]/div[1]/label/input", "125436894562158");

		//wait.until(ExpectedConditions.elementToBeClickable(cardNo));
		//cardNo.sendKeys("125436894562158");
	
		
		
		//WebElement Click=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div/div[1]/div[1]/label[2]/div/div"))));
		//Click.click();
		//		WebElement iframeElement = driver.findElement(By.xpath("/html/body/div[2]/iframe"));
		//		WebElement frameClick=wait.until(ExpectedConditions.elementToBeClickable(iframeElement));
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div/form/div[1]/div[1]/label/input")).sendKeys("1456");
	
	}

}


