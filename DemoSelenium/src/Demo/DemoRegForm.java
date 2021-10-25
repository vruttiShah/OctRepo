package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.WebBrowser;

public class DemoRegForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=WebBrowser.openBrowser("https://demoqa.com/automation-practice-form");
		
		driver.findElement(By.id("firstName")).sendKeys("Vrutti");
		driver.findElement(By.id("userEmail")).sendKeys("vruttishah@");
		List<WebElement> radios=driver.findElements(By.name("gender"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		for(WebElement rb:radios)
		{
			if(rb.getAttribute("value").equals("Female"))
			{
				js.executeScript("arguments[0].click()", rb);
				break;
			}
		}
	}

}
