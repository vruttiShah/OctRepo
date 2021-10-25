package Demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import utility.WebBrowser;

public class ExplicitFluentWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// manage is method webdriver In manage there is method timeouts
		// timeouts method return Timeouts in this interface method
		// implicitlyWait(long integer, TimeUnit);
		/*
		 * An implementation of the Wait interface that may have its timeout and polling
		 * interval configured on the fly. Each FluentWait instance defines the maximum
		 * amount of time to wait for a condition, as well as the frequency with which
		 * to check the condition. Furthermore, the user may configure the wait to
		 * ignore specific types of exceptions whilst waiting, such as
		 * NoSuchElementExceptions when searching for an element on the page.
		 */

		
		WebDriver driver=WebBrowser.openBrowser("https://www.flipkart.com/search?q=smartphone");

		int count=1;
		
		while(isVisible(driver,By.xpath("//*[text()='Next']"))) {
			if (isVisible(driver,By.xpath("//*[@class='_4rR01T']"))) {
				List<WebElement> list = driver.findElements(By.xpath("//*[@class='_4rR01T']"));

				for (WebElement ele : list) {
					if (isVisible(driver, By.xpath("//*[@class='_4rR01T']"))) {
						for(int i=0;i<10;i++) {
						System.out.println(count+":"+ele.getText());
						count++;
						break;
						
						}
					}
				}

			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			Thread.sleep(5000);
		}
		
		
	}

	public static boolean isVisible(WebDriver driver, By by) {

		Wait<WebDriver> ft = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofSeconds(60)).ignoring(NoSuchElementException.class);

		WebElement ele = ft.until(new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {

				return driver.findElement(by);
			}
		});

		return ele.isDisplayed();
	}

}
