package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import org.apache.log4j.PropertyConfigurator;

public class Main{

	public static void main(String[] args) 
		throws Exception{

		PropertyConfigurator.configure(Main.class.getClassLoader().getResourceAsStream("log4j.properties"));
		
		String zipcode = "60202";

		if(args.length > 0){
			zipcode = args[0];
		}

		(new Main(zipcode)).start();
	}

	private Main(String zipcode){
		this.zipcode = zipcode;
	}

	private String zipcode;
	private void start() throws Exception{

		InputStream dataIn = (new YahooRetriever()).retrieve(zipcode);

		Weather weather = (new YahooParser()).parse(dataIn);

		System.out.println((new WeatherFormatter()).format(weather));
	}
}