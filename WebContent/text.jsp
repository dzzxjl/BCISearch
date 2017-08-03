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
    <title>text</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
  </head>
  <body>
  	<%
	String strpmid="";
	int intpmid = 0;
	if(request.getParameter("id") != null){
	strpmid=request.getParameter("id");
	intpmid=java.lang.Integer.parseInt(strpmid);
	}else{
		out.println("PMID不得为空！");
	}
	DBUtil db = new DBUtil();
	Connection conn = db.getConnection();
	String sql="select Pmid,Title,Text from corpus where Pmid = ?";
	PreparedStatement ps  = conn.prepareStatement(sql);
	ps.setString(1, strpmid);
	ResultSet rs=ps.executeQuery();
	%>
  
  
    <div class="container">
	<table align="center">
	<tr>
	<td align="center">
	<img alt="home.jpg" src="img/home2.jpg">
	</td>
	</tr>
	<tr>
	<td width="934">
	<ul class="nav nav-pills">
	  <li role="presentation" class="active"><a href="index.jsp">Home</a></li>
	  <li role="presentation"><a href="staticInfo.jsp">Static Information</a></li>
	  <li role="presentation"><a href="dynamicInfo.jsp">Dynamic Information</a></li>
	  <li role="presentation"><a href="dependency.jsp">Dependency</a></li>
	  <li role="presentation"><a href="recognition.jsp">Entity Recognition</a></li>
	  <li role="presentation"><a href=doc.html#">Documentation</a></li> 
	  <li role="presentation"><a href="corpus.jsp">Corpus</a></li>
	  <li role="presentation"><a href="about.html">About</a></li> 	
	  
	</ul>
	</td>
	</tr>
	<tr>
	<td width="934">
	<div id="legend">
	<strong>Legend:</strong>
	<ul>
		<li><span class="protein">protein</span></li>
		<li><span class="DNA">DNA</span></li>
		<li><span class="RNA">RNA</span></li>
		<li><span class="virus">virus</span></li>
		<li><span class="cell_type">cell_type</span></li>
		<li><span class="cell_line">cell_line</span></li>
	</ul>
	</div>
	
	<table class="table table-bordered">
   <caption>Result</caption>
   <thead>
      <tr class="success">
         <th>PubMed ID</th>
         <th>Title</th>
         <th>Text</th>
      </tr>
   </thead>
   <%
   while(rs.next()){
	   %>
   <tbody>
      <tr>
         <td style="text-align:center;"><%=rs.getString("Pmid") %></td>
         <td><%=rs.getString("Title") %></td>
         <td><%=rs.getString("Text") %></td>
      </tr>
   </tbody>
  <%}
   db.close(conn, ps, rs);
   %>
</table>
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
  <script type="text/javascript">
	$(document).ready(function(){
			$("b").mousemove(function(event){
				 	EVT = event || window.event;
					var x,y; 
					x = EVT.clientX; 
					y = EVT.clientY; 
					document.getElementById("Layer1").style.left = x + "px";
					document.getElementById("Layer1").style.top = y + "px"; 
					document.getElementById("Layer1").innerHTML = $(this).attr("class"); 
					document.getElementById("Layer1").style.display = "block"; 
			});
			$("b").mouseout(function(){ 
				document.getElementById("Layer1").style.display = "none"; 
				});
			
	})
	</script>
<div id="Layer1" style="left:1;top:1;display:none;position:absolute;z-index:1; 
		width: 100px;
		height: 30px; 
		background:#FFFFFF;
		border:1px solid #333;
		text-align:center;
		font-size:150%">
</div> 
  </body>
</html>