package Atelier2.jsfbeans;


import Atelier2.persistence.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class PanierManagedBean {


    // JPA Code injection

    @Inject
    PanierDao panierDao ;

    private Long id_panier ;

    private User user;

    private List<Produit> produits ;

    public PanierDao getPanierDao() {
        return panierDao;
    }

    public void setPanierDao(PanierDao panierDao) {
        this.panierDao = panierDao;
    }

    public Long getId_panier() {
        return id_panier;
    }

    public void setId_panier(Long id_panier) {
        this.id_panier = id_panier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
// actions

    public void save(){

        panierDao.save(new Panier( this.user , (Prod) this.produits));
    }

    public List<Panier> paniers(){

        return panierDao.getAll();
    }


    public void delete(Long id ){

        panierDao.delete( panierDao.getOne(id) );
    }



}
