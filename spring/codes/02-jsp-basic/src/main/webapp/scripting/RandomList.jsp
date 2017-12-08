<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
\
<HTML>
<HEAD>
<TITLE>Random List (Version 1)</TITLE>
</HEAD>
<BODY>
<H1>Random List (Version 1)</H1>
<UL>
<% 
int numEntries = jsp.basic.scripting.RanUtilities.randomInt(10);
for(int i=0; i<numEntries; i++) {
  out.println("<LI>" + jsp.basic.scripting.RanUtilities.randomInt(10));
}
%>
</UL>
</BODY></HTML>