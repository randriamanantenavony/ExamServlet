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
public class ActiviteVoyage {
    int id;
    int idVoyage;
    int idActiviteVoyage;
    String nomActivite;

    public String getNomActivite() {
        return nomActivite;
    }

    public void setNomActivite(String nomActivite) {
        this.nomActivite = nomActivite;
    }
    
    

    public int getId() {
        return id;
    }

     public void setId(String id) {
        this.id = Integer.parseInt(id);
    } 
     
    public void setId(int id) {
        this.id = id;
    }

    public int getIdVoyage() {
        return idVoyage;
    }

     public void setIdVoyage(String idVoyage) {
        this.idVoyage = Integer.parseInt(idVoyage);
    }

    
    public void setIdVoyage(int idVoyage) {
        this.idVoyage = idVoyage;
    }

    public int getIdActiviteVoyage() {
        return idActiviteVoyage;
    }
    
      public void setIdActiviteVoyage(String idActiviteVoyage) {
        this.idActiviteVoyage = Integer.parseInt(idActiviteVoyage);
    }

    public void setIdActiviteVoyage(int idActiviteVoyage) {
        this.idActiviteVoyage = idActiviteVoyage;
    }

    public ActiviteVoyage(int id, int idVoyage, int idActiviteVoyage) {
        this.id = id;
        this.idVoyage = idVoyage;
        this.idActiviteVoyage = idActiviteVoyage;
    }

    public ActiviteVoyage(int id) {
        this.id = id;
    }
    
    
    

    public ActiviteVoyage(int id, int idVoyage, int idActiviteVoyage,String nomactivite) {
        this.id = id;
        this.idVoyage = idVoyage;
        this.idActiviteVoyage = idActiviteVoyage;
        this.nomActivite = nomactivite;
    }

    public ActiviteVoyage(int idVoyage, int idActiviteVoyage) {
        this.idVoyage = idVoyage;
        this.idActiviteVoyage = idActiviteVoyage;
    }
    
       public ActiviteVoyage(String idVoyage, String idActiviteVoyage,String nomActivite) {
           setIdVoyage(idVoyage);
           setIdActiviteVoyage(idActiviteVoyage);
           setNomActivite(nomActivite);
       
    }
    
       public ActiviteVoyage getById() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int id = 0;
        ActiviteVoyage ac = null;
        try {
             
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * from activitevoyage where id = ?");
            statement.setInt(1,this.getId());
          
            
            result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
                int idV = result.getInt("idvoyage");
                int idA = result.getInt("idactivite");
                ac = new ActiviteVoyage(id,idV,idA);
                
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
        return ac;
}
    
       public void insererActivity() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO activitevoyage (id, idvoyage,idactivite) VALUES (default, ?,?)");
            statement.setInt(1, this.getIdVoyage());
            statement.setInt(2, this.getIdActiviteVoyage());
            
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
     
      public static List<ActiviteVoyage> recupererActiviteVoyage() throws Exception {
        List<ActiviteVoyage> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM v_detail_activite");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int nom = resultSet.getInt("idvoyage");
                int desc = resultSet.getInt("idactivite");
                String nomA = resultSet.getString("nom");
                
               ActiviteVoyage activite = new ActiviteVoyage(id, nom,desc,nomA);
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
      
      
   
      public void modifierActiviteVoyage() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("UPDATE activitevoyage SET idactivite = ?,idvoyage = ?  WHERE id = ?");
        statement.setInt(1, this.getIdActiviteVoyage());
        statement.setInt(2,this.getIdVoyage());
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

      public  void supprimerActiviteVoyage() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("DELETE FROM activitevoyage WHERE id = ?");
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
