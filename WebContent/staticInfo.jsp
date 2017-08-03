<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Static Information</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
	<script src="js/jquery-1.11.1.min.js"></script>
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
	  <li role="presentation" class="active"><a href="staticInfo.jsp">Static Information</a></li>
	  <li role="presentation"><a href="dynamicInfo.jsp">Dynamic Information</a></li>
	  <li role="presentation"><a href="dependency.jsp">Dependency</a></li>
	  <li role="presentation"><a href="recognition.jsp">Entity Recognition</a></li>
	  <li role="presentation"><a href="doc.html">Documentation</a></li> 
	  <li role="presentation"><a href="corpus.jsp">Corpus</a></li>
	  <li role="presentation"><a href="about.html">About</a></li> 	
	</ul>
	</td>
	</tr>
	
	<tr><td align="center">
	<br>
	<p>This graph shows the number of types of entities we recognize.</p>
	<div id="main" style="height:300px ;width:700px"></div>
	</td></tr>
	<tr><td align="center">
	<br>
	<p>Select entity type,see the number of entities that are identified,and view the contents of the paper according to the entity name.</p>
	<form action="entity.do" method="get">
	<select name= "entity">
		<option value= "protein" selected ="selected">Protein</option >
		<option value= "dna">DNA</option>
		<option value= "rna">RNA</option >
		<option value= "virus">Virus</option>
		<option value= "cell_line">Cell_line</option>
		<option value= "cell_type">Cell_type</option>
	</select>
	<button type="submit" class="btn btn-default control-label">submit</button>
	</form>
	<hr>
	</td></tr>
	<tr>
	<td align="center">
	<form role="form" align="center" class="form-inline" action="allEntity.jsp?page=1" method="post">
	   <div class="form-group">
	      <label for="name" class="control-label">Search For an entity</label>
	      <input type="text" class="form-control control-label" name="name" placeholder="Please input the name">
	   	  <button type="submit" class="btn btn-default control-label">submit</button>
	   </div>
	</form><hr><br></td></tr>
	<tr><td align="center">
	<form role="form" align="center" class="form-inline" action="text.jsp" method="post">
	   <div class="form-group">
	      <label for="name" class="control-label">Search by PMID</label>
	      <input type="text" class="form-control control-label" name="id" placeholder="Please input the PMID">
	   	  <button type="submit" class="btn btn-default control-label">submit</button>
	   </div>
	</form>
	<hr><br>
	</td>
	</tr>
		
	<tr>
	<td align="center">
		<p>Copyright © College of Computer Science & Technology, Nanjing University of Posts and Telecommunications
		<img alt="" src="img/logo.png" width="50" height="50">
		</p>
	</td>
	</tr>
	</table>
    
   
  </div>
  <script src="js/show.js"></script>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>