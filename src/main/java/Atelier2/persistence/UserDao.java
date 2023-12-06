package Atelier2.persistence;

import java.io.IOException;
import java.util.List;


public interface UserDao {
    public abstract void  save(User obejct );
    public abstract void  update(User obejct );
    public abstract void  delete(User obejct );
    public abstract User getOne(Long id );

    public abstract List<User> getAll();
    public abstract Panier getPanier(Long id );
    boolean authenticate(String username, String password) throws IOException;
    public List<Prod> getProduits(Long id);
    public void addProduit(Long id_user, Long id_prod);
}
