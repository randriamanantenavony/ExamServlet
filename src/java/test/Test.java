/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import models.Activite;
import models.ActiviteVoyage;
import models.Administrateur;
import models.Voyage;

/**
 *
 * @author itu
 */
public class Test {
    
    public static void main(String[] args) throws Exception{
    
//            int id = 3;
            String nom = "Sitraka";
            String mail = "sitraka@gmail.com";
            String mdp ="sitraka";
    
//            Administrateur admin = new Administrateur(id);
    
//            List<Administrateur> list = Administrateur.getAll();
//            
//            for(Administrateur admins : list){
//                
//             System.out.println(admins.getNom());
//            }

//            String request = "camping";
//            String desc = "profitez du plein air en famille";
//        
//         
//           
//             Activite a = new Activite(request,desc);
//             
//             int id = a.getById();
//             System.out.println(id);
              
                        
//            List<ActiviteVoyage> v = ActiviteVoyage.recupererActiviteVoyage();
//            for(ActiviteVoyage voyage : v){
//              System.out.println(voyage.getNomActivite());
//            }

            int id = 11;
            int idVoyage = 3;
            int idActivite=4;
            ActiviteVoyage v = new ActiviteVoyage(id,idVoyage,idActivite);
            
           v.modifierActiviteVoyage();
               
    }
   
   
    
}
