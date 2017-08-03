<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Recognition</title>
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
	  <li role="presentation" class="active"><a href="recognition.jsp">Entity Recognition</a></li>
	  <li role="presentation"><a href="doc.html">Documentation</a></li> 
	  <li role="presentation"><a href="corpus.jsp">Corpus</a></li>
	  <li role="presentation"><a href="about.html">About</a></li> 	
	</ul>
	</td>
	</tr>
	<tr>
	
	<td width="934">
	<form role="form" action="result.do" method="get">
	  <div class="form-group">
	  <label for="name">Input Text</label>
	  <textarea name="text" class="form-control" rows="10"></textarea>
	  <br>
	  <button class="btn btn-default" type="submit">Submit</button>
	  </div>
	  </form>
	</td>
	</tr>
	
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