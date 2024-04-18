
package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import javax.lang.model.element.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public WebDriverWait  webDriverWaitObj(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	public void waitUntilElementToBeVisible(WebDriver driver,int sec,WebElement element) 
	{
	
		webDriverWaitObj(driver,sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilElementToBeClickable(WebDriver driver,int sec,WebElement element)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitUntilToGetTitle(WebDriver driver,int sec,String title)
	{
		webDriverWaitObj(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	
	public Actions performActions(WebDriver driver)
	{
		Actions act=new Actions(driver);
		return act;
	}
	
public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
{
	performActions(driver).dragAndDrop(src, dst);
}
public void dragAndDrop(WebDriver driver,WebElement element,int x,int y)
{
	performActions(driver).dragAndDropBy(element, x, y);
}
public void mouseHover(WebDriver driver,WebElement element) 
{
	performActions(driver).click(element).perform();
}
public void doubleClick(WebDriver driver,WebElement element)
{
	performActions(driver).doubleClick(element).perform();;
}
public void contextClick(WebDriver driver)
{
	performActions(driver).contextClick().perform();
}
public void contextClick(WebDriver driver,WebElement element)
{
	performActions(driver).contextClick(element).perform();
}
public void enterKeyPress(WebDriver driver)
{
	performActions(driver).sendKeys(Keys.ENTER).perform();
}

public void switchWindow(WebDriver driver, String url)
{
	Set<String> wid = driver.getWindowHandles();
	for (String str : wid) {
		
		driver.switchTo().window(str);
		String Text = driver.getCurrentUrl();
		if(Text.contains(url))
		{
			break;
		}
	}
	
}

public void switchToWindow(WebDriver driver,String expWind)
{
	Set<String> window = driver.getWindowHandles();
	Iterator<String> it = window.iterator();
	while(it.hasNext())
	{
		String win = it.next();
		String currentTitle = driver.switchTo().window(win).getTitle();
		if(currentTitle.contains(expWind))
		{
			break;
		}
	}
}



public Robot robotObj() throws AWTException
{
	Robot r=new Robot();
	return r;
}
public void enterKey(WebDriver driver) throws AWTException
{
	robotObj().keyPress(KeyEvent.VK_ENTER);
	robotObj().keyRelease(KeyEvent.VK_ENTER);
}
public void switchToFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}
public void switchToFrame(WebDriver driver,String nameOrID)
{
	driver.switchTo().frame(nameOrID);
}
public void switchToFrame(WebDriver driver,WebElement frameEle)
{
	driver.switchTo().frame(frameEle);
}
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
public String getAlertText(WebDriver driver)
{
	String altText=driver.switchTo().alert().getText();
	return altText;
}
public void selectByVisibleText(WebDriver driver,WebElement ele,String text)
{
	Select sel = new Select(ele);
	sel.selectByVisibleText(text);
}
public void selectByValue(WebDriver driver,WebElement ele,String value)
{
	Select sel = new Select(ele);
	sel.selectByValue(value);
}
public void selectByIndex(WebDriver driver,WebElement ele,int index)
{
	Select sel = new Select(ele);
	sel.selectByIndex(index);
}
public static String  getScreenShot(WebDriver driver,String screenShotName) throws Throwable
{
//	JavaUtility jUtil=new JavaUtility();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	String path = "./screensot/"+screenShotName+".png";
	File perm=new File(path);
//	FileHandler.copy(temp, perm);
	String scrPath=perm.getAbsolutePath();
	FileUtils.copyFile(temp, perm);
	return scrPath;
	
}
public void scrollBarAction(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,800)", "");
}
public void scrollAction(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
	jse.executeScript("window.scrollBy(0+"+y+")", element);
}
public void scrollDownTillBottomOfThePage(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("document.scrollBy(0,document.body.scrollHeight)");
}
public void scrollTillEleToBeVisible(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].scrollIntoView()", element);
}
public void clickOnElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click()", element);
}
public void jseUsingSendKeys(WebDriver driver,WebElement element,String expData)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("argument[0].value=argument[1]", element,expData);
}
public void scrollUpTillElementToBeVisible(WebDriver driver,WebElement element)
{
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	Point loc = element.getLocation();
	int x=loc.getX();
	int y=loc.getY();
	jse.executeScript("window.scrollBy("+x+","+y+")");
}

}
