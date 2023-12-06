package Atelier2.persistence;


import jakarta.persistence.*;


@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produit ;
    private String nom ;
    private Double prix ;
    public Produit() {
    }
    public Produit(long id  , String nom , Double prix) {
        this.id_produit = id;
        this.nom = nom ;
        this.prix = prix ;
    }
    public Produit( String nom , Double prix) {

        this.nom = nom;
        this.prix = prix ;
    }
    @Override
    public String toString() {
        return "Produit{" +
                "id_produit=" + id_produit +
                ", nom='" + nom + '\'' +
                ", prix='" + prix +
                '}';
    }
    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrix(Double Prix) {
        this.prix = Prix;
    }

    public  String getNom(){
        return  nom ;
    }
    public  Long getId_produit(){
        return  id_produit ;
    }
    public  Double getPrix(){
        return  prix ;
    }


}
