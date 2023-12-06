package Atelier2.jsfbeans;



import Atelier2.persistence.Produit;
import Atelier2.persistence.ProduitDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class produitManagedBean {


    // JPA Code injection

    @Inject
    ProduitDao produitDao ;


    private Long id_produit ;

    private String nom ;


    private Double prix ;
    public Long getId_produit() {return id_produit;}


    public void setId_produit(Long id_produit) {this.id_produit = id_produit;}

    public void setNom(String nom) {this.nom = nom;}
    public String getNom() {return nom;}


    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {this.prix = prix;}


    // actions

    public void save(){
        produitDao.save(new Produit(this.nom , this.prix));
    }

    public List<Produit> produits(){
        return produitDao.getAll();
    }


    public void delete(Double id ){

        produitDao.delete( produitDao.getOne(id) );
    }



}
