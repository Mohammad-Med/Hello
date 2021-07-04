package com.med.hello;

import java.io.IOException;

import com.med.buss.CatalogBrowser;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ArticleController
 */
@WebServlet("/article")
public class ArticleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
              throws ServletException, IOException {
        HttpSession session = request.getSession( true );
        if ( session.getAttribute( "connectedUser" ) == null ) {
            response.sendRedirect( "login" );
            return;
        }
        
        request.getRequestDispatcher( "/viewArticle.jsp" ).forward( request, response );
    }
    
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) 
              throws ServletException, IOException {
        HttpSession session = request.getSession( true );
        if ( session.getAttribute( "connectedUser" ) == null ) {
            response.sendRedirect( "login" );
            return;
        }

        CatalogBrowser browser = (CatalogBrowser) session.getAttribute( "catalogBrowser" );
        
        if ( request.getParameter( "btnPrevious" ) != null ) {
            browser.goPrevious();
        } else if ( request.getParameter( "btnNext" ) != null ) {
            browser.goNext();
        }
        
        request.getRequestDispatcher( "/viewarticles.jsp" ).forward( request, response );
    }

}
