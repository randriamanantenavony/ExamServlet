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





/**
 *
 * @author SAROBIDY
 */
public class OffreVoyage {
    int id;
    int idOffre;
    int idActiviteOffre;

    public int getId() {
        return id;
    }

     public void setId(String id) {
        this.id = Integer.parseInt(id);
    } 
     
    public void setId(int id) {
        this.id = id;
    }

    public int getIdOffre() {
        return idOffre;
    }

     public void setIdOffre(String idOffre) {
        this.idOffre = Integer.parseInt(idOffre);
    }

    
    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public int getIdActiviteOffre() {
        return idActiviteOffre;
    }
    
      public void setIdActiviteOffre(String idActiviteOffre) {
        this.idActiviteOffre = Integer.parseInt(idActiviteOffre);
    }

    public void setIdActiviteOffre(int idActiviteOffre) {
        this.idActiviteOffre = idActiviteOffre;
    }

    public OffreVoyage(int id, int idOffre, int idActiviteOffre) {
        this.id = id;
        this.idOffre = idOffre;
        this.idActiviteOffre = idActiviteOffre;
    }

    public OffreVoyage(int idOffre, int idActiviteOffre) {
        this.idOffre = idOffre;
        this.idActiviteOffre = idActiviteOffre;
    }
    
       public OffreVoyage(String idOffre, String idActiviteOffre) {
           setIdOffre(idOffre);
           setIdActiviteOffre(idActiviteOffre);
       
    }
    
    
    
       public void insererOffre() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO offreactivite (id, idvoyage,idactivite) VALUES (default, ?,?)");
            statement.setInt(1, this.getIdOffre());
            statement.setInt(2, this.getIdActiviteOffre());
            
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
     
      public static List<OffreVoyage> recupererActiviteOffre() throws Exception {
        List<OffreVoyage> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM offrevoyage");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int nom = resultSet.getInt("idvoyage");
                int desc = resultSet.getInt("idactivite");
                
               OffreVoyage activite = new OffreVoyage(id, nom,desc);
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
      
      
   
      public void modifierActiviteOffre() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("UPDATE offrevoyage SET idactivite = ? and SET  idvoyage = ?  WHERE id = ?");
        statement.setInt(1, this.getIdOffre());
        statement.setInt(2,this.getIdOffre());
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

      public void supprimerActiviteOffre(int id) throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("DELETE FROM offrevoyage WHERE id = ?");
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
