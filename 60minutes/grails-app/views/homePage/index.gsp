<!DOCTYPE html>
<html>
  <head>
    <title>60 minutes</title>
  </head>
  <body>

      <g:each in="${books}" var="book">
          <div class="book">
              <div class="title">${book.title}</div>
              <div class="author">${book.author}</div>
          </div>
      </g:each>

  </body>
</html>