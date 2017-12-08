<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Squaring Big Numbers</TITLE>
<LINK REL=STYLESHEET
      HREF="JSP-Styles.css"
      TYPE="text/css">
</HEAD>
<BODY>
<H1>Squaring Big Numbers</H1>
<%@ page import="java.math.*" %>
<% String baseNum = request.getParameter("baseNum");
   BigInteger orig;
   try {
     orig = new BigInteger(baseNum);
   } catch(Exception e) {
     orig = new BigInteger("1234567890");
   }
   BigInteger result = orig.pow(2);
%>
<H3>The square of <%= orig %> is <%= result %></H3>
</BODY></HTML>