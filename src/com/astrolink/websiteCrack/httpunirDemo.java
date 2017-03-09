package com.astrolink.websiteCrack;

import java.io.IOException;
import java.net.MalformedURLException;

import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class httpunirDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testPostMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 用post方法获取页面内容
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void testPostMethod() throws MalformedURLException, IOException, SAXException {
		WebClient client = new WebClient(BrowserVersion.INTERNET_EXPLORER_7);
		client.setJavaScriptEnabled(true); // 默认执行js，如果不执行js，则可能会登录失败，因为用户名密码框需要js来绘制。
		client.setCssEnabled(false);
		client.setAjaxController(new NicelyResynchronizingAjaxController());
		client.setThrowExceptionOnScriptError(false);

		HtmlPage page = client.getPage("http://218.206.191.22/prm/portal/login_inner.jsp");
		 System.out.println(page.toString());
		 System.out.println(page.asText());
		// 登录
		HtmlInput ln = page.getHtmlElementById("loginName");
		ln.setAttribute("value", "北京艾思通无限数码科01");
		
		HtmlInput pwd = page.getHtmlElementById("password");
		pwd.setAttribute("value", "Ast12345");
		
		HtmlInput btn = page.getHtmlElementById("loginButton");
		//HtmlInput btn = page.getFirstByXPath(".//*[@id='vForm']/div[3]/ul/li[6]/div[2]/input");

	
		

		HtmlPage page2 = btn.click();
		// 登录完成，现在可以爬取任意你想要的页面了。
		System.out.println(page2.asText());

		//HtmlPage page3 = client.getPage("http://weibo.com/friends?leftnav=1&wvr=5&isfriends=1&step=2");
		//System.out.println(" : " + page3.asXml());

		client.closeAllWindows();
	}
}
