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
 * @author itu
 */
public class Administrateur {
    int id;
    String nom;
    String mail;
    String mdp;

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Administrateur(String mail, String mdp) {
        this.mail = mail;
        this.mdp = mdp;
    }

    public Administrateur(String nom, String mail, String mdp) {
        this.nom = nom;
        this.mail = mail;
        this.mdp = mdp;
    }
    
    

    public Administrateur(int id, String nom, String mail, String mdp) {
        this.id = id;
        this.nom = nom;
        this.mail = mail;
        this.mdp = mdp;
    }

    public Administrateur(int id) {
        this.id = id;
    }
    
    
    
    
       public int getById() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int id = 0;
        try {
             
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT id FROM administrateur WHERE mail = ? AND mdp = ?");
            statement.setString(1, this.getMail());
            statement.setString(2, this.getMdp());
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
       
         public Administrateur getAdminById() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Administrateur admin = null;
        
        try {
             
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM administrateur WHERE id = ?");
            statement.setInt(1, this.getId());
          
            result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
                String nom = result.getString("nom");
                String mail = result.getString("mail");
                String mdp = result.getString("mdp");
                
                admin = new Administrateur(id,nom,mail,mdp);
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
        return admin;
}
            
       
       
      public static List<Administrateur> getAll() throws Exception {
        List<Administrateur> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM administrateur");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String mail = resultSet.getString("mail");
                String mdp = resultSet.getString("mdp");
                
               Administrateur admin = new Administrateur(id, nom,mail,mdp);
                activites.add(admin);
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
      
      
      public void save() throws Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("INSERT INTO administrateur(id, nom,mail,mdp) VALUES (default, ?,?,?)");
            statement.setString(1, this.getNom());
            statement.setString(2, this.getMail());
            statement.setString(3, this.getMdp());
            
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
     
      public void update() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement(" UPDATE administrateur SET nom = ? ,mail = ?, mdp =?  WHERE id = ?");
        statement.setString(1, this.getNom());
        statement.setString(2, this.getMail());
        statement.setString(3, this.getMdp());
         statement.setInt(4, this.getId());
        
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
        statement = conn.prepareStatement("DELETE FROM administrateur WHERE id = ?");
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
