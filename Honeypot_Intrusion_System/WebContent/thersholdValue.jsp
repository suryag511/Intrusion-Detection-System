<%@ page language="java" contentType="text/html; charset=windows-1252" pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.SocketException"%>
<%@page import="java.net.UnknownHostException"%>

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
<form method="post" action="thresholdController">
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.html">Honeypot Intrusion</a></h1>
          <h1><a href="index.html"> System<span class="logo_colour"></span></a></h1>
        </div>
</div>
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
		<table width="529" height="351" border="0" align="right">
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><h1 align="center">Protocol Generator</h1></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><table width="366" height="288" border="1" bgcolor="#AA7FAA" align="right">
            <tr>
              <td width="109">Name</td>
              <td width="139"><input type="text" name="cname" required></td>
            </tr>
            <tr>
              <td>Upload Size</td>
              <td><select name="u_Size">
  <option value="500KB">500KB</option>
  <option value="1MB">1MB</option>
  <option value="5MB">5MB</option>
  </select></td>
            </tr>
            <tr>
              <td>Download Size</td>
              <td><select name="d_Size">
  <option value="1MB">1MB</option>
  <option value="5MB">5MB</option>
  <option value="10MB">10MB</option>
  </select>
  </td>
            </tr>
                        <tr>
              <td>&nbsp;</td>
              <td><input type="submit" name="Submit" value="Submit">
              <input type="reset" name="Submit2" value="Reset"></td>
            </tr>
                  </table> </td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

        
        
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      
    </div>
  </div>
  </form>
</body>
</html>
