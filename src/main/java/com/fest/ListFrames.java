package com.fest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class ListFrames {
    public static void main(String[] args) {
       

        // Initialize the WebDriver (Chrome in this case)
        WebDriver driver = new ChromeDriver();

        // Open the target URL
        driver.get("https://oa-techfest-test.web.app/ticket-summary");

        // Find all <iframe> and <frame> elements on the page
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        List<WebElement> frameElements = driver.findElements(By.tagName("frame"));

        // Combine both lists
        iframeElements.addAll(frameElements);

        // Print details for each frame
        for (int i = 0; i < iframeElements.size(); i++) {
            WebElement frame = iframeElements.get(i);
            System.out.println("Frame " + (i + 1) + ":");
            System.out.println("  - Tag Name: " + frame.getTagName());
            System.out.println("  - Frame ID: " + frame.getAttribute("id"));
            System.out.println("  - Frame Name: " + frame.getAttribute("name"));
            System.out.println("  - Frame Src: " + frame.getAttribute("src"));
            System.out.println();
        }

        // Close the driver
       // driver.quit();
    }
}
