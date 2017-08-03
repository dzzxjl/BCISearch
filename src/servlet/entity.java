package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.*;
import java.sql.*;

/**
 * Servlet implementation class entity
 */
@WebServlet("/entity")
public class entity extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String entity =  request.getParameter("entity"); 
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//System.out.println(entity);
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("<HEAD><title>"+ entity +"</title>");
		out.println("<link href=\"css/bootstrap.min.css\"rel=\"stylesheet\">");
		out.println("<link href=\"css/style.css\" rel=\"stylesheet\">");
		out.println("<BODY>");
		out.println("<div class=\"container\"><table align=\"center\"><tr><td align=\"center\"><img alt=\"home.jpg\" src=\"img/home2.jpg\"></td></tr><tr><td><ul class=\"nav nav-pills\"><li role=\"presentation\"><a href=\"index.jsp\">Home</a></li><li role=\"presentation\"><a href=\"staticInfo.jsp\">Static Information</a></li><li role=\"presentation\"><a href=\"dynamicInfo.jsp\">Dynamic Information</a></li><li role=\"presentation\"><a href=\"recognition.jsp\">Entity Recognition</a></li><li role=\"presentation\"><a href=\"doc.html\">Documentation</a></li> <li role=\"presentation\"><a href=\"corpus.jsp\">Corpus</a></li><li role=\"presentation\"><a href=\"ablout.html\">About</a></li></ul></td></tr>");
		out.println("<tr><td>");
		out.println("<div class=\"jumbotron\"><h1>" + entity + "</h1></div>");
		out.println("<tr><td><a class=\"btn btn-default\" href=\"./staticInfo.jsp\" role=\"button\">Go Back</a></td></tr>");
		DBUtil db = new DBUtil();
		Connection conn = db.getConnection();
		out.println("<tr><td width=\"934\">");
		out.println("<div><table class=\"table table-bordered \"><caption>  </caption><tr class=\"success\"><th>id</th><th>name</th><th>amount</th></tr><tr>");
		Pagination pg = new Pagination();
		String sql = "";
		switch (entity) {
		case "protein":
			sql = "select * from protein where id <= 500 order by amount DESC";
			break;
		case "virus":
			sql = "select * from virus where id <= 500 order by amount DESC";
			break;
		case "dna":
			sql = "select * from dna where id <= 500 order by amount DESC";
			break;
		case "rna":
			sql = "select * from rna where id <= 500 order by amount DESC";
			break;
		case "cell_line":
			sql = "select * from cell_line where id <= 500 order by amount DESC";
			break;
		case "cell_type":
			sql = "select * from cell_type where id <= 500 order by amount DESC";
			break;
		default:
			break;
		}
		try {
//		PreparedStatement ps  = conn.prepareStatement(sql);
//		ps.setString(1, entity);
//		ResultSet rs=ps.executeQuery();
		Statement stat = conn.createStatement();
		ResultSet rs;
		rs = stat.executeQuery(sql);
		pg.getPage(rs, request.getParameter("page"));
		int i=0;
		while(i<pg.intPageSize && !rs.isAfterLast()) //检索指针是否位于此 ResultSet 对象的最后一行之后
		{
			out.println("<tr><td>"+ rs.getInt("id") +"</td>");
			out.println("<td>"+ "<a href=\"./pmid_list.jsp?entity="+ entity +"&name="+rs.getString("name")+"&page=1"+"\">" +rs.getString("name")+"</a></td>");
			out.println("<td>" + rs.getInt("amount") + "</td></tr>");
			rs.next();
			i++;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</table></div></td></tr><tr><td><div id=\"2\" align=\"center\">All "+ pg.a[0]+"records,divide into "+pg.a[1]+" pages,this page is "+pg.a[2]+"<ul class=\"pagination\">");
		out.println();
		for(int j=1;j<=pg.a[1];j++)
		{
			out.print("&nbsp&nbsp;<li><a href='entity.do?entity="+ entity +"&page="+j+"'>"+j+"</a></li>");
		}
		out.println("</td></tr>");
		out.println("<tr><td align=\"center\"><p>Copyright © College of Computer Science & Technology, Nanjing University of Posts and Telecommunications<img src=\"img/logo.png\" width=\"50\" height=\"50\"></p></td></tr></table></div></body></html>");
	
	}

}