package Atelier2.jsfbeans;


import Atelier2.persistence.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.util.List;

@Named
@RequestScoped
public class userManagedBean {


    // JPA Code injection

    @Inject
    UserDao userDao ;

    private Long id_user ;

    private String username ;
    private String email ;

    private String password ;

    private List<Produit> produits ;

    private PanierManagedBean panier ;

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // actions

    public void save(){

        userDao.save(new User( this.username, this.email , this.password));
    }

    public List<User> Users(){

        return userDao.getAll();
    }


    public void delete(Long id ){

        userDao.delete( userDao.getOne(id) );
    }

    public void authenticate() throws IOException {
        userDao.authenticate(this.username, this.password);

        System.out.println("Authentication method called!");
    }
    public void addProduit(Produit produit) {
        this.produits.add(produit);
        panier.setProduits(this.produits);
    }

}
