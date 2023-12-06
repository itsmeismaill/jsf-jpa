package Atelier2.persistence;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.io.IOException;
import java.util.List;

@RequestScoped
@ManagedBean
public class UserDaoImp implements UserDao{


    EntityManagerFactory emf ;

    EntityManager em ;

    Query query ;


    public UserDaoImp(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }



    @Override
    public void save(User obejct) {

        em.getTransaction().begin();
        em.persist(obejct);
        em.getTransaction().commit();
    }

    @Override
    public void update(User obejct) {

    }

    @Override
    public void delete(User obejct) {
        em.getTransaction().begin();
        em.remove(obejct);
        em.getTransaction().commit();
    }

    @Override
    public User getOne(Long id) {

        query = em.createQuery( "select user from User user where user.id_user =:id") ;
        query.setParameter("id" , id);
        return (User) query.getSingleResult();
    }

    @Override
    public List<User> getAll() {
        query = em.createQuery( "select user from User user") ;
        return query.getResultList();
    }

    @Override
    public boolean authenticate(String username, String password) throws IOException {
        query = em.createQuery( "select user from User user where user.username =:username and user.password =:password") ;
        query.setParameter("username" , username);
        query.setParameter("password" , password);
        System.out.println(query.getResultList());
        if(query.getResultList().size() > 0){
            FacesContext.getCurrentInstance().getExternalContext().redirect("prod.xhtml");
        }
        return query.getResultList().size() > 0;
    }
    public Panier getPanier(Long id) {
        query = em.createQuery( "select panier from Panier panier where panier.user.id_user =:id") ;
        query.setParameter("id" , id);
        return (Panier) query.getSingleResult();
    }
    public List<Prod> getProduits(Long id) {
        query = em.createQuery( "select prod from Prod prod where prod.id_panier =:id") ;
        query.setParameter("id" , id);
        return query.getResultList();
    }
    public void addProduit(Long id_user, Long id_prod) {
        query = em.createQuery( "select panier from Panier panier where panier.user.id_user =:id") ;
        query.setParameter("id" , id_user);
        Panier panier = (Panier) query.getSingleResult();
        Prod prod = em.find(Prod.class, id_prod);
        prod.setId_panier(panier.getId_panier());
        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();
    }
}
