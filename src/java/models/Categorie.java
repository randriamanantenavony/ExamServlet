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
public class Categorie {
    int id;
    String nomCategorie;

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Categorie(int id, String nomCategorie) {
        this.id = id;
        this.nomCategorie = nomCategorie;
    }
    
    

    public int getId() {
        return id;
    }
    
      public void setIdString(String id) {
        int id1 = Integer.parseInt(id);
        this.id = id1;
    }


    public void setId(String id) {
       setIdString(id);
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
     public void insererCategorie() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO categorie (idcategorie, nomcategorie) VALUES (default, ?)");
            statement.setString(1, this.getNomCategorie());
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
     
      public static List<Categorie> recupererCategories() throws Exception {
        List<Categorie> categories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM categorie");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("idcategorie");
                String nomCategorie = resultSet.getString("nomcategorie");
                Categorie categorie = new Categorie(id, nomCategorie);
                categories.add(categorie);
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
        
        return categories;
    }
   
      public void modifierCategorie(Categorie categorie) throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("UPDATE categorie SET nomcategorie = ? WHERE idcategorie = ?");
        statement.setString(1, categorie.getNomCategorie());
        statement.setInt(2, categorie.getId());
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

      public void supprimerCategorie(int idCategorie) throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("DELETE FROM categorie WHERE idcategorie = ?");
        statement.setInt(1, idCategorie);
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
