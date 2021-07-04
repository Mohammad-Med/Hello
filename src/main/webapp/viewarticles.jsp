<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>View article</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <h1>View article - ${connectedUser.login}</h1>
        <br/>
       
        Identifier: ${catalogBrowser.currentArticle.idArticle} <br/>
        Brand: ${catalogBrowser.currentArticle.brand} <br/> 
        Description: ${catalogBrowser.currentArticle.description} <br/>
        Unitary price: ${catalogBrowser.currentArticle.unitaryPrice} <br/>
        <br/>
        
        <form action="article" method="post">
            <input name="btnPrevious" type="submit" value="Previous" />
            &nbsp; &nbsp;
            <input name="btnNext" type="submit" value="Next" />
        </form>  <br/>
        
       
    </body>
</html>