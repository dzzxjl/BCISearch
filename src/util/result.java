package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class result
 */
@WebServlet("/result")
public class result extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String text =  request.getParameter("text"); 
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String a = "";
		try {
			a = RecognizeOnline.parser(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(entity);
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><title>result</title>");
		out.println("<link href=\"css/bootstrap.min.css\"rel=\"stylesheet\">");
		out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
		out.println("<BODY>");
		out.println("<div class=\"container\"><table align=\"center\"><tr><td align=\"center\"><img alt=\"home.jpg\" src=\"img/home2.jpg\"></td></tr><tr><td><ul class=\"nav nav-pills\"><li role=\"presentation\"><a href=\"index.jsp\">Home</a></li><li role=\"presentation\"><a href=\"staticInfo.jsp\">Static Information</a></li><li role=\"presentation\"><a href=\"dynamicInfo.jsp\">Dynamic Information</a></li><li role=\"presentation\"><a href=\"recognition.jsp\">Entity Recognition</a></li><li role=\"presentation\"><a href=\"doc.html\">Documentation</a></li> <li role=\"presentation\"><a href=\"corpus.jsp\">Corpus</a></li><li role=\"presentation\"><a href=\"ablout.html\">About</a></li></ul></td></tr>");
		out.println("<tr><td width=\"934\">");
		out.println("<div class=\"jumbotron\">");
		out.print(a);
		System.out.println(a);
		out.println("</h1></div>");
		out.println("</td></tr>");
		out.println("<tr><td><a class=\"btn btn-default\" href=\"./recognition.jsp\" role=\"button\">Go Back</a></td></tr>");
		out.println("<tr><td align=\"center\"><p>Copyright © College of Computer Science & Technology, Nanjing University of Posts and Telecommunications<img src=\"img/logo.png\" width=\"50\" height=\"50\"></p></td></tr></table></div></body></html>");
	
	}


}
