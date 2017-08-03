<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
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
    <title>BCISearch</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
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
	  <li role="presentation" class="active"><a href="index.jsp">Home</a></li>
	  <li role="presentation"><a href="staticInfo.jsp">Static Information</a></li>
	  <li role="presentation"><a href="dynamicInfo.jsp">Dynamic Information</a></li>
	   <li role="presentation"><a href="dependency.jsp">Dependency</a></li>
	  <li role="presentation"><a href="recognition.jsp">Entity Recognition</a></li>
	  <li role="presentation"><a href="doc.html">Documentation</a></li> 
	  <li role="presentation"><a href="corpus.jsp">Corpus</a></li>
	  <li role="presentation"><a href="about.html">About</a></li> 	
	</ul>
	</td>
	</tr>

<%
	String entityName="";
	String Page="";
	int nowPage = 1;
	if(request.getParameter("name") != null){
	entityName=request.getParameter("name");
	Page=request.getParameter("page");
	nowPage = Integer.parseInt(Page);
	}else{
		out.println("entity name can not be null");
	}
	DBUtil db1 = new DBUtil();
	Connection conn = db1.getConnection();
	//String sql1="select * from entity_new where name = ?";   //精准搜索
	String sql1="select distinct pmid,type from entity where name like ?";  //模糊搜索
	PreparedStatement ps1  = conn.prepareStatement(sql1);
	ps1.setString(1, entityName + "%");
	ResultSet rs1=ps1.executeQuery();
	rs1.last();
	int recordCount = rs1.getRow();
	int pageCount = (recordCount+20-1)/20;
	if( nowPage > pageCount) nowPage = pageCount;
	if(pageCount>0){
		rs1.absolute((nowPage-1)*20 +1);
		System.out.println((nowPage-1)*20 +1);
	}
	int i = 0;
	
	
%>
<tr><td>
	<div>
	<table class="table table-bordered">
   <caption><%=entityName %></caption>
   
   <%
	while(i<20){
	%>
		<tbody>
	      <tr>
	         <td><a href="text.jsp?id=<%=rs1.getString("pmid") %>"><%=rs1.getString("pmid") %></a></td>
	         <td><%=rs1.getString("type") %></td>
	      </tr>
	   </tbody>
	<% 
	i++;
	rs1.next();
	}
   db1.close(conn, ps1, rs1);
   %>
</table>
<ul class="pagination">
<%
	for(int j=1;j<15;j++) //pg.a[1]
	{
		out.print("&nbsp&nbsp;<li><a href=allEntity.jsp?name="+ entityName + "&page=" + j + ">"+j+"</a></li>");
	}
	%>
	</ul>
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
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>