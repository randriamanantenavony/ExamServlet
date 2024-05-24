/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;

/**
 *
 * @author SAROBIDY
 */
public class ViewModel {
    List<Activite> activites;
    List<Categorie> categories;
    List<Destination> destination;
  

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public List<Destination> getDestination() {
        return destination;
    }

    public void setDestination(List<Destination> destination) {
        this.destination = destination;
    }

    public ViewModel(List<Activite> activites, List<Categorie> categories, List<Destination> destination) {
        this.activites = activites;
        this.categories = categories;
        this.destination = destination;
    }
    
    
}
