package com.crm.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Dell
 *
 */

public class WebDriverUtility {

	/**
	 * wait for page to load before identifing  any synchronized element in DDOM[HTML] document
	 * @param driver
	 */
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * wait for page to load before identifying any assyncronized[java script actions] element in DDOM[HTML] document
	 * @param driver
	 * @param element
	 */
		public void waitForPageToLoadForJSElement(WebDriver driver) {
			driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
		}
		/**
		 * used to wait for element to be Clickable in GUI,and check for sspecific element for every 500milli seconds
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

		/**
		 * used to wait for element to be Clickable in GUI,and check for sspecific element for every 500milli seconds
		 * @param driver 
		 * @param element
		 * @param polling Time in the form second
		 * @throws InterruptedException 
		 * @throws Throwable
		 */
			public void WaitForElementWithCumtomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws InterruptedException {
				FluentWait wait = new FluentWait(driver);
				wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
				wait.wait(20);
				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
			/**
			 * @param driver
			 * @param partialWindowTitle
			 */
			public void switchToWindow(WebDriver Driver,String PartialWindowTitle) {
			Set<String>	set=Driver.getWindowHandles();
			Iterator<String> it=set.iterator();
			
			while(it.hasNext()) {
				String wID=it.next();
				Driver.switchTo().window(wID);
				String currentWindowTitle=Driver.getTitle();
				if(currentWindowTitle.contains(PartialWindowTitle)) {
					break;
					
				}
			}
			}
			/**
			 * used to switch to Alert Window and Click on OK Button
			 * @param driver
			 */
			public void swithToAlertWindowAndAccecpt(WebDriver driver) {
				driver.switchTo().alert().accept();
			}
			/**
			 *  used to switch to Alert Window and Click on cancel Button
			 *  @param driver
			 * 	
			 */
			public void swithToAlertWindowAndCancel(WebDriver driver) {
				driver.switchTo().alert().dismiss();
			}	
			
			
			/**
			 * used to swith to Frame window based on Index
			 * @param driver
			 */
			public void swithToFrame(WebDriver driver,int index) {
				driver.switchTo().frame(index);
			}
			/**
			 * used to switch to frame window based on id or name attribute
			 * @param driver
			 * @param id_name_attribute
			 */
				public void swithToFrame(WebDriver driver,String id_name_attribute) {
					driver.switchTo().frame( id_name_attribute);
				}
				/**
				 * used to select the value from the dropdown based on index
				 * @param driver
				 * @param index
				 */
				public void select(WebElement element,int index) {
					Select sel=new Select(element);
					sel.selectByIndex(index);
				}
				/**
				 *  used to select the value from the dropdown based on value /option avilableon GUI
				 *  @param element
				 *  @param value
				 */
				public void select(WebElement element,String text) {
					Select sel=new Select(element);
					sel.selectByVisibleText(text);
				}
				/**
				 * used to place mouse cursor on specified element
				 * @param driver
				 * @param element
				 */
				public void mouseOverOnElement(WebDriver driver,WebElement element) {
				Actions	act=new Actions(driver);
				act.moveToElement(element).perform();
				}
				/**
				 * used to right click on specified element
				 * @param driver
				 * @param element
				 */
				public void rightClickOnElement(WebDriver driver,WebElement element) {
					Actions act=new Actions(driver);
					act.contextClick(element).perform();
				}
				
				/**
				 * @param driver
				 * @param element
				 */
				public void rightClickOnElement(WebDriver driver,String javaScript) {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeAsyncScript(javaScript, null);
				}
				public void waitAndClick(WebElement element) throws InterruptedException
				{
					int count=0;
					while(count<20) {
						try {
							element.click();
							break;
						}catch(Throwable e) {
							Thread.sleep(1000);
							count++;
						}
					}
				}
				public void takeScreenShot(WebDriver driver,String screenShotName) throws Throwable {
					TakesScreenshot ts=(TakesScreenshot)driver;
					File src=ts.getScreenshotAs(OutputType.FILE);
					File dest=new File("./screenshot/"+screenShotName+".PNG");
					Files.copy(src, dest);
				}
				/**
				 * press enter key appertain in to browser
				 * @param driver
				 */
					public void passEnterKey(WebDriver driver) {
						Actions act=new Actions(driver);
						act.sendKeys(Keys.ENTER).perform();
					}
					/**
					 * 	
					 */
					public void Maximisewindow(WebDriver driver) {
						driver.manage().window().maximize();
					}
				

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
				
				
				
				
				
				
				
				
				
				
				
				
				
	}

