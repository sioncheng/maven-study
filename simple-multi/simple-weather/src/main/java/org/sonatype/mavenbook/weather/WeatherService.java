package org.sonatype.mavenbook.weather;


import java.io.InputStream;

public class WeatherService {
	
	public String retrieveForecast(String zipcode)
		throws Exception{

		InputStream dataIn = (new YahooRetriever()).retrieve(zipcode);
		Weather weather = (new YahooParser()).parse(dataIn);
		String result = (new WeatherFormatter()).format(weather);

		return result;
	}
}