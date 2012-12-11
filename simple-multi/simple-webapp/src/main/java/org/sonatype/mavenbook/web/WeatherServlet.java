package org.sonatype.mavenbook.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.sonatype.mavenbook.weather.WeatherService;

public class WeatherServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {

		String zipcode = request.getParameter("zipcode");
		WeatherService weatherService = new WeatherService();

		PrintWriter output = response.getWriter();

		try{
			String result = weatherService.retrieveForecast(zipcode);
			output.println(result);
		}
		catch(Exception e){
			output.println("failed to retrieve forecast for " + zipcode);
			output.println("<br/>");
			output.println(e.getMessage());
		}
		output.flush();
		output.close();

	}
}