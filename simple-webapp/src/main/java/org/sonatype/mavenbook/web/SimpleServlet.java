package org.sonatype.mavenbook.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException {

		PrintWriter output = response.getWriter();
		output.println("simple servlet");
		output.flush();
		output.close();
	}

}