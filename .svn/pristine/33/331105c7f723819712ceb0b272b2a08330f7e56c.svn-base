package com.astrolink.util.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTools {

	/**
	 * 等待alert对话框弹出，并关闭对话框
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public static void waitForAlertAndCloseAlert(WebDriver driver, int sleep, int retryNum) throws InterruptedException {
		int i = 0;
		while (i++ < retryNum) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				break;
			} catch (NoAlertPresentException e) {
				Thread.sleep(sleep);
				continue;
			}
		}
		if (i == (retryNum+1)) {
			throw new NoAlertPresentException();
		}
	}

	/**
	 * 重试获取获取节点
	 * 
	 * @param driver
	 * @param selector
	 * @param sleep
	 *            等待时间
	 * @param retryNum
	 *            重试次数
	 * @return
	 */
	public static WebElement getWebElement(WebDriver driver, By selector, int sleep, int retryNum) {
		try {
			for (int i = 0; i < retryNum; i++) {
				WebElement element = SeleniumTools.getWebElement(driver, selector, sleep);
				if (element != null) {
					return element;
				}
				Thread.sleep(sleep);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * . 等待制定时间获取节点
	 * 
	 * @param driver
	 * @param selector
	 * @param sleep
	 *            等待时间
	 * @return
	 */
	public static WebElement getWebElement(WebDriver driver, By selector, int sleep) {

		try {
			//WebElement element = (new WebDriverWait(driver, sleep).until(new ExpectedCondition<WebElement>() {
				//@Override
				//public WebElement apply(WebDriver driver) {
					return getWebElement(driver, selector);
				//}
			//}));
			//return element;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// 编译的时候需要打开上面注释
		// return null;
	}

	/**
	 * 获取节点
	 * 
	 * @param driver
	 * @param selector
	 * @return
	 */
	public static WebElement getWebElement(WebDriver driver, By selector) {
		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
