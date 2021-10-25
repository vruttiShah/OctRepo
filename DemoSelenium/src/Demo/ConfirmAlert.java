package Demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.WebBrowser;

public class ConfirmAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=WebBrowser.openBrowser("http://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.linkText("Alert with OK & Cancel")).click();
		
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
			Alert alertbox=driver.switchTo().alert();
			String expected="Press a Button !";
			String actual=alertbox.getText();
			
			System.out.println(actual);
			
			if(expected.equals(actual))
			{
				System.out.println("Both matches");
			}
			Thread.sleep(5000);
			
			alertbox.dismiss();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	

}
