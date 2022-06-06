package datos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class configuraciones {

	private String chromiumurl = "./chromedriver.exe";
	private String status ="./status//";
	private File directorio;
	private int contador = 0;
	private String fech;
	//private String status ="C:\\Users\\User\\Desktop\\LENON\\programacion\\Spring\\reportes\\abc.png";
	//C:\Users\User\Desktop\LENON\Empleo\EMPRESA2\SeleniumChrome\chromedriver.exe
	
	
	
	
	
	 public String getchromiumurl() {
	        return chromiumurl;
	    }
	 
	 public void carpeta(String name) {
		 //consigue hora y fecha
		 LocalDateTime dateTime = LocalDateTime.now(); //hora
		 DateTimeFormatter fmt12 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss:SSS");
	     String dateStr = dateTime.format(fmt12);
		 String ano = dateStr.substring(0,10);
		 String hora = dateStr.substring(11,13);
		 String minutos = dateStr.substring(14,16);
		 String fechaFinal= ano+"_H"+hora+"_M"+minutos;
		 System.out.print("La fecha"+fechaFinal);
		 fech = fechaFinal;
		 //crea carpeta
		 status = status+name+"//";
		 System.out.print("\n status");
		 directorio = new File(status+name+"_"+fech);
		 directorio.mkdir();
	 }
	 
	 public void cerrar(WebDriver driver, String name) throws IOException {
		 System.out.print("\n ---Inicializar captura--");
		 contador++;
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Hay que concatenjar
		 String status2 = status+name+"_"+fech+"//"+contador+"_"+name+"_finalizado.png";
		 FileUtils.copyFile(scrFile, new File(status2));
		
		//CERRAR
		driver.close();
		driver.quit();
		System.out.print("\n ---finalizo correctamente--");
	 }
	 
	 public void captura(WebDriver driver, String name, String nameCarpeta) throws IOException {
		//STATUS DEL CASO
		 System.out.print("\n ---Inicializar captura--");
		 contador++;
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Hay que concatenjar
		 String status2 = status+nameCarpeta+"_"+fech+"//"+contador+"_"+name+"_Captura.png";
		 FileUtils.copyFile(scrFile, new File(status2));
	 }
	 
	 public void error(WebDriver driver, String name) throws IOException {
		//STATUS DEL CASO
		 System.out.print("\n ---Inicializar captura--");
		 contador++;
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Hay que concatenjar
		 String status2 = status+name+"_"+fech+"//"+contador+"_"+name+"_ERROR.png";
		 FileUtils.copyFile(scrFile, new File(status2));
		 
		 //FIN ERROR
		driver.close();
		driver.quit();
		System.out.print("\n ---finalizo Con error--");
	 }
	
}

