package Atelier2.persistence;

import java.util.List;

public interface ProduitDao {

    public abstract void save(Produit obejct) ;

    public abstract void  update(Produit obejct );
    public  void  delete(Produit obejct );
    public abstract Produit getOne(Double id );

    public abstract List<Produit> getAll();
}
