package selenium;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Runninginfirefox {

	public static void main(String[] args) throws Exception 
	{
		//ChromeDriver driver = new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.getcalley.com/page-sitemap.xml");
		Dimension size = new Dimension(1366,768);
		driver.manage().window().setSize(size);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File temporaryFile=ts.getScreenshotAs(OutputType.FILE);
		String timestamp=LocalDateTime.now().toString().replace(':', '-');
		System.out.println(timestamp);
		String name="windows-1920-1080"+timestamp;
		System.out.println(name);
		String path ="./Screenshot/"+name+".png";
		
		File parmentFile = new File(path);
		
		FileUtils.copyFile(temporaryFile,parmentFile);
		
		String url = driver.getCurrentUrl();
		if (url.equals("https://www.getcalley.com/page-sitemap.xml"))
		{
			System.out.println("test case passed");
		}
		else
		{
			System.out.println("test case failed");
		}
		driver.close();
		
		

	}

}
