package com.rahulshetty;

import static org.testng.Assert.assertEquals;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

public class Basics {

	public static WebDriver driver;

	@Test
	public void tc1() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("I am tc1");
		boolean act = driver.findElement(By.xpath("//h1[text()='Practice Page']")).isDisplayed();
		Assert.assertEquals(act, true);
	}

	@Test
	public void tc2() {
		WebElement radio = driver.findElement(By.cssSelector("input[value='radio2']"));
		radio.click();
		boolean rad = radio.isSelected();
		Assert.assertEquals(rad, true);
	}

	@Test
	public void tc3() {
		WebElement check1 = driver.findElement(By.id("checkBoxOption1"));
		check1.click();
		WebElement check2 = driver.findElement(By.id("checkBoxOption1"));

		boolean chk = check2.isSelected();
		Assert.assertEquals(chk, true);
	}

	@Test
	public void tc4() {
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByValue("option1");
		String text = s.getFirstSelectedOption().getText();
		Assert.assertEquals(text, "Option1");

	}

	@Test
	public void tc5() throws Exception {
		WebElement textbox = driver.findElement(By.id("autocomplete"));
		System.out.println("Inside tc 5");
		textbox.sendKeys("can");
		Thread.sleep(5000);
		List<WebElement> allOptions = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		int l = allOptions.size();
		for (int i = 0; i < l; i++) {
			System.out.println("Inside for loop");
			String text = allOptions.get(i).getText();
			System.out.println("text is " + text);
			if (text.contains("Canada")) {
				System.out.println("Sucess.......");
				allOptions.get(i).click();
				break;
			}
		}
	}

	@Test
	public void tc6() throws InterruptedException {
		String parent = driver.getWindowHandle();
		System.out.println("Patent window is........" + parent);
		System.out.println("Window tile is" + driver.getTitle());
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(10000);
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> l1 = allWindows.iterator();
		System.out.println("All windows" + allWindows);
		while (l1.hasNext()) {
			String child = l1.next();
			driver.switchTo().window(child);

		}
		driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
		System.out.println("WIndow title before switching to parent " + driver.getTitle());
		boolean b = driver.findElement(By.xpath("//h3[text()='An Academy to learn Everything about Testing']"))
				.isDisplayed();
		Assert.assertEquals(b, true);
		driver.close();
		driver.switchTo().window(parent);
		System.out.println("WIndow title after switching to parent " + driver.getTitle());
		System.out.println("end of test cases execution");
//		driver.quit();

	}

	@Test
	public void tc7() throws InterruptedException {
		String parent = driver.getWindowHandle();
		System.out.println("Parent window for open TC7 is........" + parent);
		System.out.println("Window tile for open TC7 is" + driver.getTitle());

		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		Thread.sleep(10000);
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> l1 = allWindows.iterator();
		System.out.println("All windows" + allWindows);
		while (l1.hasNext()) {
			String child = l1.next();
			driver.switchTo().window(child);
		}

		System.out.println("WIndow title before switching to parent " + driver.getTitle());
		boolean b = driver.findElement(By.linkText("Mentorship")).isDisplayed();
		Assert.assertEquals(b, true);
		driver.close();
		driver.switchTo().window(parent);
		System.out.println("WIndow title after switching to parent " + driver.getTitle());
		System.out.println("end of test cases execution 7 tc");
//		driver.quit();

	}

	@Test
	public void rc010() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> allproducts = driver.findElements(By.xpath("//h4"));
		System.out.println("All products" + allproducts);
		int sz = allproducts.size();
		System.out.println("All products size" + sz);
		for (int i = 0; i < sz; i++) {

			String Product = allproducts.get(i).getText();
			if (Product.contains("Carrot - 1 Kg")) {
				System.out.println("The prodct to be selected " + i);
				break;
			}

		}
	}

	@Test
	public void rc10() {

		String name = "vivek";
		driver.findElement(By.name("enter-name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();
		String gettext = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals(gettext, "Hello " + name + ", share this practice page and share your knowledge");

	}

	@Test
	public void tc12() throws InterruptedException {
		driver.navigate().to("https://jqueryui.com/droppable/");
		Thread.sleep(10000);
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		WebElement w1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement w2 = driver.findElement(By.xpath("//div[@id='droppable']"));

		Actions builder = new Actions(driver);

		builder.dragAndDrop(w1, w2).perform();
	}

	@Test
	public void tc9() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("#mousehover"));
		action.moveToElement(move).perform();
		Thread.sleep(20000);
		driver.findElement(By.linkText("Top")).click();
	}



@Test
	public void tc123() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("#mousehover"));
		action.moveToElement(move).perform();
		Thread.sleep(20000);
		driver.findElement(By.linkText("Top")).click();
	}
	
	@Test
	public void datePick() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		Thread.sleep(4000);
		boolean flag1 = false;
		while (flag1 == false) {
			List<WebElement> calenderheader = driver
					.findElements(By.xpath("//div[contains(@class,'ui-datepicker-group ui-datepicker-group')]"));
			int length = calenderheader.size();
			for (int i = 0; i < length; i++) {
				String monthname = calenderheader.get(i).findElement(By.className("ui-datepicker-month")).getText();
				System.out.println("month name is " + monthname);

				if (monthname.contains("May")) {
					System.out.println("UseR is in May");
					flag1 = true;
					break;
				} else if (i == length - 1) {
					calenderheader.get(i).findElement(By.xpath("//span[text()='Next']")).click();
				}

			}

		}

	}

	@BeforeTest
	@Parameters({ "browser" })
	public void setup(String s) {
		if (s.equalsIgnoreCase("gecko")) {
			System.out.println("I am the beginiing of the execution");
			System.setProperty("webdriver.gecko.driver", "E:\\Chromedriver_driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} 
		else 
		{
			System.out.println("I am the beginiing of the execution");
			System.setProperty("webdriver.chrome.driver", "E:\\Chromedriver_driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}

	@AfterTest
	public void postexe() {
		System.out.println("I am the end  of the execution");

	}

@AfterTest
	public void postexe() {
		System.out.println("I am tution");

	}



}
