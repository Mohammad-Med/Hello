package db;

import jakarta.servlet.ServletContext;

public class DAOcontext {

   
	protected static String urldb;
	protected static String logindb;
	
	public static void init( ServletContext context) {
		
		try {
			Class.forName(context.getInitParameter("driver"));
			urldb=context.getInitParameter("url");
			logindb=context.getInitParameter("login");
			System.out.println("database connection "+context.getInitParameter("driver")+urldb+" "+logindb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
