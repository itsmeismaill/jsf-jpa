package Atelier2.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etudiant ;

    private String nom ;

    public Etudiant() {
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id_etudiant=" + id_etudiant +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }

    private Integer age ;

    public Etudiant(Long id_etudiant, String nom, Integer age) {
        this.id_etudiant = id_etudiant;
        this.nom = nom;
        this.age = age;
    }

    public Etudiant( String nom, Integer age) {

        this.nom = nom;
        this.age = age;
    }

    public Long getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(Long id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
