package Atelier2.persistence;

import java.util.List;


public interface  EtudiantDao {
    public abstract void  save(Etudiant obejct );
    public abstract void  update(Etudiant obejct );
    public abstract void  delete(Etudiant obejct );
    public abstract Etudiant getOne(Long id );

    public abstract List<Etudiant> getAll();

}
