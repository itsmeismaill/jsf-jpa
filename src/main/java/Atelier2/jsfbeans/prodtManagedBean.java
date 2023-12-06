package Atelier2.jsfbeans;



import Atelier2.persistence.Prod;
import Atelier2.persistence.ProdDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class prodtManagedBean {


    // JPA Code injection

    @Inject
    ProdDao prodDao ;


    private Long id_prod ;

    private String nom ;


    private Integer prix ;
    private List<Prod> prods ;

    public ProdDao getProdDao() {
        return prodDao;
    }

    public void setProdDao(ProdDao prodDao) {
        this.prodDao = prodDao;
    }

    public List<Prod> getProds() {
        return prods;
    }

    public void setProds(List<Prod> prods) {
        this.prods = prods;
    }

    public Long getId_prod() {
        return id_prod;
    }

    public void setId_prod(Long id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }


    // actions

    public void save(){

        prodDao.save(new Prod( this.id_prod ,this.nom , this.prix));
    }

    public List<Prod> prods(){

        return prodDao.getAll();
    }


    public void delete(Long id ){

        prodDao.delete( prodDao.getOne(id) );
    }



}
