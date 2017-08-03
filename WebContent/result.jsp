<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="util.RecognizeOnline" %>
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
	  <li role="presentation"><a href="index.jsp">Home</a></li>
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
	String text= "";
	int nowPage = 1;
	if(request.getParameter("text") != null){
	text=request.getParameter("text");
	//out.println(entityName);
	}else{
		out.println("entity name can not be null");
	}
	String text1="";
	
	try{
	text1 = RecognizeOnline.parser(text);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	%>
	
	
	<tr><td width="934">
	<div class="jumbotron">
 	 <%=text1 %>
 	 </div>
	</td></tr>
	<tr><td>
	<a class="btn btn-default" href="./recognition.jsp" role="button">Go Back</a>
	</td></tr>
	<tr>
	<td align="center">
		<p>Copyright © College of Computer Science & Technology, Nanjing University of Posts and Telecommunications
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
