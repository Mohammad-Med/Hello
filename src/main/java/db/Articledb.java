package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.med.buss.Article;

public class Articledb extends DAOcontext{

	public static int getArticleCount() {
        try ( Connection connection = DriverManager.getConnection( urldb, logindb, "" ) ){

            String strSql = "SELECT count(id) FROM articles";
            try ( Statement statement  = connection.createStatement() ) {
                try ( ResultSet resultSet = statement.executeQuery( strSql ) ) {
                    resultSet.next();
                    return resultSet.getInt( 1 );
                }
            }
            
        } catch ( Exception exception ) {
            
            throw new RuntimeException( exception );
            
        }
    }
    
    public static Article getArticleById( int idArticle ) {
        try ( Connection connection = DriverManager.getConnection( urldb, logindb, "" ) ){
            String strSql = "SELECT * FROM articles WHERE id=?";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
                statement.setInt( 1, idArticle );
                try ( ResultSet resultSet = statement.executeQuery() ) {
                    resultSet.next();
                    return new Article(
                            resultSet.getInt( "id" ),
                            resultSet.getString( "description" ),
                            resultSet.getString( "brand" ),
                            resultSet.getDouble( "prix" )
                    );
                }
            }
            
        } catch ( Exception exception ) {
            
            throw new RuntimeException( exception );
            
        }
    }
    
    
    public static void updateArticle( Article article ) {
        try ( Connection connection = DriverManager.getConnection( urldb, logindb, "") ){

            String strSql = "UPDATE articles SET description=?, brand=?, prix=? WHERE id=?";
            try ( PreparedStatement statement  = connection.prepareStatement( strSql ) ) {
                statement.setString( 1, article.getDescription() );
                statement.setString( 2, article.getBrand() );
                statement.setDouble( 3, article.getUnitaryPrice() );
                statement.setInt( 4, article.getIdArticle() );
                statement.executeUpdate();
            }
            
        } catch ( Exception exception ) {
            
            throw new RuntimeException( exception );
            
        }
    }
}
