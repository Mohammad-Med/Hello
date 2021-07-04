package com.med.hello;

import java.io.IOException;
import java.sql.SQLException;

import com.med.buss.CatalogBrowser;
import com.med.buss.User;

import db.DAOcontext;
import db.Userdb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
@WebServlet(urlPatterns = "/login" ,loadOnStartup = 1)
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		   	DAOcontext.init(this.getServletContext());

	}
    public login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		/*String login=request.getParameter("login");String password=request.getParameter("pass");
		if(login==null) login="";
		if(password==null) password="";*/
		
		HttpSession session = request.getSession(true);
		request.setAttribute("login", "");
		request.setAttribute("pass", "");
		request.setAttribute("error", "");
		/*session.setAttribute("login", "");
		session.setAttribute("password", "");*/
		request.getRequestDispatcher("/login.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login=request.getParameter("login");String password=request.getParameter("pass");
		//HttpSession session = request.getSession(true);
		request.setAttribute("login", login);
		request.setAttribute("pass", password);
		User connectedUser=null;;
		try {
			connectedUser = Userdb.isValidLogin( login, password );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connectedUser!=null) {
            HttpSession session = request.getSession( true );
            session.setAttribute( "connectedUser", connectedUser );
            session.setAttribute( "catalogBrowser", new CatalogBrowser() );
            request.getRequestDispatcher( "/viewarticles.jsp" ).forward( request, response );

		}
		else {
			request.setAttribute( "error", "Bad identity" );         
            request.getRequestDispatcher( "/login.jsp" ).forward( request, response );
		}
	}

}
