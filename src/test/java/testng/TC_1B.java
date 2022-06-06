package testng;

import org.testng.annotations.Test;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import datos.*;
public class TC_1B {
	
	WebDriver driver = null;
	String name = "TC_1B";
	configuraciones con=new configuraciones();
	int timmer =1000;
	String appPage = "https://www.claroplay.com/pe/";
	
	  @Test
	  public void google() throws InterruptedException, IOException {
		//creacion carpeta y conexion con chromium
			con.carpeta(name);
			System.setProperty("webdriver.chrome.driver",con.getchromiumurl());
			driver = new ChromeDriver(); //To create a new instance of Chrome
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //espere implicita
		//CUERPO  
			driver.get(appPage); //abrir sitio
			Thread.sleep(timmer);
			driver.manage().window().maximize(); //maximisar
			driver.findElement(By.className("redirect-to-login-link")).click();
			con.carpeta(name);
			Thread.sleep(timmer);
			con.captura(driver, "creaalgob", name);
		//CERRAR
			con.cerrar(driver, name);
	  }


	}