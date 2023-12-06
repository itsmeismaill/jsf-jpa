package Atelier2.persistence;

import java.util.List;


public interface ProdDao {
    public abstract void  save(Prod obejct );
    public abstract void  update(Prod obejct );
    public abstract void  delete(Prod obejct );
    public abstract Prod getOne(Long id );

    public abstract List<Prod> getAll();

}
