<!DOCTYPE html>
<html>
  <head>
    <title>Simple GSP page</title>
  </head>
  <body>
      <g:each in="${books}" var="book">
        <div>${book.title}</div>
      </g:each>
  </body>
</html>