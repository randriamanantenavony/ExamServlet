/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SAROBIDY
 */
public class DbConnection {
   private static final String url = "jdbc:postgresql://localhost:5432/voyage";
    private static final String utilisateur = "postgres";
    private static final String motDePasse = "mickey";

   
    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, utilisateur, motDePasse);
        
    }
    
    public static void main(String[] args) throws Exception{
      Connection c = DbConnection.getConnection();
      if(c != null)
      {
        System.out.println("Connection reussie");
      }
      else{System.out.println("Erreur");}
    }
}

