<!DOCTYPE html>
<html>
  <head>
    <title>60 minutes</title>
  </head>
  <body>

      <g:each in="${books}" var="book">
          <div class="book">${book.title}</div>
      </g:each>

  </body>
</html>