package jsp.basic.customtag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class DetailsTag extends SimpleTagSupport {
   //StringWriter object
   StringWriter sw = new StringWriter();

   public void doTag() throws JspException, IOException
   {
       getJspBody().invoke(sw);
       JspWriter out = getJspContext().getOut();
       out.println(sw.toString()+" and name != 'john'");
   }
}