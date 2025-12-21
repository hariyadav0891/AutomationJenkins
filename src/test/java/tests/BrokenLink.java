package tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLink {
	
	@Test
	public void linl() {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
		
		List<WebElement> alinks=driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links "+alinks.size());
		
		List<String> urlList= new ArrayList<String>();
		
		for(WebElement e:alinks) {
			String url=e.getAttribute("href");
			urlList.add(url);
			//checkBrokenLink(url);
			
			long stTime=System.currentTimeMillis();
			urlList.parallelStream().forEach(a -> checkBrokenLink(a));
			long edTime=System.currentTimeMillis();
			System.out.println("Total time taken : "+(edTime-stTime));
		}
	}
	
	public static void checkBrokenLink(String linkurl) {
		
		try {
			
			URL url= new URL(linkurl);
			HttpURLConnection httpurlConnection= (HttpURLConnection) url.openConnection();
			httpurlConnection.setConnectTimeout(5000);
			httpurlConnection.connect();
			if(httpurlConnection.getResponseCode()>=400) {
				System.out.println(linkurl+ "----> "+httpurlConnection.getResponseMessage()+" is a broken link");
			}else {
				System.out.println(linkurl+ "----> "+httpurlConnection.getResponseMessage());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
