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

/**
 *
 * @author SAROBIDY
 */
public class Offre {
    int id;
    int idCategorie;
    int idDestination;
    Date debut;
    Date fin;
    String description;
    String nomDestination;
    String nomCategorie;
    Double prix;

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

    
    public Offre(int idDestination, Date debut, Date fin, String description, Double prix) {
        this.idDestination = idDestination;
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.prix = prix;
    }

    public Offre(int id, int idDestination, Date debut, Date fin, String description, Double prix,int i) {
        this.id = id;
        this.idDestination = idDestination;
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.prix = prix;
        this.idCategorie = id;
    }
    
      public Offre(String idDestination,String  debut,String fin, String description,String prix,String idCategorie) {
          setIdDestination(idDestination);
          setDebut(debut);
          setFin(fin);
          setDescription(description);
          setPrix(prix);
          setIdCategorie(idCategorie);
    }

    public Offre(Date debut, Date fin, String description, String nomDestination, String nomCategorie, Double prix) {
        this.debut = debut;
        this.fin = fin;
        this.description = description;
        this.nomDestination = nomDestination;
        this.nomCategorie = nomCategorie;
        this.prix = prix;
    }
    
   
    
 public int insererOffre() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    int idOffre = -1; // Initialisation à une valeur par défaut pour gérer les cas d'erreur

    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("INSERT INTO offre(id, destination, debut, fin, description, prix,idcategorie) VALUES (default, ?, ?, ?, ?, ?,?)", Statement.RETURN_GENERATED_KEYS);
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
                idOffre = resultSet.getInt(1); // Récupérer l'ID du voyage généré
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
    return idOffre; // Retourner l'ID du voyage inséré
}

     
      public static List<Offre> recupererOffre() throws Exception {
        List<Offre> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM offre");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idDestination = resultSet.getInt("destination");
                Date debut = resultSet.getDate("debut");
                Date fin = resultSet.getDate("fin");
                String description = resultSet.getString("description");
                double prix = resultSet.getDouble("prix");
                int idcategorie = resultSet.getInt("idcategorie");
                
               Offre activite = new Offre(id,idDestination,debut,fin,description,prix,idcategorie);
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
      
      
        public static List<Offre> recupererOffreDetails() throws Exception {
        List<Offre> activites = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            conn = DbConnection.getConnection();
            statement = conn.prepareStatement("SELECT * FROM v_detail_offre");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                Date debut = resultSet.getDate("debut");
                Date fin = resultSet.getDate("fin");
                String description = resultSet.getString("description");
                double prix = resultSet.getDouble("prix");
                String nomCategorie = resultSet.getString("nomcategorie");
                
               Offre activite = new Offre(debut,fin,description,nom,nomCategorie,prix);
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
      
      
   
      public void modifierOffre() throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
            statement = conn.prepareStatement("UPDATE offre SET destination = ? and SET  debut = ? and SET  fin = ?  and SET  description = ?  and SET  prix = ?  WHERE id = ?");
            statement.setInt(1, this.getIdDestination());
            statement.setDate(2, this.getDebut());
            statement.setDate(3, this.getFin());
            statement.setString(4, this.getDescription());
            statement.setDouble(5,this.getPrix());
            statement.setInt(6, this.getId());
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

      public void supprimerOffre(int id) throws Exception {
    Connection conn = null;
    PreparedStatement statement = null;
    try {
        conn = DbConnection.getConnection();
        statement = conn.prepareStatement("DELETE FROM offre WHERE id = ?");
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
