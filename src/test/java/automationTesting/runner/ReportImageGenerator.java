package automationTesting.runner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ReportImageGenerator {

    public RemoteWebDriver driver;

    @Test(priority = 0)
    public void takeSnapExtent() throws InterruptedException, IOException {
        String userDirectory = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "./drivers/ubuntu/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String url = "file:///" + userDirectory + "/reports/result.html";
        driver.get(url);
        driver.findElementByXPath("//a[@view='dashboard-view']").click();
        driver.executeScript("document.body.style.zoom='80%';");
        Thread.sleep(2000);
        takeSnapShot("./extent.png");
        Thread.sleep(2000);
        driver.close();
    }

    public void takeSnapShot(String destinationPath, WebElement element) {
        try {
            File srcFile = driver.getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(srcFile);
            Point point = element.getLocation();
            int width = element.getSize().getWidth();
            int height = element.getSize().getHeight();
            BufferedImage ElementScreenshot = fullImg.getSubimage(point.getX(), point.getY() - 125, width, height);
            ImageIO.write(ElementScreenshot, "png", srcFile);
            File DestFile = new File(destinationPath);
            FileUtils.copyFile(srcFile, DestFile);
        } catch (WebDriverException e) {
            System.out.println("webdriver Exception");
        } catch (IOException e) {
            System.out.println("InputOutput Exception");
        }
    }

    public void takeSnapShot(String destinationPath) {
        try {
            File srcFile = driver.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(destinationPath);
            FileUtils.copyFile(srcFile, DestFile);
        } catch (WebDriverException e) {
            System.out.println("webdriver Exception");
        } catch (IOException e) {
            System.out.println("InputOutput Exception");
        }

    }

}
