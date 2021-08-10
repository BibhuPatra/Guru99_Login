package com.day2_selenium;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Hello_Selenium_NewTours {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello New Tours");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bibhpatr\\Downloads\\Selenium_Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		WebElement reg_link= driver.findElement(By.linkText("REGISTER"));
		reg_link.click();
		String s1=driver.getTitle();
		System.out.println(s1);
		driver.findElement(By.name("firstName")).sendKeys("bibhu");
		driver.findElement(By.name("lastName")).sendKeys("patra");

		driver.findElement(By.name("phone")).sendKeys("7873828186");
		String  postal_code_XPATH="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/input";

		driver.findElement(By.xpath(postal_code_XPATH)).sendKeys("229001");
		WebElement CNT_drop_down= driver.findElement(By.name("country"));
		Select s2= new Select(CNT_drop_down);
		s2.selectByVisibleText("INDIA");
		Thread.sleep(3000);
		s2.selectByIndex(1);
		Thread.sleep(3000);
		s2.selectByValue("ANGOLA");
		Thread.sleep(3000);
		String submit_button_rxpath="//form/table/tbody/tr[17]/td/input";
		driver.findElement(By.xpath(submit_button_rxpath)).click();
		String s4= driver.getTitle();
		System.out.println("title after clicking on submit button : "+ "  "+ s4);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@href='login.php']")).click();
		driver.findElement(By.name("userName")).sendKeys("mercury");

		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("submit")).click();
		String title_after_login="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3";
		String succeful_login_text=driver.findElement(By.xpath(title_after_login)).getText();
		System.out.println(succeful_login_text);
		Assert.assertEquals("Login Successfully",succeful_login_text );
		System.out.println(" test passsed ");
	}

}
