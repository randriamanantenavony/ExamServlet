/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SAROBIDY
 */
public class Authentification {
    String email;
    String mdp;

    public Authentification(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getMmail() {
        return email;
    }

    public void setMmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
      public int getId() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int id = 0;
        try {
             
            conn = DbConnection.getConnection();
            System.out.println("coucou");
            statement = conn.prepareStatement("SELECT id FROM administrateur WHERE mail = ? AND mdp = ?");
            statement.setString(1, email);
            statement.setString(2, mdp);
            result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return id;
}

}
