package wrappers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class seleniuGrid {
	
	
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("browserName", "chrome");
	
		String url = "http://13.233.76.246:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(url),caps);
		
		driver.get("https://www.google.co.in/");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.quit();
		
	}

}
