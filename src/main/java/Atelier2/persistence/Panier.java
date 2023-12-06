package Atelier2.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_panier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_prod")
    private Prod prod;

    public Panier() {
    }

    public Long getId_panier() {
        return id_panier;
    }

    public void setId_panier(Long id_panier) {
        this.id_panier = id_panier;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Prod getProd() {
        return prod;
    }

    public void setProd(Prod prod) {
        this.prod = prod;
    }

    public Panier(User user, Prod prod) {
        this.user = user;
        this.prod = prod;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Panier{" +
                "id_panier=" + id_panier +
                ", user=" + user +
                ", prod=" + prod +
                '}';
    }

}

