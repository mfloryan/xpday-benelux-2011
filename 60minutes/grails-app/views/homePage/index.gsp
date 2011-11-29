<!DOCTYPE html>
<html>
  <head>
    <title>60 minutes</title>
  </head>
  <body>
      <g:each in="${books}" var="book">
          <div class="book">
              <g:form name="LikeForm" url="[controller:'homePage',action:'like']" method="post">
                  <g:hiddenField name="id" value="${book?.id}"/>
                  <div class="title">${book.title}</div>
                  <div class="author">${book.author}</div>
                  <div class="likes">${book.likes} Likes</div>
                  <g:submitButton name="Submit" value="Like"/>
              </g:form>
          </div>
      </g:each>

  </body>
</html>