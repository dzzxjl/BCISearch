<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.Math.*" %>
<%@ page import="java.io.*" %>
<%@ page import="util.DBUtil" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dynamic Information</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<script src="js/echarts.js"></script>
	<script src="js/echarts-all.js"></script>
  </head>
  <body>
    <div class="container">
	<table align="center">
	<tr>
	<td align="center">
	<img alt="home.jpg" src="img/home2.jpg">
	</td>
	</tr>
	<tr>
	<td>
	<ul class="nav nav-pills">
	  <li role="presentation"><a href="index.jsp">Home</a></li>
	  <li role="presentation"><a href="staticInfo.jsp">Static Information</a></li>
	  <li role="presentation" class="active"><a href="dynamicInfo.jsp">Dynamic Information</a></li>
	  <li role="presentation"><a href="dependency.jsp">Dependency</a></li>
	  <li role="presentation"><a href="recognition.jsp">Entity Recognition</a></li>
	  <li role="presentation"><a href="doc.html">Documentation</a></li> 
	  <li role="presentation"><a href="corpus.jsp">Corpus</a></li>
	  <li role="presentation"><a href="ablout.html">About</a></li> 	
	</ul>
	</td>
	</tr>
	<tr>
	<td width="934">
	<br>
	<h2>Relationship Graph</h2>
	<div id="main" style="height:600px"></div>
	</td>
	</tr>
	<tr><td><h2>Relationship Table</h2></td></tr>
	<tr>
	<td align="center">
	<div>
	<table class="table table-bordered">
	<thead>
      <tr class="success">
         <th>Entity1</th>
         <th>Entity2</th>
         <th>Weight</th>
      </tr>
   </thead>
	<% 
	DBUtil db = new DBUtil();
	Connection conn = db.getConnection();
	String sql="select source,target,weight from ARN order by weight desc";
	Statement sm = conn.createStatement();
	ResultSet rs=sm.executeQuery(sql);
	rs.next();
	%>
	<% 
	int i = 0;
	while(rs.next()) //检索指针是否位于此 ResultSet 对象的最后一行之后
	{
	%>
		<tr>
		<td><%=rs.getString("source") %></td>
		<td><%=rs.getString("target") %></td>
		<td><%=rs.getInt("weight") %></td>
		</tr>
	<% 
	//rs.next();
	//i++;
	}
	db.close(conn, sm, rs);
	%>
	</table>
	</div>
	</td></tr>
	
	
	
	<tr>
	<td align="center">
		<p>Copyright © College of Computer Science & Technology, </p>
		<p>Nanjing University of Posts and Telecommunications
		<img alt="" src="img/logo.png" width="50" height="50">
		</p>
	</td>
	</tr>
	</table>
    
   
  </div>
  <script src="js/relationship.js"></script>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>