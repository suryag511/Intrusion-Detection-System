<%@ page language="java" contentType="text/html; charset=windows-1252"
pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%
BufferedReader br = null;
FileReader fr = null;
String fileName = "output.txt";


String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "intrusion";
String userid = "root";
String password = "root";
%>
<!DOCTYPE HTML>
<html>

<head>
  <title>Intrusion Detection System</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
</head>

<body>
<form method="post" action="loginController">
  <div id="main">
    <div id="header">
      <div id="logo">   <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.html">Honeypot Intrusion </a></h1>
          <h1><a href="index.html">System<span class="logo_colour"></span></a></h1>
      </div>   </div>
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li class="selected"><a href="index.html">Home</a></li>
		  <li> <a href="AdminSelection.jsp">AdminPanel</a></li>
         <li><a href="home.jsp">LogOut</a></li>
        </ul>
      </div>
    </div>
    <div id="site_content">
     
      <div id="content">
        <!-- insert the page content here -->
        <h1>HoneyPot Intrusion Detection</h1>
		<div style="overflow: auto;height: 300px; width: 920px;" id="viewDetails">
						<table width="573" border="1" align="center">
	<tr>
	<th>S.No</th>											
   <th>UserName</th>
   <th>LoggedTime</th>
   <th>Reason</th>
   
   
 </tr>

<%


try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
int i = 1;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from nonLegitimate";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<tr>
<td width="61"><%=i++ %></td>

<td width="280"><%=resultSet.getString("Name") %></td>
<td width="280"><%=resultSet.getString("LoginTime") %></td>
<td width="280"><%=resultSet.getString("Reason") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</div>

        
        
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      
    </div>
  </div>
  </form>
</body>
</html>
