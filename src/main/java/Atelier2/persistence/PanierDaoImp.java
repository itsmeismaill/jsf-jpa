package Atelier2.persistence;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

@RequestScoped
@ManagedBean
public class EtudiantDaoImp implements EtudiantDao{


    EntityManagerFactory emf ;

    EntityManager em ;

    Query query ;


    public EtudiantDaoImp(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }



    @Override
    public void save(Etudiant obejct) {

        em.getTransaction().begin();
        em.merge(obejct);
        em.getTransaction().commit();
    }

    @Override
    public void update(Etudiant obejct) {

    }

    @Override
    public void delete(Etudiant obejct) {
        em.getTransaction().begin();
        em.remove(obejct);
        em.getTransaction().commit();
    }

    @Override
    public Etudiant getOne(Long id) {

        query = em.createQuery( "select etudiant from Etudiant etudiant where etudiant.id_etudiant =:id") ;
        query.setParameter("id" , id);
        return (Etudiant) query.getSingleResult();
    }

    @Override
    public List<Etudiant> getAll() {
        query = em.createQuery( "select etudiant from Etudiant etudiant") ;
        return query.getResultList();
    }
}
