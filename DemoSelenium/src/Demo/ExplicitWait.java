package Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WebBrowser;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=WebBrowser.openBrowser("http://google.com");
		WebDriverWait wt=new WebDriverWait(driver, 30);
		try
		{
			driver.findElement(By.name("q")).sendKeys("ipl");
			
			By locator=By.xpath("//ul[@class='G43f7e']//li");
			
			wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
			
			List<WebElement> list=driver.findElements(locator);
			
			for(WebElement ele:list)
			{
				System.out.println(ele.getText());
			}
			
			for(WebElement ele:list)
			{
				if(ele.getText().equalsIgnoreCase("ipl points table"))
				{
					ele.click();
					break;
				}
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
