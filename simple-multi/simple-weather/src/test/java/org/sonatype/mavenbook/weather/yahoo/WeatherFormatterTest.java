package org.sonatype.mavenbook.weather.yahoo;

import java.io.InputStream;

import org.junit.Test;
import org.junit.Assert;

import org.apache.commons.io.IOUtils;

import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.YahooParser;
import org.sonatype.mavenbook.weather.WeatherFormatter;

public class WeatherFormatterTest{
	
	@Test
	public void testFormat() throws Exception{

		InputStream nyData =
			getClass().getClassLoader().getResourceAsStream("ny-weather.xml"); 
		
		Weather weather = new YahooParser().parse( nyData );
		
		String formattedResult = new WeatherFormatter().format( weather ); 
		
		InputStream expected =
			getClass().getClassLoader().getResourceAsStream("format-expected.dat"); 
	
		Assert.assertEquals( IOUtils.toString( expected ).trim(),formattedResult.trim() );
	}
}