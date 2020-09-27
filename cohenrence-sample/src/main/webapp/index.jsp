<%@ page import="java.net.UnknownHostException" %>
<%@ page import="java.net.InetAddress" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<body>
<h2>Coherence Sample</h2>
    <%
      String hostname, serverAddress;
      hostname = "error";
      serverAddress = "error";
      try {
        InetAddress inetAddress;
        inetAddress = InetAddress.getLocalHost();
        hostname = inetAddress.getHostName();
        serverAddress = inetAddress.toString();
      } catch (UnknownHostException e) {

        e.printStackTrace();
      }
    %>

    <li>InetAddress: <%=serverAddress %>
    <li>InetAddress.hostname: <%=hostname %>

<br/> <br/>
<br/> <br/>
<a href="addSession.jsp"> Add Session</a> 
<br/> <br/>    
<a href="TestSessionServlet"> Test Session </a> 
<br/> <br/>
<a href="Logout"> Logout from Session </a>
<br/>
<br/>
</body>
</html>
