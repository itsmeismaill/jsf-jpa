package atelier2.atelier22.jsfbeans;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import Atelier2.persistence.Etudiant;
import Atelier2.persistence.EtudiantDao;

import java.util.List;

@Named
@RequestScoped
public class etudiantManagedBean {


    // JPA Code injection

    @Inject
    EtudiantDao etudiantDao ;


    private Long id_etudiant ;

    private String nom ;


    private Integer age ;

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


    // actions

    public void save(){

        etudiantDao.save(new Etudiant( this.nom , this.age));
    }

    public List<Etudiant> etudiants(){

        return etudiantDao.getAll();
    }


    public void delete(Long id ){

        etudiantDao.delete( etudiantDao.getOne(id) );
    }



}
