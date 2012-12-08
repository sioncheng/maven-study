package org.sonatype.mavenbook.weather.yahoo;

import java.io.InputStream;

import org.junit.Test;
import static org.junit.Assert.*;


import org.sonatype.mavenbook.weather.Weather;
import org.sonatype.mavenbook.weather.YahooParser;

public class YahooParserTest {
	
	@Test
	public void testParse() throws Exception{

		InputStream nyData =
			getClass().getClassLoader().getResourceAsStream("ny-weather.xml"); 

		Weather weather = new YahooParser().parse( nyData );
		
		assertEquals( "New York", weather.getCity() );
		assertEquals( "NY", weather.getRegion() );
		assertEquals( "US", weather.getCountry() ); 
		assertEquals( "39", weather.getTemperature() ); 
		assertEquals( "Fair", weather.getCondition() ); 
		assertEquals( "39", weather.getChill() ); 
		assertEquals( "67", weather.getHumidity() );
	}
}