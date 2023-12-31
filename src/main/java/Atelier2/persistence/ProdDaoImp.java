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
public class ProdDaoImp implements ProdDao{


    EntityManagerFactory emf ;

    EntityManager em ;

    Query query ;


    public ProdDaoImp(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }



    @Override
    public void save(Prod obejct) {

        em.getTransaction().begin();
        em.persist(obejct);
        em.getTransaction().commit();
    }

    @Override
    public void update(Prod obejct) {

    }

    @Override
    public void delete(Prod obejct) {
        em.getTransaction().begin();
        em.remove(obejct);
        em.getTransaction().commit();
    }

    @Override
    public Prod getOne(Long id) {

        query = em.createQuery( "select prod from Prod prod where prod.id_prod =:id") ;
        query.setParameter("id" , id);
        return (Prod) query.getSingleResult();
    }

    @Override
    public List<Prod> getAll() {
        query = em.createQuery( "select prod from Prod prod") ;
        return query.getResultList();
    }
}
