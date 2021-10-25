package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class WebBrowser {
	
	public static WebDriver openBrowser(String url)
	{
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	public static void verifyTitle(WebDriver driver,String exptitle)
	{
		String acttitle=driver.getTitle();
				if(acttitle.equals(exptitle))
				{
					System.out.println("Title Matched");
				}
				else
				{
					System.out.println("Title not matched");
				}
	}
	
	public static WebElement isVisible(WebDriver driver, By by) {

		Wait<WebDriver> ft = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class);

		WebElement ele = ft.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {

				return driver.findElement(by);
			}
		});

		return ele;

	}
	
	
	public static boolean isVisible(WebDriver driver, WebElement e) {

		Wait<WebDriver> ft = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class);

		return  ft.until(ExpectedConditions.visibilityOf(e)).isDisplayed();	
		

	}
	
}


