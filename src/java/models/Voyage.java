/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAROBIDY
 */
public class Voyage {
    int id;
    int idCategorie;
    int idDestination;
    Date debut;
    Date fin;
    String description;
    Double prix;
    String nomDestination;
    String nomCategorie;

    public String getNomDestination() {
        return nomDestination;
    }

    public void setNomDestination(String nomDestination) {
        this.nomDestination = nomDestination;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    
    

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = Integer.parseInt(idCategorie);
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

    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(String idDestination) {
        this.idDestination = Integer.parseInt(idDestination);
    }

    public Date getDebut() {
        return debut;
    }

      public void setDebut(String debut) {
            try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateUtil = sdf.parse(debut);
            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());

            this.debut = dateSql;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Date getFin() {
        return fin;
    }

    public void setFin(String fin) {
            try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateUtil = sdf.parse(fin);
            java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());

            this.fin = dateSql;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = Double.parseDouble(prix);
    }

    
    public Voyage(int idDestination, Date debut, Date fin, String description, Double prix) {
        this.idDestination = idDestination;
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.prix = prix;
    }

    public Voyage(int id, int idDestination, Date debut, Date fin, String description, Double prix) {
        this.id = id;
        this.idDestination = idDestination;
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.prix = prix;
    }
    
      public Voyage(String idDestination,String  debut,String fin, String description,String prix,String idCategorie) {
          setIdDestination(idDestination);
          setDebut(debut);
          setFin(fin);
          setDescription(description);
          setPrix(prix);
          setIdCategorie(idCategorie);
    }
      
        public Voyage(String id,String idDestination,String  debut,String fin, String description,String prix,String idCategorie) {
            setId(id);
          setIdDestination(idDestination);
          setDebut(debut);
          setFin(fin);
          setDescription(description);
          setPrix(prix);
          setIdCategorie(idCategorie);
    }

    public Voyage(Date debut, Date fin, String description, Double prix, String nomDestination, String nomCategorie) {
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.prix = prix;
        this.nomDestination = nomDestination;
        this.nomCategorie = nomCategorie;
    }

    public Voyage(int id, Date debut, Date fin, String description, Double prix, String nomDestination, String nomCategorie) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.prix = prix;
        this.nomDestination = nomDestination;
        this.nomCategorie = nomCategorie;
    }
    
    

    public Voyage(int id) {
        this.id = id;
    }

    public Voyage(String idDestination, String debut, String fin, String prix) {
        setIdDestination(idDestination);
        setDebut(debut);
        setFin(fin);
        setPrix(prix);
    }
    
    
   
      public int getById() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        int id = 0;
        try {
             
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT id FROM voyage WHERE destination = ? AND debut = ? and fin = ? and prix = ?");
            statement.setInt(1,this.getIdDestination());
            statement.setDate(2, this.getDebut());
            statement.setDate(3, this.getFin());
            statement.setDouble(4,this.getPrix());
            
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
      
        public Voyage getVoyageById() throws ClassNotFoundException, Exception {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        Voyage v = null;
        
        try {
             
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM voyage WHERE id = ?");
            statement.setInt(1,this.getId());
           
           
            result = statement.executeQuery();
            if (result.next()) {
                id = result.getInt("id");
                int idDestination=result.getInt("destination");
                Date debut = result.getDate("debut");
                Date fin = result.getDate("fin");
                String description = result.getString("description");
                Double prix = result.getDouble("prix");
                int ic = result.getInt("idcategorie");
                
                v = new Voyage(id,idDestination,debut,fin,description,prix);
                
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
        return v;
}

    public Voyage(int id, int idCategorie, int idDestination, Date debut, Date fin, String description, Double prix) {
        this.id = id;
        this.idCategorie = idCategorie;
        this.idDestination = idDestination;
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.prix = prix;
    }
    
 public int insererVoyage() {
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    int idVoyage = -1; // Initialisation à une valeur par défaut pour gérer les cas d'erreur

    try {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(Voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
        statement = conn.prepareStatement("INSERT INTO voyage(id, destination, debut, fin, description, prix,idcategorie) VALUES (default, ?, ?, ?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, this.getIdDestination());
        statement.setDate(2, this.getDebut());
        statement.setDate(3, this.getFin());
        statement.setString(4, this.getDescription());
        statement.setDouble(5, this.getPrix());
        statement.setInt(6, this.getIdCategorie());

        int rowsAffected = statement.executeUpdate();
        
        // Vérifier si l'insertion a réussi et s'il y a une clé générée
        if (rowsAffected > 0) {
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                idVoyage = resultSet.getInt(1); // Récupérer l'ID du voyage généré
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Fermeture des ressources dans le bloc finally
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
    return idVoyage; // Retourner l'ID du voyage inséré
}

     
      public static List<Voyage> recupererVoyage() throws Exception {
        List<Voyage> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM voyage");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idDestination = resultSet.getInt("destination");
                Date debut = resultSet.getDate("debut");
                Date fin = resultSet.getDate("fin");
                String description = resultSet.getString("description");
                double prix = resultSet.getDouble("prix");
                
               Voyage activite = new Voyage(id,idDestination,debut,fin,description,prix);
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
      
      
        public static List<Voyage> recupererVoyageDetails() throws Exception {
        List<Voyage> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM v_detail_voyage");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom_destination");
                Date debut = resultSet.getDate("debut");
                Date fin = resultSet.getDate("fin");
                String description = resultSet.getString("description");
                double prix = resultSet.getDouble("prix");
                String nomCategorie= resultSet.getString("nomcategorie");
                
               Voyage activite = new Voyage(id,debut,fin,description,prix,nom,nomCategorie);
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
      
         public static List<Voyage> recupererVoyageDetailsWithCondition(String debut, String fin, String price) throws ParseException, Exception {
             
        List<Voyage> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        Double prix = Double.parseDouble(price);
         
        
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateUtil = sdf.parse(fin);
            java.sql.Date dateSqlFin = new java.sql.Date(dateUtil.getTime());
            
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dateUtil1 = sdf.parse(debut);
            java.sql.Date dateSqlDebut = new java.sql.Date(dateUtil1.getTime());
            
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM v_detail_voyage where prix <= ? and debut >= ? and fin <= ?");
            
            statement.setDouble(1, prix);
            statement.setDate(2, dateSqlDebut);
            statement.setDate(3, dateSqlFin);
            
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String nom = resultSet.getString("nom_destination");
                Date debut1 = resultSet.getDate("debut");
                Date fin1 = resultSet.getDate("fin");
                String description = resultSet.getString("description");
                double prix1 = resultSet.getDouble("prix");
                String nomCategorie= resultSet.getString("nomcategorie");
                
               Voyage activite = new Voyage(debut1,fin1,description,prix1,nom,nomCategorie);
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
      
      
   
      public void modifierVoyage() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
            statement = conn.prepareStatement("UPDATE voyage SET destination = ?,debut = ? ,fin = ?,description = ? ,prix = ?,idcategorie=?  WHERE id = ?");
            statement.setInt(1, this.getIdDestination());
            statement.setDate(2, this.getDebut());
            statement.setDate(3, this.getFin());
            statement.setString(4, this.getDescription());
            statement.setDouble(5,this.getPrix());
            statement.setInt(6, this.getId());
            statement.setInt(7, this.getIdCategorie());
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

      public void supprimerVoyage(int id) throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("DELETE FROM voyage  WHERE id = ?");
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
