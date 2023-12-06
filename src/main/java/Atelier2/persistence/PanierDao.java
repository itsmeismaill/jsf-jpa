package Atelier2.persistence;

import java.util.List;


public interface PanierDao {
    public abstract void  save(Panier obejct );
    public abstract void  update(Panier obejct );
    public abstract void  delete(Panier obejct );
    public abstract Panier getOne(Long id );

    public abstract List<Panier> getAll();

    public abstract List<Prod> getProuduits(Long id );

}
