<%@ page isErrorPage = "true" %>

<html>
   <head>
      <title>Show Error Page</title>
   </head>
   
   <body>
      <h1>Opps...</h1>
      <p>Sorry, an error occurred.</p>
      <p>Here is the exception: </p>
      <pre><%= exception.getMessage() %></pre>
   </body>
</html>