package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.med.buss.User;

public class Userdb extends DAOcontext{

	public static User isValidLogin( String login, String password ) throws SQLException  {
		System.out.println(login+" "+password);
        try ( Connection connection = DriverManager.getConnection( urldb, logindb, "" ) ) {
           // String strSql = "SELECT * FROM T_Users WHERE login='" 
                           // + login + "' AND password='" + password + "'";
            String strSql = "SELECT * FROM users WHERE login=? AND pass=?";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
            	System.out.println("connexion");
                statement.setString( 1, login);
                statement.setString( 2, password );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    if ( resultSet.next() ) {
                        return new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("pass"), resultSet.getInt("numconnection"));
                    } else {
                        return null;
                    }
                }
            }
        } 
    }
}
