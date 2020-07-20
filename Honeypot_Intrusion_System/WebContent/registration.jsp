<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.InetAddress"%>
<%@page import="java.net.NetworkInterface"%>
<%@page import="java.net.SocketException"%>
<%@page import="java.net.UnknownHostException"%>
<%
StringBuilder sb = new StringBuilder();
InetAddress ip;
try {
	ip = InetAddress.getLocalHost();
	
	NetworkInterface network = NetworkInterface.getByInetAddress(ip);
	byte[] mac = network.getHardwareAddress();
	System.out.print("MAC address : ");

	
	for (int i = 0; i < mac.length; i++) {
		sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
	}
	System.out.println(sb.toString());
} catch (UnknownHostException e) {
	
	e.printStackTrace();
	
} catch (SocketException e){
		
	e.printStackTrace();
		
}
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
<form method="post" action="registrationController">
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
    <td><h1 align="center">Registration</h1></td>
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
              <td>Password</td>
              <td><input type="password" name="pwd" required></td>
            </tr>
            <tr>
              <td>Gender</td>
              <td><select name="gender">
  <option value="male">Male</option>
  <option value="female">Female</option>
  </select></td>
            </tr>
            <tr>
              <td>Mac Address </td>
              <td><input type="text" name="mac_address" value="<%=sb.toString()%>"></td>
            </tr>
            <tr>
              <td>E-mail</td>
              <td><input type="text" name="mail"></td>
            </tr>
            <tr>
              <td>Mobile No </td>
              <td><input type="text" name="mobileNo"></td>
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
