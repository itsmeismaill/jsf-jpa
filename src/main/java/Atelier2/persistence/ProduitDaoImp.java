package Atelier2.persistence;
import jakarta.persistence.*;
import java.util.List;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@ManagedBean
public class ProduitDaoImp implements ProduitDao {
    EntityManagerFactory emf ;

    EntityManager em ;

    Query query ;

    public ProduitDaoImp(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public void save(Produit obejct) {
        em.getTransaction().begin();
        em.persist(obejct);
        em.getTransaction().commit();

    }

    public void update(Produit obejct) {

    }

    public void delete(Produit obejct) {
        em.getTransaction().begin();
        em.remove(obejct);
        em.getTransaction().commit();

    }

    public Produit getOne(Double id) {
        query = em.createQuery( "select produit from Produit produit where produit.id_produit =:id") ;
        query.setParameter("id" , id);
        return (Produit) query.getSingleResult();    }

    public List<Produit> getAll() {
        query = em.createQuery( "select produit from Produit produit") ;
        return query.getResultList();    }
}
