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
public class PanierDaoImp implements PanierDao{


    EntityManagerFactory emf ;

    EntityManager em ;

    Query query ;


    public PanierDaoImp(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }



    @Override
    public void save(Panier obejct) {

        em.getTransaction().begin();
        em.persist(obejct);
        em.getTransaction().commit();
    }

    @Override
    public void update(Panier obejct) {

    }

    @Override
    public void delete(Panier obejct) {
        em.getTransaction().begin();
        em.remove(obejct);
        em.getTransaction().commit();
    }

    @Override
    public Panier getOne(Long id) {

        query = em.createQuery( "select panier from Panier panier where panier.user.id_user =:id") ;
        query.setParameter("id" , id);
        return (Panier) query.getSingleResult();
    }

    @Override
    public List<Panier> getAll() {
        query = em.createQuery( "select panier from Panier panier") ;
        return query.getResultList();
    }
    public List<Prod> getProuduits(Long id ) {
        query = em.createQuery( "select prod from Prod prod where prod.id_panier =:id") ;
        query.setParameter("id" , id);
        return query.getResultList();
    }
}
