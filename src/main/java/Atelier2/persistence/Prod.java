package Atelier2.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "prod")
public class Prod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prod ;

    private String nom ;

    private Integer prix ;

    private Long id_panier ;

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Long getId_panier() {
        return id_panier;
    }

    public void setId_panier(Long id_panier) {
        this.id_panier = id_panier;
    }

    public Prod() {
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id_etudiant=" + id_prod +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }


    public Prod(Long id, String nom, Integer prix) {
        this.id_prod = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Prod(String nom, Integer prix) {

        this.nom = nom;
        this.prix = prix;
    }

    public Long getId_prod() {
        return id_prod;
    }

    public void setId_prod(Long id) {
        this.id_prod = id;
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

    public void setAge(Integer prix) {
        this.prix = prix;
    }
}
