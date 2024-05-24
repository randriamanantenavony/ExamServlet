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
public class Activite {
    int id;
    String nom;
    String desc;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Activite(int id, String nom, String desc) {
        this.id = id;
        this.nom = nom;
        this.desc = desc;
    }

    public Activite(String nom, String desc) {
        this.nom = nom;
        this.desc = desc;
    }

    public Activite(int id) {
        this.id = id;
    }
    
       public int getById() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int id = 0;
        try {
             
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT id FROM activite WHERE nom = ? AND description = ?");
            statement.setString(1, this.getNom());
            statement.setString(2, this.getDesc());
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
       
         public Activite getActiviteById() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Activite activite = null;
        
        try {
             
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM activite WHERE id = ?");
            statement.setInt(1, this.getId());
           
            
            result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
                String nom = result.getString("nom");
                String desc = result.getString("description");
             
                activite = new Activite(id,nom,desc);
                
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
        return activite;
}
    
         public void insererActivity() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO activite(nom,description) VALUES (?,?)");
            statement.setString(1, this.getNom());
            statement.setString(2, this.getDesc());
            
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
     
      public static List<Activite> recupererActivite() throws Exception {
        List<Activite> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM activite");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String desc = resultSet.getString("description");
                
               Activite activite = new Activite(id, nom,desc);
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
      
      
   
      public void modifierActivite() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("UPDATE activite SET nom = ? ,description = ?  WHERE id = ?");
        statement.setString(1, this.getNom());
        statement.setString(2, this.getDesc());
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

      public void delete() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("DELETE FROM activite WHERE id = ?");
        statement.setInt(1, this.getId());
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
