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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAROBIDY
 */
public class Destination {
    int id;
    String nom;
    String description;
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   

    public Destination(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
       
    }

    public Destination(String nom, String description) {
        this.nom = nom;
        this.description = description;
       
    }
    
      public void insererdestination() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO destination(id, nom,description) VALUES (default, ?,?)");
            statement.setString(1, this.getNom());
            statement.setString(2, this.getDescription());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
        
     }
     
      public static List<Destination> recupererDestination() throws Exception {
        List<Destination> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM destination");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String desc = resultSet.getString("description");
                
               Destination activite = new Destination(id, nom,desc);
                activites.add(activite);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
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
        
        return activites;
    }
      
      
   
      public void modifierDestination() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("UPDATE destination SET nom = ? and SET  description = ?  WHERE id = ?");
        statement.setString(1, this.getNom());
        statement.setString(2, this.getDescription());
        statement.setInt(3, this.getId());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
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
}

      public void supprimerDestination(int id) throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("DELETE FROM destination WHERE id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
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
}
    
}
