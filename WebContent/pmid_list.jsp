<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.lang.Math.*" %>
<%@ page import="java.io.*" %>
<%@ page import="util.DBUtil" %>
<%@ page import="util.Pagination" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BCISearch</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
	<tr>
	
	<td width="934">
	<%
	String entity = "";
	String entityName = "";
	int nowPage = 1;
	if(request.getParameter("name") != null){
	entity=request.getParameter("entity");
	entityName=request.getParameter("name");
	//out.println(entityName);
	}else{
		out.println("entity name can not be null");
	}
%>
<%
	DBUtil db1 = new DBUtil();
	Connection conn = db1.getConnection();
	String sql1="select distinct pmid from entity where type = ? and name = ?";   //精准搜索
	//String sql1="select * from entity_new where name like ?";  //模糊搜索
	PreparedStatement ps1  = conn.prepareStatement(sql1);
	ps1.setString(1, entity);
	ps1.setString(2, entityName + " ");
	//ps1.setString(1, entityName);
	ResultSet rs1=ps1.executeQuery();
	Pagination pg =new Pagination();
	nowPage = Integer.parseInt(request.getParameter("page"));
	pg.getPage(rs1,request.getParameter("page"));
	int i=0;
	//***************
	
	   PreparedStatement ps2 = null;
	   ResultSet rs2 = null;
	   String temp;
	   DBUtil db2 = new DBUtil();
	   Connection conn2 = null;
	   conn2 = db2.getConnection();
		//***************
	%>
All <%=pg.a[0]%> records，<%=pg.a[1]%>，this page is <%=pg.a[2]%>
	<div>
	<div id="result"> 
	<table class="table table-bordered">
   <caption>All the pmid which includes the entity <%=entityName %></caption>
   <thead>
      <tr class="success">
         <th>PubMed ID</th>
         <th>Title</th>
         <th>Abstract</th>
      </tr>
   </thead>
   <tbody>
	<%
	while(i<pg.intPageSize && !rs1.isAfterLast()) //检索指针是否位于此 ResultSet 对象的最后一行之后
	{
		String sql2 = "select Pmid,Title,Text from corpus where Pmid = ?";
		ps2  = conn2.prepareStatement(sql2);
		temp = rs1.getString("pmid");
		ps2.setString(1, temp);
		rs2 = ps2.executeQuery();
		rs2.next();
	%>
		<tr>
		<td><a href="text.jsp?id=<%=rs1.getString("pmid") %>"><%=rs1.getString("pmid") %></a></td>
		<td><%=rs2.getString("title") %></td>
		<td><%=rs2.getString("Text") %></td>
		</tr>
	<% 
	rs1.next();
	i++;
	}
	db2.close(conn2, ps2, rs2);
	db1.close(conn, ps1, rs1);
   %>
  
   </tbody>
   </table>
   </div>
	<div id="2" align="center">
	<ul class="pagination">
	<li>
      <a href="pmid_list.jsp?entity=<%=entity%>&name=<%=entityName %>&page=<%=nowPage-1%>" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
	<%
	int max =nowPage + 15;
	for(int j=nowPage;j<max;j++) //pg.a[1]
	{
		out.print("&nbsp&nbsp;<li><a href=pmid_list.jsp?entity="+ entity + "&page=" + j + "&name="+ entityName +  ">"+j+"</a></li>");
	}
	%>
	<li>
      <a href="pmid_list.jsp?entity=<%=entity%>&name=<%=entityName %>&page=<%=nowPage+1%>" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
	</ul>
	</div>
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
  <script type="text/javascript">
	function keyLight(id, key, bgColor){
		  var oDiv = document.getElementById(id),
		      oChilds  = oDiv.childNodes,
		      bgColor = bgColor || "orange",
		       sKey = "<span style='background-color: "+bgColor+";'>"+key+"</span>",
		       rStr = new RegExp(key, "g");
		   for(var i =0; i<oChilds.length-1; i++){
		     if(oChilds[i].nodeType == 3 && /\s/.test(oChilds[i].nodeValue)){  //删除空白的节点
		       oChilds[i].parentNode.removeChild(oChilds[i]);
		     }
		      oChilds[i].innerHTML = oChilds[i].innerHTML.replace(rStr,sKey);  //替换key
		   }
		}
		var a ="<%=entityName%>"
		var key1 = keyLight('result', a);
	</script>
  <script src="js/jquery-1.11.1.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  </body>
</html>